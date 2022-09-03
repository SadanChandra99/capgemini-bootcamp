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

import com.capgemini.Model.CreditCardModel;
import com.capgemini.Service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

	@Autowired
	private CreditCardService creditcardservice;
	
	@PostMapping(value = "/add" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCardModel> addCreditCard(@RequestBody CreditCardModel creditcardmodel){
		return ResponseEntity.ok(creditcardservice.addCreditCard(creditcardmodel));
	}
	
	@GetMapping(value = "/getbyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCardModel> getCreditCardById(@PathVariable("id") long id){
		return ResponseEntity.ok(creditcardservice.getCreditCardById(id));
	}
	
	@GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CreditCardModel>> getAllCreditCards(){
		return ResponseEntity.ok(creditcardservice.getAllCreditCards());
	}
	
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCardModel> updateCreditCard(@PathVariable("id") long id, @RequestBody CreditCardModel creditcardmodel){
		return ResponseEntity.ok(creditcardservice.updateCreditCard(id, creditcardmodel));
	}
	
	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCreditCard(@PathVariable long id){
		return ResponseEntity.ok(creditcardservice.removeCreditCard(id));
	}
	
}
