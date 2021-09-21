package com.fp;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Performs financial calculations with data from a web service.
 */
public class CalculateNAV {

    private Function<String, BigDecimal> priceFinder;


    public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
        priceFinder = aPriceFinder;
    }

    public BigDecimal computeStockWorth(
            final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
        System.out.println(calculateNAV.computeStockWorth("ABCD",1000));
        
        CalculateNAV calculateNAV1 = new CalculateNAV(YahooFinance::getPrice);
        System.out.println("100 shares of google "+calculateNAV1.computeStockWorth("GOOG",100));   
    }

}
