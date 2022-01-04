package com.camilabdacosta.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camilabdacosta.hrpayroll.entities.Payment;
import com.camilabdacosta.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
@HystrixCommand(fallbackMethod="getPaymentAlternative")
@GetMapping(value = "/{workerId}/days/{days}")
public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
Payment payment = service.getPayment(workerId,days);	
return ResponseEntity.ok(payment);
}
public ResponseEntity<Payment> getPaymentAlternative( Long workerId, Integer days){
	Payment payment = new Payment("Brann",400.0,days);	
	return ResponseEntity.ok(payment);
}


}
