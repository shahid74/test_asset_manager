package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="test_account")
public class TestAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="encrypted_password")
	private String encryptedPassword;
	
	@Column(name="security_question")
	private String securityQuestion;
	
	@Column(name="encrypted_security_answer")
	private String encryptedSecurityAnswer;
	
	@Column(name="test_name")
	private String testName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getEncryptedSecurityAnswer() {
		return encryptedSecurityAnswer;
	}

	public void setEncryptedSecurityAnswer(String encryptedSecurityAnswer) {
		this.encryptedSecurityAnswer = encryptedSecurityAnswer;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
}
