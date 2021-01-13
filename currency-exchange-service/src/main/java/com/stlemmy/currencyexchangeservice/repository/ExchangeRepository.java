package com.stlemmy.currencyexchangeservice.repository;

import com.stlemmy.currencyexchangeservice.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    Exchange findByFromAndTo(String from, String to);

}
