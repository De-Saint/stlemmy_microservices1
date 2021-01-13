package com.stlemmy.currencyconversionservice.controller;

import com.stlemmy.currencyconversionservice.entity.Conversion;
import com.stlemmy.currencyconversionservice.proxy.ExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    ExchangeServiceProxy exchangeServiceProxy;


    @GetMapping("/value/from/{from}/to/{to}/quantity/{quantity}")
    public Conversion getConversionAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Conversion response = exchangeServiceProxy.getExchangeValue(from, to);
        return new Conversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

}
