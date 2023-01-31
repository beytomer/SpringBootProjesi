package com.byto.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.byto.model.FlightExpedition;


public interface FlightExpeditionRepository extends JpaRepository<FlightExpedition, Long> {

	List<FlightExpedition> findByFromToAndToFrom(String fromTo,String toFrom);     // Derived Query kullanılarak Şehir bilgisi ile sefer sorgular
	
	 List<FlightExpedition> findByDate(LocalDate date);                            // Derived Query kullanılarak Tarih bilgisi ile sefer sorgular
	
}
