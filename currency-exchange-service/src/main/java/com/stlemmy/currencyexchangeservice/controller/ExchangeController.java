package com.stlemmy.currencyexchangeservice.controller;

import com.stlemmy.currencyexchangeservice.entity.Exchange;
import com.stlemmy.currencyexchangeservice.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {


    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private Environment environment;

    @GetMapping("value/from/{from}/to/{to}")
    public Exchange getExchangeValue(@PathVariable() String from, @PathVariable("to") String to){

        Exchange exchange = exchangeService.findExchangeByFromAndTo(from, to);
        exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchange;

    }


}
