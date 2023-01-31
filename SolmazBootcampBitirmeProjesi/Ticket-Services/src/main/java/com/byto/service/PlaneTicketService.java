package com.byto.service;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byto.dto.FlightExpeditionDto;
import com.byto.dto.PlaneTicketDto;
import com.byto.dto.UserDto;
import com.byto.model.FlightExpedition;
import com.byto.model.PlaneTicket;
import com.byto.model.User;
import com.byto.repository.PlaneTicketRepository;

@Service
public class PlaneTicketService {

	@Autowired private PlaneTicketRepository planeTicketRepository;
		
	@Autowired private UserService userService;
			
	@Autowired private FlightExpeditionService flightExpeditionService;

	@Autowired private  ModelMapper modelMapper;
	
	
	
	@Transactional
	public List<PlaneTicketDto> buyTicket( PlaneTicketDto planeTicketDto) {  // istenilen şartlara göre bilet satın alıyoruz
		
		
		UserDto user = userService.getUserById( planeTicketDto.getUserId() );
		
		FlightExpeditionDto exp =  flightExpeditionService.getById( planeTicketDto.getExpeditionId() );
				
		
		
		if( planeTicketRepository.countByFlightExpeditionId( planeTicketDto.getExpeditionId() )  < 189 )	{ //Uçak yolcu kapasitesi: 189
		
			
			
			if ( user.getState().equals( "INDIVIDUAL" )  ) { // Bireysel kullanıcı aynı sefer için en fazla 5 bilet alabilir.
						
				
				Long count = planeTicketRepository.countByFlightExpeditionIdAndUserId( planeTicketDto.getExpeditionId() , planeTicketDto.getUserId() );

				
				if ( count < 5 ) { // en fazla 5 bilet alabilir.

					if ( planeTicketDto.getGender().equals("Male") ) { //erkekse 												
						
							if( planeTicketDto.getPersonCount() > (5 - count ) ) {

							}
							
							else {

								if ( planeTicketDto.getPersonCount() > 2 ) {
									System.out.println("Erkek icin en fazla 2 bile alabilirsiniz");
								}						
								
								else {

									for (int i = 0; i < planeTicketDto.getPersonCount(); i++) {
										
										if( count < 5 ) {
											PlaneTicket planeTicket = new PlaneTicket();				 																				
																																
											
											planeTicket.setFlightExpedition( modelMapper.map(exp, FlightExpedition.class ) );		
													
											planeTicket.setUser( modelMapper.map(user, User.class ) );
					
											planeTicket.setGender( planeTicketDto.getGender() );
											
											planeTicketRepository.save( planeTicket );
										
											count++;
										}
											
										
									}
																		
								}
								
							}
					}
					
					else {//kadınsa
						
						if( planeTicketDto.getPersonCount() > ( 5 - count ) ) {
							System.out.println("UYARI! Toplamda  " + ( 5 - count ) + " kadar bilet isteyebilirsiniz!");
						}
						else {
							if ( planeTicketDto.getPersonCount() > 5 ) {
								System.out.println("Tek seferde En fazla 5 bile alabilirsiniz");
							}						
							
							else {								

								for (int i = 0; i < planeTicketDto.getPersonCount(); i++) {
									
									if( count < 5 ) {
										
										PlaneTicket planeTicket = new PlaneTicket();				 																				
										
										planeTicket.setFlightExpedition( modelMapper.map(exp, FlightExpedition.class ) );		
												
										planeTicket.setUser( modelMapper.map(user, User.class ) );
				
										planeTicket.setGender( planeTicketDto.getGender() );
										
										planeTicketRepository.save( planeTicket );
									
										count++;
									}
										
									
								}
								
								
							}
						}
						
					}
						
					
				}						
				
			}
			
			
			if ( user.getState().equals( "CORPARETE" ) ) { //Kurumsal kullanıcı aynı sefer için en fazla 20 bilet alabilir.
				
				Long count = planeTicketRepository.countByFlightExpeditionIdAndUserId( planeTicketDto.getExpeditionId() , planeTicketDto.getUserId() );				
				
				if( planeTicketDto.getPersonCount() > ( 20 - count ) ) {
					System.out.println("UYARI! Toplamda  " + ( 20 - count ) + " kadar bilet isteyebilirsiniz!");					
				}else {
				
					if ( count < 20 ) {
						
						for (int i = 0; i < planeTicketDto.getPersonCount(); i++) {
							
							if( count < 20 ) {
								
								PlaneTicket planeTicket = new PlaneTicket();				 																				
								
								planeTicket.setFlightExpedition( modelMapper.map(exp, FlightExpedition.class ) );		
										
								planeTicket.setUser( modelMapper.map(user, User.class ) );
		
								planeTicket.setGender( planeTicketDto.getGender() );
								
								planeTicketRepository.save( planeTicket );
							
								count++;
							}
								
							
						}
		
						
					}
					
				}
				
				
				
			}						
			
			
		}
		
		List<PlaneTicket> lists = planeTicketRepository.findByFlightExpeditionIdAndUserId( planeTicketDto.getExpeditionId() , planeTicketDto.getUserId()  );
		List<PlaneTicketDto> liste = new ArrayList<>();
		
		for (PlaneTicket ticket : lists) {
			
			liste.add( modelMapper.map( ticket , PlaneTicketDto.class) );
			
		}
		
		return liste;
		
	}



	public List<PlaneTicketDto> getTicket(Long id) {  // verilen id ye sahip biletleri getiriyor
	
		List<PlaneTicket> planeTickets =  planeTicketRepository.findAllById(id);
		
		List<PlaneTicketDto> planeTicketDtos = new ArrayList<>();
		
		for (PlaneTicket item : planeTickets) {
			
			planeTicketDtos.add( modelMapper.map(item,  PlaneTicketDto.class ) );
			
		}
		
		
		return planeTicketDtos;
	
	}

		
	
}
