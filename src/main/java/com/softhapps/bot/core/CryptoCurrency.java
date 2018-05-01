package com.softhapps.bot.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model of the course of a crypto currency
 *
 * @author Q-ARE
 */
public class CryptoCurrency {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("price_usd")
    @Expose
    private double priceUsd;

    @SerializedName("market_cap_usd")
    @Expose
    private double marketCapUsd;

    @SerializedName("percent_change_1h")
    @Expose
    private double changePerHour;

    @SerializedName("percent_change_24h")
    @Expose
    private double changePerDay;

    /**
     * for serializer only
     */
    public CryptoCurrency() {
    }

    public CryptoCurrency(String name, String symbol, double priceUsd, double marketCapUsd, double changePerHour,
                          double changePerDay) {
        this.name = name;
        this.symbol = symbol;
        this.priceUsd = priceUsd;
        this.marketCapUsd = marketCapUsd;
        this.changePerHour = changePerHour;
        this.changePerDay = changePerDay;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getMarketCapUsd() {
        return marketCapUsd;
    }

    public double getChangePerHour() {
        return changePerHour;
    }

    public double getChangePerDay() {
        return changePerDay;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) \nprice: $%.4f \nchange per hour: %.2f%%\nchange per day: %.2f%%", name, symbol,
                priceUsd, changePerHour, changePerDay);
    }
}
