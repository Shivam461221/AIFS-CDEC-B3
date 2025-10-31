package com.shivam.jpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.jpa.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
