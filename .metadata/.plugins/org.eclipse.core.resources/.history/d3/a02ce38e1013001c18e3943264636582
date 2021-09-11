package in.co.bm.marketingtool.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.bm.marketingtool.exception.ResourceNotFoundException;
import in.co.bm.marketingtool.model.Customer;
import in.co.bm.marketingtool.repository.CustomerRepository;
import in.co.bm.marketingtool.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());
		existingCustomer.setAddress(customer.getAddress());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
		customerRepository.deleteById(id);
	}

}
