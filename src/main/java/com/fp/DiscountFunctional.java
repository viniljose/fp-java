package com.fp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountFunctional {
    public static void main(String[] args) {
        DiscountFunctional df = new DiscountFunctional();
        df.totalOfDiscountedPrices();
    }

    public void totalOfDiscountedPrices(){
        final List<BigDecimal> priices = Arrays.asList(
                new BigDecimal(10),
                new BigDecimal(30),
                new BigDecimal(17),
                new BigDecimal(20),
                new BigDecimal(15),
                new BigDecimal(18),
                new BigDecimal(45),
                new BigDecimal(12)
        );

        final BigDecimal total = priices
                .stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20))>0)
                .map(price -> price.multiply(BigDecimal.valueOf(.9)))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("total "+total);
    }
}
