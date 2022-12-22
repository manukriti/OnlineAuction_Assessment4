package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerCustomException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/rest/onlineauction")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
	//get all customer
		@GetMapping("/customer")
		public List<Customer> getAllCustomer(){
			return customerRepo.findAll();
		}
		
		//insert a customer
		@PostMapping("/customer")
		public Customer createCustomer(@RequestBody Customer customer) {
			return customerRepo.save(customer);
		}
		
		//get customer by id 
		@GetMapping("/customer/{customerID}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerID) {
			Customer customer = customerRepo.findById(customerID).orElseThrow(()-> new CustomerCustomException("Customer not exist with id:"+customerID));
			return ResponseEntity.ok(customer);
		}
		
		//delete seller
		@DeleteMapping("/customer/{customerID}")
		public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Integer customerID){
			Customer customer = customerRepo.findById(customerID).orElseThrow(()-> new CustomerCustomException("Customer not exist with id:"+customerID));
			customerRepo.delete(customer);
			Map<String,Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
}
		
		//update product
		@PutMapping("/customer/{customerID}")
		public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerID, @RequestBody Customer customerDetails){
			Customer customer = customerRepo.findById(customerID).orElseThrow(()-> new CustomerCustomException("Customer not exist with id:"+customerID));
			customer.setCustomerID(customerDetails.getCustomerID());
			customer.setCustomerName(customerDetails.getCustomerName());
			customer.setCustomerEmail(customerDetails.getCustomerEmail());
			customer.setCustomerPassword(customerDetails.getCustomerPassword());
			customer.setCustomerAddress(customerDetails.getCustomerAddress());
			customer.setCustomerNumber(customerDetails.getCustomerNumber());
			Customer updatedCustomer = customerRepo.save(customer);
			return ResponseEntity.ok(updatedCustomer);
		}
}
