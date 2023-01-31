package com.byto.service;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.byto.dto.BusTicketDto;
import com.byto.dto.PlaneTicketDto;
import com.byto.dto.UserDto;
import com.byto.model.User;
import com.byto.repository.UserRepository;


@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	
	@Autowired private ModelMapper modelMapper;
	
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired private BusTicketService busTicketService;
	
	@Autowired private PlaneTicketService planeTicketService;
	
	public void save( UserDto userdto ) throws NoSuchAlgorithmException {   // user kaydediyoruz
		
		User user = modelMapper.map( userdto, User.class );				
		
		String bCryptedPassword = bCryptPasswordEncoder.encode( userdto.getPassword() );
		
		user.setPassword( bCryptedPassword );
		
		userRepository.save(user);
		
	}
	
	
	public String userLogin(UserDto userdto) throws NoSuchAlgorithmException {		// user login
				
		Optional<User> user = userRepository.findByEmail( userdto.getEmail() );
		
		String str = "Login ";
		
		if( !user.isPresent() ) 			
				str += "Failed! " + "\n"  + "User notFound! --> You need to be registered";
		
		else {
			
			Boolean matched = BCrypt.checkpw( userdto.getPassword() , user.get().getPassword() );
						
			if ( matched ) 																																						
				 str += "Successful";					
			
			else								
				str += "Failed! " + "\n"  + "Check your information";
			
		}
			
		return str ;
	}	
	
	
	
	public UserDto getUserById(Long userId) {  //verilen id ye sahip userı getiriyor
		
		User user = userRepository.findById(userId).orElseThrow( () -> new IllegalArgumentException() );
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
		return userDto;
	}	
	
	
	public List<UserDto> getAllUsers(){ // tüm userları getiriyor
		
		List<User> users = userRepository.findAll();
		
		List<UserDto> userDtos = new ArrayList<>();
		
		for (User item : users) {
			
			userDtos.add( modelMapper.map(users, UserDto.class) );
			
		}				
		
		return userDtos;
		
	}	

	
	public void deleteUser( Long id ) { // id si verilen userı siler
		userRepository.deleteById(id);
	}


	public List<BusTicketDto> getBusTicket(UserDto userDto) {     //usera ait otobüs Biletleri getiriyor
		
		User user = userRepository.findByEmail( userDto.getEmail() ).get();
		
		List<BusTicketDto> busTicketDtos = busTicketService.getTicket( user.getId() );
		
		return busTicketDtos;
	}


	public List<PlaneTicketDto> getPlaneTicket(UserDto userDto) { // usera ait uçak biletlerini
		
		User user = userRepository.findByEmail( userDto.getEmail() ).get();
		
		List<PlaneTicketDto> planeTicketDtos = planeTicketService.getTicket( user.getId() );
		
		return planeTicketDtos;
	}




		
	
}
