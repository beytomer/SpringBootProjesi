package com.byto.controller;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byto.dto.BusTicketDto;
import com.byto.dto.PlaneTicketDto;
import com.byto.dto.UserDto;
import com.byto.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")            // User ekliyoruz
	public void addUser(@RequestBody UserDto userdto) throws NoSuchAlgorithmException {		
		userService.save(userdto);		
	}
	
	
	@PostMapping("/login")          //User login yapıyor
	public String userLogin(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
		return userService.userLogin( userDto );
	}

	
	@PostMapping("/bus-ticket")   // User a ait otobüs biletleri
	public List<BusTicketDto> getBusTicket(@RequestBody UserDto userDto) {
		return userService.getBusTicket( userDto );
	}
	
	
	@PostMapping("/plane-ticket")    // Usera ait uçak bileti
	public List<PlaneTicketDto> getPlaneTicket(@RequestBody UserDto userDto) {
		return userService.getPlaneTicket( userDto );
	}
	
	@GetMapping("/{userId}")            //İstenlen id ye göre user getiriyor
	public UserDto getUser(Long userId) {
		return userService.getUserById(userId);
	}
	

	@GetMapping						// Tüm userları getiriyor
	public List<UserDto> getAllUser(){
		return userService.getAllUsers();
	}

	@DeleteMapping("/{userId}")			  		//id si verilen user ı siler
	public void removeUser(Long userId) {
		userService.deleteUser(userId);
	}

}
