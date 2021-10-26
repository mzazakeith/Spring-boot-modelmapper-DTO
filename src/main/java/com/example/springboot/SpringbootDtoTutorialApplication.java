package com.example.springboot;

import com.example.springboot.model.Location;
import com.example.springboot.model.User;
import com.example.springboot.repository.LocationRepository;
import com.example.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDtoTutorialApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialApplication.class, args);

	}
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Kenya");
		location.setDescription("Kanairo");
		location.setLongitude(56.5);
		location.setLatitude(30.5);
		locationRepository.save(location);

		Location location1 = new Location();
		location1.setPlace("Congo");
		location1.setDescription("congoooo");
		location1.setLongitude(59.5);
		location1.setLatitude(38.5);
		locationRepository.save(location1);

		User user1 = new User();
		user1.setEmail("mzazakeith@gmail.com");
		user1.setFirstName("Keith");
		user1.setLastName("Mzaza");
		user1.setPassword("password");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setEmail("keith@gmail.com");
		user2.setFirstName("Kei");
		user2.setLastName("Mza");
		user2.setPassword("secret");
		user2.setLocation(location1);
		userRepository.save(user2);

	}
}
