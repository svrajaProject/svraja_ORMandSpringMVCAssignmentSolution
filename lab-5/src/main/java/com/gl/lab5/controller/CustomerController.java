package com.gl.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.lab5.entity.Customer;
import com.gl.lab5.service.CustomerService;

/**
 * @author svraja
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * @param theCustomer
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String customersList(Customer theCustomer, Model model) {
		List<Customer> customers = customerService.fetchAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String showAddForm(Model model) {
		Customer thecustomer = new Customer();
		model.addAttribute("customer", thecustomer);
		return "customer-form";
	}

	/**
	 * @param theId
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return
	 */
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int theId, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		System.out.println(theId);
		Customer theCustomer;
		if (theId != 0) {
			theCustomer = customerService.findById(theId);
			theCustomer.setFirstName(firstname);
			theCustomer.setLastName(lastname);
			theCustomer.setEmail(email);
		} else
			theCustomer = new Customer(firstname, lastname, email);
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	/**
	 * @param theid
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String showUpdateForm(@RequestParam("customerId") int theid, Model model) {
		Customer theCustomer = customerService.findById(theid);
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	/**
	 * @param theId
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.DeleteById(theId);
		return "redirect:/customer/list";
	}
}
