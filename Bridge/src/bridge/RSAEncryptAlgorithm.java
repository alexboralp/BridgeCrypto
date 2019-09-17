/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

/**
 *
 * @author alexander
 */
public class RSAEncryptAlgorithm implements IEncryptAlgorithm{

    @Override
    public String encrypt(String message, String password) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        
        String privateKey = Base64.getEncoder().encodeToString(pair.getPrivate().getEncoded());
        String publicKey = Base64.getEncoder().encodeToString(pair.getPublic().getEncoded());
        
        return privateKey + publicKey;
    }
    
}
