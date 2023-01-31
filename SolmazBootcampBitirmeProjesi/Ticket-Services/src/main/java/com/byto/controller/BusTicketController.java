package com.byto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.byto.dto.BusTicketDto;
import com.byto.service.BusTicketService;

@RestController
@RequestMapping("/bus-ticket")
public class BusTicketController {

	@Autowired
	private BusTicketService busTicketService;
	
	
	@PostMapping             // Otobüs bileti oluşturuyoruz
	public ResponseEntity<List<BusTicketDto>> buyTicket(@RequestBody BusTicketDto busTicketDto) {		
		return ResponseEntity.ok(busTicketService.buyTicket( busTicketDto )) ;
	}
	
	
}
