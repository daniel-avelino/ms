package com.microservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.entities.User;

@Component
@FeignClient(name = "user-ms", path = "/users")
public interface UserFeignClient {

	@GetMapping(path = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
