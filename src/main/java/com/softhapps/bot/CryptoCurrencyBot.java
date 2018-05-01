package com.softhapps.bot;

import com.softhapps.bot.core.CryptoCurrency;
import com.softhapps.bot.core.api.ApiException;
import com.softhapps.bot.core.api.CurrencyLoader;
import com.softhapps.bot.utils.KeyboardFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author softh
 */
public class CryptoCurrencyBot extends TelegramLongPollingBot {
    private CurrencyLoader currencyLoader;

    public CryptoCurrencyBot() {
        currencyLoader = new CurrencyLoader();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageText;
            List<CryptoCurrency> currencies;
            try {
                currencies = currencyLoader.loadCurrencyList();
                messageText = currencies.stream()
                        .map(CryptoCurrency::toString)
                        .collect(Collectors.joining("\n----------\n"));
            } catch (ApiException | IOException exception) {
                messageText = "ooops! error!";
            }

            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chatId)
                    .setText(messageText)
                    .setReplyMarkup(KeyboardFactory.createKeyboard());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public String getBotUsername() {
        return ApplicationProperties.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return ApplicationProperties.BOT_TOKEN;
    }


}
