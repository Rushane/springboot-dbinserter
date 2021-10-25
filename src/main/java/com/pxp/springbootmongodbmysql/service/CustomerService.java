package com.pxp.springbootmongodbmysql.service;

import com.pxp.springbootmongodbmysql.document.AccountDocument;
import com.pxp.springbootmongodbmysql.document.CreditCardDocument;
import com.pxp.springbootmongodbmysql.document.CustomerDocument;
import com.pxp.springbootmongodbmysql.entity.Account;
import com.pxp.springbootmongodbmysql.entity.Creditcard;
import com.pxp.springbootmongodbmysql.entity.Customer;
import com.pxp.springbootmongodbmysql.model.CourseModel;
import com.pxp.springbootmongodbmysql.model.CustomerModel;
import com.pxp.springbootmongodbmysql.repository.AccountDocumentRepository;
import com.pxp.springbootmongodbmysql.repository.AccountRepository;
import com.pxp.springbootmongodbmysql.repository.CreditCardDocumentRepository;
import com.pxp.springbootmongodbmysql.repository.CustomerDocumentRepository;
import com.pxp.springbootmongodbmysql.repository.CreditCardRepository;
import com.pxp.springbootmongodbmysql.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

@Slf4j 
@Service
public class CustomerService {
    CustomerDocumentRepository customerDocumentRepository;
    CustomerRepository customerRepository;
    AccountRepository accountRepository;  
    CreditCardRepository creditcardRepository;
    AccountDocumentRepository accountDocumentRepository;
    CreditCardDocumentRepository creditCardDocumentRepository;
    
    @Autowired
    public CustomerService(CustomerDocumentRepository customerDocumentRepository, 
    		CustomerRepository customerRepository,
    		AccountRepository accountRepository,
    		CreditCardRepository creditcardRepository,
    		AccountDocumentRepository accountDocumentRepository,
    		CreditCardDocumentRepository creditCardDocumentRepository) {
    	this.customerDocumentRepository = customerDocumentRepository;
    	this.customerRepository = customerRepository;
    	this.accountRepository = accountRepository;
    	this.creditcardRepository = creditcardRepository;
    	this.accountDocumentRepository = accountDocumentRepository;
    	this.creditCardDocumentRepository = creditCardDocumentRepository;
    }

    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    FakeValuesService fakeValuesService = new FakeValuesService(
  	      new Locale("en-GB"), new RandomService());
    
    public String insertData(){
        Faker faker = new Faker();
        
    	
        logger.info("Begin generation of data");
        
        List<Customer> customerArray = new ArrayList<>();
        
    	for (int i = 0; i < 2; i++) {
    		Customer customer = new Customer();
    		customer.setFirstName(faker.name().firstName());
    		customer.setLastName(faker.name().lastName());
    		customer.setEmail(fakeValuesService.bothify("????##@gmail.com"));
    		customer.setPhoneNumber(faker.phoneNumber().phoneNumber());
    		
    		customerArray.add(customer);
    		    				
    	}
    	
    	List<Customer> returnedResults = customerRepository.saveAll(customerArray);
    	
    	for (int i = 0; i < 2; i++) {
    		Account account = new Account();
    		Long accountNumber = faker.number().randomNumber(8, false);
    		
    		account.setAccountNumber(accountNumber.toString());
    		account.setAccountBalance(faker.number().randomDouble(2, 0, 1000000));
    		account.setAccountType(fakeValuesService.bothify("????##-accounttype"));
    		account.setAccountCurrency(faker.currency().code());
    		account.setCustomer(returnedResults.get(i));
    		
    		accountRepository.save(account);
    		    				
    	}
    	
    	for (int i = 0; i < 2; i++) {
    		Creditcard creditcard = new Creditcard();
    		Long accountNumber = faker.number().randomNumber(8, false);
    		
    		creditcard.setCcType(faker.business().creditCardType());
    		creditcard.setCcNumber(faker.business().creditCardNumber());
    		creditcard.setExpiryDate(faker.date().future(200, TimeUnit.DAYS));
    		creditcard.setCustomer(returnedResults.get(i));
    		
    		creditcardRepository.save(creditcard);	    				
    	}
    	
    	
    	List<CustomerDocument> customerDocumentArray = new ArrayList<>();
    	
    	for (int i = 0; i < 2; i++) {
    		CustomerDocument customerDocument = new CustomerDocument();
    		customerDocument .setFirstName(faker.name().firstName());
    		customerDocument .setLastName(faker.name().lastName());
    		customerDocument .setEmail(fakeValuesService.bothify("????##@gmail.com"));
    		customerDocument .setPhoneNumber(faker.phoneNumber().phoneNumber());
    		
    		
    		customerDocumentArray.add(customerDocument);
    		    		    				
    	}
    	
    	List<CustomerDocument> returnedDocumentResults = customerDocumentRepository.saveAll(customerDocumentArray);
    	
    	for (int i = 0; i < 2; i++) {
    		AccountDocument accountDocument = new AccountDocument();
    		Long accountNumber = faker.number().randomNumber(8, false);
    		
    		accountDocument.setAccountNumber(accountNumber.toString());
    		accountDocument.setAccountBalance(faker.number().randomDouble(2, 0, 1000000));
    		accountDocument.setAccountType(fakeValuesService.bothify("????##-accountDocumenttype"));
    		accountDocument.setAccountCurrency(faker.currency().code());
    		accountDocument.setCustomer(returnedDocumentResults.get(i));
    		
    		accountDocumentRepository.save(accountDocument);	    				
    	}
    	
    	for (int i = 0; i < 2; i++) {
    		CreditCardDocument creditCardDocument = new CreditCardDocument();
    		Long accountNumber = faker.number().randomNumber(8, false);
    		
    		creditCardDocument.setCcType(faker.business().creditCardType());
    		creditCardDocument.setCcNumber(faker.business().creditCardNumber());
    		creditCardDocument.setExpiryDate(faker.date().future(200, TimeUnit.DAYS));
    		creditCardDocument.setCustomerDocument(returnedDocumentResults.get(i));
    		
    		creditCardDocumentRepository.save(creditCardDocument);	    				
    	}
    	
    	logger.info("End generation of data");

    	return "Data sucessfully inserted!";
    }

}
