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
public class NEWEncryptAlgorithm {
    public String encriptar(String message, char[] sustitutions) throws Exception{
        for (int i = 0; i < sustitutions.length - 1; i += 2 ) {
            char oldChar = sustitutions[i];
            char newChar = sustitutions[i + 1];
            message = message.replace(oldChar, newChar);
        }
        return message;
    }
}
