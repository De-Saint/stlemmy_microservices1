package com.stlemmy.currencyexchangeservice.service;

import com.stlemmy.currencyexchangeservice.entity.Exchange;
import com.stlemmy.currencyexchangeservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;


    public Exchange findExchangeByFromAndTo(String fromCurrency, String toCurrency) {

        return exchangeRepository.findByFromAndTo(fromCurrency, toCurrency);

    }
}
