package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrice.Carpet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CarpetVA implements Carpet {
    private static final Map<City, BigDecimal> sqPriceForCity= new HashMap<>();
    static{
        sqPriceForCity.put(City.ARLINGTON, new BigDecimal("4.32"));
        sqPriceForCity.put(City.FAIRFAX, new BigDecimal("2.50"));
        sqPriceForCity.put(City.MCLEAN, new BigDecimal("1.30"));

    }
    @Override
    public BigDecimal getSqFtPrice(City city) {
        BigDecimal defaultValue=BigDecimal.ZERO;
        Optional<Map.Entry<City, BigDecimal>> collect =
                sqPriceForCity.entrySet().stream().filter(sq->sq.getKey()==city).findFirst();
        return collect.isPresent()?collect.get().getValue() : defaultValue;
//        return collect.get().getValue();
//        return sqPriceForCity.entrySet().stream().filter(sq->sq.getKey()==city).findFirst().get().getValue();
//        return sqPriceForCity.get(city);

    }
}
