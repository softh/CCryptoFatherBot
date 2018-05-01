package com.softhapps.bot.core.api;

import com.softhapps.bot.ApplicationProperties;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author softh
 */
public class CurrencyApiFactory {

    public static CurrencyApi getInstance() throws ApiException {
        String apiUrl = ApplicationProperties.CURRENCY_API_URL;

        Retrofit retrofitInstance = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitInstance.create(CurrencyApi.class);
    }
}
