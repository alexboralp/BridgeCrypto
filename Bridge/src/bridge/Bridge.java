/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexander
 */
public class Bridge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create(FactoryEncryptAlgorithm.METODO.AES));
        IMessageEncrypt desImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create(FactoryEncryptAlgorithm.METODO.DES));
        IMessageEncrypt noImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create(FactoryEncryptAlgorithm.METODO.NONE));
        IMessageEncrypt rsaImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create(FactoryEncryptAlgorithm.METODO.RSA));
        IMessageEncrypt newImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create(FactoryEncryptAlgorithm.METODO.NEW));
        IMessageEncrypt defaultImpl = new DefaultMessageEncryptImpl(FactoryEncryptAlgorithm.create());
        
        try{
            final String message = "<Persona><Nombre>Oscar Blancarte</Nombre></Persona>";
            
            String messageAES = aesImpl.encryptMessage(message, "HG58YZ3CR9123456");
            System.out.println("messageAES>" + messageAES + '\n');
            
            String messageDES = desImpl.encryptMessage(message, "XMzDdG4DO3CKm2Ix");
            System.out.println("messageDES>" + messageDES + '\n');
            
            String messageNO = noImpl.encryptMessage(message, null);
            System.out.println("messageNO>" + messageNO + '\n');
            
            String messageRSA = rsaImpl.encryptMessage(message, "XMzDdG4DO3CKm2Ix");
            System.out.println("Private + public keys>" + messageRSA + '\n');
            
            String messageNEW = newImpl.encryptMessage(message, "XMzDdG4DO3CKm2Ix");
            System.out.println("messageNEW>" + messageNEW + '\n');
            
            String messageDefault = defaultImpl.encryptMessage(message, "XMzDdG4DO3CKm2Ix");
            System.out.println("messageDefault>" + messageDefault + '\n');
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
