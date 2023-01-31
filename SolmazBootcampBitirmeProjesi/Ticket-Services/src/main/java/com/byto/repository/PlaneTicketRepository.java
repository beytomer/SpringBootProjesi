package com.byto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byto.dto.PlaneTicketDto;
import com.byto.model.PlaneTicket;


public interface PlaneTicketRepository extends JpaRepository<PlaneTicket, Long>  {

	Long countByFlightExpeditionIdAndUserId( Long planeId , Long userId );   ////Derived Query kullanılarak verilen sefer ile verilen user değerine göre ortak biletlerin sayısını getirir
	
	Long countByFlightExpeditionId(Long planeId);      //Derived Query kullanılarak verilen id ye göre seferleri sayıyor
	
	List<PlaneTicket> findByFlightExpeditionIdAndUserId( Long planeId , Long userId );   //Derived Query kullanılarak verilen sefer ile verilen user değerine göre ortak biletleri getirir

	List<PlaneTicket> findAllById(Long id);                //Derived Query kullanılarak verilen id ye göre tüm biletleri bulur
}
