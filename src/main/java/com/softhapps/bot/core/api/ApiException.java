package com.softhapps.bot.core.api;

/**
 * An exception for API errors
 * 
 * @author softh
 */
public class ApiException extends Exception {

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
