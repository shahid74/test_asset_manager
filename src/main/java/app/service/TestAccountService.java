package app.service;

import app.model.TestAccount;

public interface TestAccountService {
	
	TestAccount getAccountByTestName(String testName);

	void setTestAccount(String testName, TestAccount account);

}
