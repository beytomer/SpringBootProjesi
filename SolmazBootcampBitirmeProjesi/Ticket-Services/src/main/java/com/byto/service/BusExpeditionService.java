package com.byto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.jdbc.Expectation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byto.dto.BusExpeditionDto;
import com.byto.model.BusExpedition;
import com.byto.repository.BusExpeditionRepository;

@Service
public class BusExpeditionService {

	@Autowired
	private BusExpeditionRepository busExpeditionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public void save(BusExpeditionDto expeditionDto) {       // Otobüs seferini kaydeder
		
		BusExpedition expedition = modelMapper.map(expeditionDto, BusExpedition.class );
		
		
		busExpeditionRepository.save(expedition);
		
	}
	
	
	public List<BusExpeditionDto> getByExpeditionDate( LocalDate date ) throws ParseException {		// tarihe göre seferleri getiriyor
		
		List<BusExpedition> busExpeditions =  busExpeditionRepository.findByDate(date) ;
					
		List<BusExpeditionDto> busExpeditionDtos = new ArrayList<>();
		
		for (BusExpedition item : busExpeditions) {
			
			busExpeditionDtos.add( modelMapper.map( item , BusExpeditionDto.class ) );
			
		}
		
		
		return busExpeditionDtos;
						
	}
	
	
	
	public List<BusExpeditionDto> getByExpeditionCity( String fromTo , String toFrom ) {	//şehirlere göre seferleri getiriyor
		
		List<BusExpedition> busExpeditions = busExpeditionRepository.findByFromToAndToFrom(fromTo,toFrom);
		
		List<BusExpeditionDto> busExpeditionDtos = new ArrayList<>();
		
		for (BusExpedition item : busExpeditions) {
			
			busExpeditionDtos.add( modelMapper.map( item , BusExpeditionDto.class ) );
			
		}
		
		
		return busExpeditionDtos;
		
	}

	public List<BusExpeditionDto> getAll() {   // Tüm seferleri getiriyor
		
		List<BusExpedition> expeditions =  busExpeditionRepository.findAll();
		
		
		List<BusExpeditionDto> expeditionDtos = new ArrayList<>();

		for (BusExpedition busExpedition : expeditions) {
				
			expeditionDtos.add( modelMapper.map(busExpedition, BusExpeditionDto.class ) );
			
		}
		
				
		
		return expeditionDtos;
	}
	
	
	public BusExpeditionDto getById(Long expeditionId) { // istenilen id ye göre seferleri getiriyor
		return modelMapper.map( busExpeditionRepository.findById(expeditionId).get() , BusExpeditionDto.class );
	}
		


	public void delete( Long expeditionId ) {		    // verilen id ye göre seferi siliyor
		busExpeditionRepository.deleteById(expeditionId);		
	}
	
	
	
	
}
