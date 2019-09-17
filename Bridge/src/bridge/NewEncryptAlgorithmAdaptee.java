/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

/**
 *
 * @author alexander
 */
public class NewEncryptAlgorithmAdaptee implements IEncryptAlgorithm{

    @Override
    public String encrypt(String message, String password) throws Exception {
        NEWEncryptAlgorithm newEncryptAlgorithm = new NEWEncryptAlgorithm();
        
        char chars[];
        
        chars = password.toCharArray();
        
        return newEncryptAlgorithm.encriptar(message, chars);
    }
    
}
