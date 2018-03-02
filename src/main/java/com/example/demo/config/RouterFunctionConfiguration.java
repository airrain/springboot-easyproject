package com.example.demo.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class RouterFunctionConfiguration {
	
@Bean
@Autowired
public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository)

Collection<User> users = userRepository.findAll();

RouterFunction.rout(RequestPredicates.GET(pattern:"/person/find/all"),Request ->{
	Mono<ServerResponse> response = null;
	Flux<User> userFlux = Flux.fromIterable(users);
	return ServerResponse.ok().body(userFlux,User.class);
	
});


}


}
