package com.byto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byto.dto.BusTicketDto;
import com.byto.model.BusTicket;

public interface BusTicketRepository extends JpaRepository<BusTicket, Long>  {
	
	Long countByBusExpeditionIdAndUserId(Long expeditionId , Long userId);          //Derived Query kullanılarak verilen sefer ile verilen user değerine göre ortak biletlerin sayısını getirir
	
	List<BusTicket> findByBusExpeditionIdAndUserId(Long expeditionId , Long userId); //Derived Query kullanılarak verilen sefer ile verilen user değerine göre ortak biletleri getirir
	
	Long countByBusExpeditionId(Long expeditionId);    //Derived Query kullanılarak verilen id ye göre seferleri sayıyor


	List<BusTicket> findAllById(Long id);          //Derived Query kullanılarak verilen id ye göre tüm biletleri bulur

	
}
