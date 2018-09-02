package org.ukdaga.apparelmanagement.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.ukdaga.apparelmanagement.domain.Account;
import org.ukdaga.apparelmanagement.repository.AccountRepository;

@Service
@EnableJpaRepositories
public class AccountService {
	
	private final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount (String name)
	{
		Account account = new Account();
		account.setName(name);
		account.setPassword(UUID.randomUUID().toString().replace("-", "").substring(0,6));
		Account savedAccount = accountRepository.saveAndFlush(account);
		logger.info("Account created successfully");
		
		return savedAccount.getPassword();
	}
	
	public Account getAccountByName (String name)
	{
		return accountRepository.findByName(name);
	}

}
