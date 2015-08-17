package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.TestAccountDao;
import app.model.TestAccount;

@Service
public class TestAccountServiceImpl implements TestAccountService{

	@Autowired
	TestAccountDao testAccountDao;
	
	@Transactional
	@Override
	public TestAccount getAccountByTestName(String testName) {
		
		TestAccount testAccount=testAccountDao.getAccountByTestName(testName);
		
		return testAccount;
	}

	@Override
	@Transactional
	public void setTestAccount(String testName, TestAccount account) {
		
		TestAccount accountInDB=testAccountDao.getAccountByTestName(testName);
		if(accountInDB==null){
			testAccountDao.createTestAccount(account);
		}else{
			accountInDB.setAccountType(account.getAccountType());
			accountInDB.setEncryptedPassword(account.getEncryptedPassword());
			accountInDB.setSecurityQuestion(account.getSecurityQuestion());
			accountInDB.setEncryptedSecurityAnswer(account.getEncryptedSecurityAnswer());
			accountInDB.setUserName(account.getUserName());
			testAccountDao.updateTestAccount(accountInDB);
		}
	}

}
