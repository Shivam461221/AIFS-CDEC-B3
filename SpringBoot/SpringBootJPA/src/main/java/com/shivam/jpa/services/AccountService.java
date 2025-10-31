package com.shivam.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.jpa.entities.Account;
import com.shivam.jpa.repos.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
	
	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}
	
	public String createAccount(Account account) {
		accountRepository.save(account);
		return "Account created";
	}
	
	public String deleteAccount(Long id) {
		accountRepository.deleteById(id);
		return "Account deleted";
	}
	
	public String updateAccount(Long id, Account updatedAccount) {
		Optional<Account> existingAccountOptional = accountRepository.findById(id);
		
		if(existingAccountOptional.isPresent()) {
			Account existingAccount = existingAccountOptional.get();
			
			if(updatedAccount.getAccountHolder() != null) {
				existingAccount.setAccountHolder(updatedAccount.getAccountHolder());
			}
			
			if(updatedAccount.getAccountNumber()!=null) {
				existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
			}
			
			if(updatedAccount.getBalance()!= 0) {
				existingAccount.setBalance(updatedAccount.getBalance());
			}
			
			accountRepository.save(existingAccount);
			return "Account updated";
		}
		
		return "Account not found";
	}
}
