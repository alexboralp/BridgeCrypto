/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author alexander
 */
public class FactoryEncryptAlgorithm{
    public enum METODO { AES, DES, NONE, RSA, NEW };

    public static IEncryptAlgorithm create(METODO metodo) {
        if (null != metodo)
            switch (metodo) {
            case AES:
                return new AESEncryptAlgorithm();
            case DES:
                return new DESEncryptAlgorithm();
            case NONE:
                return new NoEncryptAlgorithm();
            case RSA:
                return new RSAEncryptAlgorithm();
            case NEW:
                return new NewEncryptAlgorithmAdaptee();
            default:
                break;
        }
        return create();
    }

    public static IEncryptAlgorithm create() {
        Properties prop = new Properties();
	InputStream input = null;
        String metodo = "";

	try {

            input = new FileInputStream("config");

            // load a properties file
            prop.load(input);
            
            // get the property value
            metodo = prop.getProperty("defaultEncryptAlgorithm");
            
            return (IEncryptAlgorithm)Class.forName(metodo).newInstance();
            
            
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("Error al cargar el archivo de configuración");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("No se encontró el método por defecto " + metodo + ", se intentará DES");
        } catch (InstantiationException ex) {
            System.out.println(ex);
            System.out.println("Error al crear el método por defecto " + metodo + ", se intentará DES");
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        }finally {
            if (input != null) {
                try {
                        input.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
	}
        return new DESEncryptAlgorithm();
    }
    
}
