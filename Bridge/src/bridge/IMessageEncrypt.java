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
public interface IMessageEncrypt {
    public String encryptMessage(String message, String password) throws Exception;
}
