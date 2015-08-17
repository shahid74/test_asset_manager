package app.dao;

import app.model.TestAccount;

public interface TestAccountDao {

	TestAccount getAccountByTestName(String testName);

	void createTestAccount(TestAccount account);

	void updateTestAccount(TestAccount accountInDB);

}
