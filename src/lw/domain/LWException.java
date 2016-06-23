/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

/**
 *
 * @author adm
 */
public class LWException extends Exception {

    /**
     * Creates a new instance of <code>LWException</code> without detail
     * message.
     */
    public LWException() {
    }

    /**
     * Constructs an instance of <code>LWException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LWException(String msg) {
        super(msg);
    }
    
    public LWException(String msg, Throwable cause){
        super(msg,cause);
    }
}
