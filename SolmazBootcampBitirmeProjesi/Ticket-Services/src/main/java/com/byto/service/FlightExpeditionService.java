package com.byto.service;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byto.dto.BusExpeditionDto;
import com.byto.dto.FlightExpeditionDto;
import com.byto.model.BusExpedition;
import com.byto.model.FlightExpedition;
import com.byto.repository.FlightExpeditionRepository;

@Service
public class FlightExpeditionService {

	@Autowired
	private FlightExpeditionRepository flightExpeditionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public void save(FlightExpeditionDto flightExpeditionDto) {   // Uçak seferlerini kaydediyor
		
		FlightExpedition expedition = modelMapper.map(flightExpeditionDto, FlightExpedition.class );
		
		flightExpeditionRepository.save(expedition);
		
	}
	
	
	public List<FlightExpeditionDto> getByExpeditionDate( LocalDate date ) throws ParseException {		 //Tarihe göre uçak seferlerini getiriyoruz
		
		List<FlightExpedition> flightExpeditions =  flightExpeditionRepository.findByDate(date) ;
					
		List<FlightExpeditionDto> flightExpeditionDtos = new ArrayList<>();
		
		for (FlightExpedition item : flightExpeditions) {
			
			flightExpeditionDtos.add( modelMapper.map( item , FlightExpeditionDto.class ) );
			
		}
		
		
		return flightExpeditionDtos;
						
	}
	
	public List<FlightExpeditionDto> getByExpeditionCity( String fromTo , String toFrom ) {	   // rotaya göre uçak biletlerini getiriyoruz
		
		List<FlightExpedition> flightExpeditions = flightExpeditionRepository.findByFromToAndToFrom(fromTo,toFrom);
		
		List<FlightExpeditionDto> flightExpeditionDtos = new ArrayList<>();
		
		for (FlightExpedition item : flightExpeditions) {
			
			flightExpeditionDtos.add( modelMapper.map( item , FlightExpeditionDto.class ) );
			
		}
		
		
		return flightExpeditionDtos;
		
	}
	
	public void delete( Long expeditionId ) {     //id ye göre sefer siliyoruz
		
		flightExpeditionRepository.deleteById(expeditionId);
		
	}

	public List<FlightExpeditionDto> getAll() { // Tüm uçak seferlerini getiriyor
		
		List<FlightExpedition> expeditions =  flightExpeditionRepository.findAll();
		
		
		List<FlightExpeditionDto> expeditionDtos = new ArrayList<>();

		for (FlightExpedition busExpedition : expeditions) {
				
			expeditionDtos.add( modelMapper.map(busExpedition, FlightExpeditionDto.class ) );
			
		}
		
				
		
		return expeditionDtos;
	}
	
	
	public FlightExpeditionDto getById(Long expeditionId) { // verilen id ye sehip tüm seferleri getiriyor
		return modelMapper.map(flightExpeditionRepository.findById(expeditionId).get(), FlightExpeditionDto.class );
	}
	
	
}
