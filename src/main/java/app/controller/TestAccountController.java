package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.TestAccount;
import app.service.TestAccountService;

@RestController
@RequestMapping(value="/testAccount", produces=MediaType.APPLICATION_JSON_VALUE)
public class TestAccountController {

	public static final Logger LOGGER=LoggerFactory.getLogger(TestAccountController.class);
	
	@Autowired
	TestAccountService testAccountService;
	
	@RequestMapping(value="/{key}",method=RequestMethod.GET)
	public ResponseEntity<TestAccount> getTestAccount(@PathVariable String key){
		
		TestAccount account=testAccountService.getAccountByTestName(key);
		if(account==null){
			return new ResponseEntity<TestAccount>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestAccount>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{key}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void setTestAccount(@PathVariable String key, @RequestBody TestAccount account){
		
		testAccountService.setTestAccount(key, account);
	}
}
