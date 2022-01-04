package com.camilabdacosta.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.camilabdacosta.hroauth.entities.User;

@Component
@FeignClient(name="hr_user",path="/users")
public interface UserFeignClient {
	@GetMapping(value = "/search")
	
	 User findByEmail(@RequestParam String email);	
}
