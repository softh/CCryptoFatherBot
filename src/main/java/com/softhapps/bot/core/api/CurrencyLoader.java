package com.softhapps.bot.core.api;

import com.softhapps.bot.core.CryptoCurrency;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author softh
 */
public class CurrencyLoader {

    private static final String[] FILTERING_ARRAY = {"BTC", "ETH", "XRP", "BCH", "EOS", "ADA", "LTC", "TRX", "NEO", "XMR",
            "DASH", "XEM", "ETC", "BNB", "BTG", "ZEC"};

    public CurrencyLoader() {
    }

    public List<CryptoCurrency> loadCurrencyList() throws ApiException, IOException {
        CurrencyApi api = CurrencyApiFactory.getInstance();

        Response<List<CryptoCurrency>> response = api.getData().execute();


        return filter(response.body());
    }

    private List<CryptoCurrency> filter(List<CryptoCurrency> sourceList) {
        Set<String> filters = new HashSet<>(Arrays.asList(FILTERING_ARRAY));

        return sourceList.stream().filter(e -> filters.contains(e.getSymbol())).collect(Collectors.toList());
    }
}
