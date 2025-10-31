package com.shivam.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.jpa.entities.Account;
import com.shivam.jpa.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}
	
	@PostMapping
	public String createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable Long id) {
		return accountService.deleteAccount(id);
	}
	
	@PutMapping("/{id}")
	public String updateAccount(@PathVariable long id, @RequestBody Account updatedData) {
		return accountService.updateAccount(id, updatedData);
	}
}
