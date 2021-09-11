package in.co.bm.marketingtool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.bm.marketingtool.model.Customer;
import in.co.bm.marketingtool.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@DeleteMapping("deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
