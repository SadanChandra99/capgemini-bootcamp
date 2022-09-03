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

import com.capgemini.Model.AddressModel;
import com.capgemini.Service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressservice;
	
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressModel> addAddress(@RequestBody AddressModel addressmodel){
		return ResponseEntity.ok(addressservice.addAddress(addressmodel));
	}
	
	@GetMapping(value = "/getbyid/{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressModel> getAddressById(@PathVariable("id") int id){
		return ResponseEntity.ok(addressservice.getAddressById(id));
	}
	
	@GetMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddressModel>> getAllAddress(){
		return ResponseEntity.ok(addressservice.getAllAddress());
	}
	
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressModel> updateAddress(@PathVariable int id, @RequestBody AddressModel addressmodel){
		return ResponseEntity.ok(addressservice.updateAddress(id, addressmodel));
	}
	
	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAddress(@PathVariable int id){
		return ResponseEntity.ok(addressservice.removeAddress(id));
	}
	
}
