package com.byto.controller;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byto.dto.BusExpeditionDto;
import com.byto.dto.FlightExpeditionDto;
import com.byto.service.FlightExpeditionService;

@RestController
@RequestMapping("/planeExp")
public class FlightExpeditionController {

@Autowired private FlightExpeditionService flightExpeditionService;
	
	@Autowired private ModelMapper modelMapper;
	
	
	@GetMapping                  // Tüm uçak seferlerini getiriyoruz
	public ResponseEntity<List<FlightExpeditionDto>> getAllExpedition() {
		
		return ResponseEntity.ok( flightExpeditionService.getAll() );
				
	}
		
	
	@PostMapping               //Uçak seferi ekliyoruz
	public void addExpeditions(@RequestBody FlightExpeditionDto flightExpeditionDto) {
		flightExpeditionService.save(flightExpeditionDto);
	}
	
	
	@RequestMapping(value = "date", method = RequestMethod.GET)      //Uçak seferlerini tarihlerine göre getiriyoruz
	public ResponseEntity<List<FlightExpeditionDto>> getByDateExpedition(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date ) throws ParseException {						
		return ResponseEntity.ok( flightExpeditionService.getByExpeditionDate(date) );
				
	}

	@GetMapping("/city")                            //Uçak seferlerini city e göre getiriyoruz
	public ResponseEntity<List<FlightExpeditionDto>> getByCityExpedition(@RequestParam String fromTo , @RequestParam String toFrom ) {						
		return ResponseEntity.ok( flightExpeditionService.getByExpeditionCity(fromTo,toFrom) );
				
	}
	
	@DeleteMapping("/{expeditionId}")             //Uçak seferlerini id lerine göre siliyoruz
	public void deleteByExpedition( @PathVariable Long expeditionId ) {
		flightExpeditionService.delete(expeditionId);
	}
	
	
}
