package com.example.UserServiceWithGateWay;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
public class UserServiceWithGateWayApplication {
	@Autowired
private  UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserServiceWithGateWayApplication.class, args);
	}

	/*@PostConstruct
	public void init(){
		userRepository.saveAll(List.of(new User(1l,"rakesh",29),
				new User(2l,"akhil",18)));
	}*/
}
