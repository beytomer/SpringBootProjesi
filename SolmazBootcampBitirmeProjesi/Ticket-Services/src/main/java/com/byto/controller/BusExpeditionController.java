package com.byto.controller;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byto.dto.BusExpeditionDto;
import com.byto.service.BusExpeditionService;

@RestController
@RequestMapping("/busExp")
public class BusExpeditionController {                   // Otobüs seferi controller classı, otobüs seferlerinin oluşturulduğu getirildiği class

	@Autowired private BusExpeditionService busExpeditionService;
	
	@Autowired private ModelMapper modelMapper;
	
	
	@GetMapping                                    //Tüm otobüs seferlerini getiriyoruz
	public ResponseEntity<List<BusExpeditionDto>> getAllExpedition() {
		
		return ResponseEntity.ok( busExpeditionService.getAll() );
				
	}
	
	
	@PostMapping                                    //Otobüs seferi ekliyoruz
	public void addExpedition(@RequestBody BusExpeditionDto expeditionDto) throws ParseException {
		 busExpeditionService.save(expeditionDto);
	}
	
	

	@RequestMapping(value = "date", method = RequestMethod.GET)         //otobüs seferini tarihe göre getirir
	public ResponseEntity<List<BusExpeditionDto>> getByExpeditionDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date ) throws ParseException {						
		return ResponseEntity.ok( busExpeditionService.getByExpeditionDate(date) );
				
	}
	
	@GetMapping("/city")                                                //otobüs seferini citye göre getirir
	public ResponseEntity<List<BusExpeditionDto>> getByExpeditionCity(@RequestParam String fromTo , @RequestParam String toFrom ) {						
		return ResponseEntity.ok( busExpeditionService.getByExpeditionCity(fromTo,toFrom) );
				
	}
	
	@DeleteMapping ("/{expeditionId}")                                                 //Otobüs seferini silmek için
	public void deleteByExpedition( @PathVariable Long expeditionId ) {
		busExpeditionService.delete(expeditionId);
	}
	
}
