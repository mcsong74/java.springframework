package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrice.Carpet;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetTX implements Carpet {
    private static final Map<City, BigDecimal> sqPriceForCity = new HashMap<>();

    static {
        sqPriceForCity.put(City.AUSTIN, new BigDecimal("2.92"));
        sqPriceForCity.put(City.DALLAS, new BigDecimal("3.50"));
        sqPriceForCity.put(City.SAN_ANTONIO, new BigDecimal("3.20"));

    }

    @Override
    public BigDecimal getSqFtPrice(City city) {
        BigDecimal defaultValue = BigDecimal.ZERO;
        Optional<Map.Entry<City, BigDecimal>> collect =
                sqPriceForCity.entrySet().stream().filter(sq -> sq.getKey() == city).findFirst();
        return collect.isPresent() ? collect.get().getValue() : defaultValue;
//        return collect.get().getValue();
//        return sqPriceForCity.entrySet().stream().filter(sq->sq.getKey()==city).findFirst().get().getValue();
//        return sqPriceForCity.get(city);

    }
}
