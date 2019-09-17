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
public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorithm;
    
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorithm){
        this.encryptAlgorithm = encryptAlgorithm;
    }

    @Override
    public String encryptMessage(String message, String password) throws Exception {
        return encryptAlgorithm.encrypt(message, password);
    }
    
}
