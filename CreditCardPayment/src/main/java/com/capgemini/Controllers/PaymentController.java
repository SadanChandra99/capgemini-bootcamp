package com.capgemini.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.Model.PaymentModel;
import com.capgemini.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;
	
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentModel> addPayment(@RequestBody PaymentModel paymentmodel){
		return ResponseEntity.ok(paymentservice.addPayment(paymentmodel));
	}
	
	@GetMapping(value = "/getall",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<PaymentModel>> getAllPayments(){
		return ResponseEntity.ok(paymentservice.getAllPayments());
	}
	
	@GetMapping(value = "/getbyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentModel> getPaymentById(@PathVariable("id") long id){
		return ResponseEntity.ok(paymentservice.getPaymentById(id));
	}
	
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentModel> updatePayment(@PathVariable("id") long id, @RequestBody PaymentModel paymentmodel){
		return ResponseEntity.ok(paymentservice.updatePayment(id, paymentmodel));
	}
	
	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removePayment(@PathVariable("id") long id){
		return ResponseEntity.ok(paymentservice.removePayment(id));
	}
	
	
	
}
