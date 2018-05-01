package com.softhapps.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Bot main class
 *
 * @author softh
 */
public class Main {
    public static void main(String... args) {

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new CryptoCurrencyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


}
