package com.stlemmy.currencyconversionservice.proxy;

import com.stlemmy.currencyconversionservice.entity.Conversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8001")
@FeignClient(name = "currency-exchange-service")
public interface ExchangeServiceProxy {

    @GetMapping("exchange/value/from/{from}/to/{to}")
    public Conversion getExchangeValue(@PathVariable() String from, @PathVariable("to") String to);

}
