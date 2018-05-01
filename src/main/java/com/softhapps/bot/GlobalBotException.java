package com.softhapps.bot;

/**
 * Main exception for telegram bot
 *
 * @author softh
 */
public class GlobalBotException extends RuntimeException {

    public GlobalBotException(String message) {
        super(message);
    }

    public GlobalBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
