package com.softhapps.bot.core.api;

import com.softhapps.bot.core.CryptoCurrency;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * @author softh
 */
public interface CurrencyApi {
    @GET("/v1/ticker")
    Call<List<CryptoCurrency>> getData();
}