package com.byto.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.byto.model.BusExpedition;


public interface BusExpeditionRepository extends JpaRepository<BusExpedition, Long> {

	 List<BusExpedition> findByFromToAndToFrom(String fromTo,String toFrom);          // Derived Query kullanılarak Şehir bilgisi ile sefer sorgular


	 List<BusExpedition> findByDate(LocalDate date);                                // Derived Query kullanılarak Tarih bilgisi ile sefer sorgular
	 
	 
}
