package com.softhapps.bot;

import com.softhapps.bot.core.CryptoCurrency;
import com.softhapps.bot.core.api.ApiException;
import com.softhapps.bot.core.api.CurrencyLoader;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.api.methods.groupadministration.GetChatMember;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class TestAbilityBot extends AbilityBot {

    protected TestAbilityBot() {
        super(ApplicationProperties.BOT_TOKEN, ApplicationProperties.BOT_NAME);
    }

    @Override
    public int creatorId() {
        return 159310828; //todo replace
    }

    public Ability saysHelloWorld() {
        return Ability.builder()
                .name("hello") // Name and command (/hello)
                .info("Says hello world!") // Necessary if you want it to be reported via /commands
                .privacy(PUBLIC)  // Choose from Privacy Class (Public, Admin, Creator)
                .locality(ALL) // Choose from Locality enum Class (User, Group, PUBLIC)
                .input(0) // Arguments required for command (0 for ignore)
                .action(ctx -> {
          /*
          ctx has the following main fields that you can utilize:
          - ctx.update() -> the actual Telegram update from the basic API
          - ctx.user() -> the user behind the update
          - ctx.firstArg()/secondArg()/thirdArg() -> quick accessors for message arguments (if any)
          - ctx.arguments() -> all arguments
          - ctx.chatId() -> the chat where the update has emerged
          NOTE that chat ID and user are fetched no matter what the update carries.
          If the update does not have a message, but it has a callback query, the chatId and user will be fetched from that query.
           */
                    // Custom sender implementation
                    silent.send("Hello World!", ctx.chatId());
                })
                .build();
    }

    public Ability sendCurrency() {
        return Ability.builder()
                .name("curr") // Name and command (/hello)
                .info("Says hello world!") // Necessary if you want it to be reported via /commands
                .privacy(PUBLIC)  // Choose from Privacy Class (Public, Admin, Creator)
                .locality(ALL) // Choose from Locality enum Class (User, Group, PUBLIC)
                .input(0) // Arguments required for command (0 for ignore)
                .action(ctx -> {
                    String messageText;
                    List<CryptoCurrency> currencies;
                    try {
                        CurrencyLoader currencyLoader = new CurrencyLoader();
                        currencies = currencyLoader.loadCurrencyList();
                        messageText = currencies.stream()
                                .map(CryptoCurrency::toString)
                                .collect(Collectors.joining("\n----------\n"));
                    } catch (ApiException | IOException exception) {
                        messageText = "ooops! error!";
                    }

                    silent.send(messageText, ctx.chatId());
                })
                .build();
    }

    public Ability randomPidor() {
        return Ability.builder()
                .name("random") // Name and command (/hello)
                .info("") // Necessary if you want it to be reported via /commands
                .privacy(PUBLIC)  // Choose from Privacy Class (Public, Admin, Creator)
                .locality(ALL) // Choose from Locality enum Class (User, Group, PUBLIC)
                .input(0) // Arguments required for command (0 for ignore)
                .action(ctx -> {
                    String messageText = "";
                    GetChatMember getChatMember = new GetChatMember();
                    getChatMember.setChatId(ctx.chatId());


                    silent.send("pidor test: Елизавета Касперович", ctx.chatId());
                })
                .build();
    }
}
