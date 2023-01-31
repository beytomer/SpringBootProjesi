package com.byto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.byto.dto.PlaneTicketDto;
import com.byto.service.PlaneTicketService;

@RestController
@RequestMapping("/plane-ticket")
public class PlaneTicketController {

	@Autowired private PlaneTicketService planeTicketService;
	
	@PostMapping        // Uçak bileti oluşturuyoruz
	public ResponseEntity<List<PlaneTicketDto>> buyTicket(@RequestBody PlaneTicketDto planeTicketDto) {		
		return ResponseEntity.ok(planeTicketService.buyTicket( planeTicketDto )) ;
	}
	
	
}
