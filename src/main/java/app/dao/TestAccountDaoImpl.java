package app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.model.TestAccount;

@Repository
public class TestAccountDaoImpl implements TestAccountDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}


	@SuppressWarnings("unchecked")
	@Override
	public TestAccount getAccountByTestName(String testName) {

		Session session= getCurrentSession();
		Criteria crit= session.createCriteria(TestAccount.class);
		crit.add(Restrictions.eq("testName", testName));
		
		List<TestAccount> list=crit.list();
		
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}


	@Override
	public void createTestAccount(TestAccount account) {
		
		Session session=getCurrentSession();
		
		session.save(account);
	}


	@Override
	public void updateTestAccount(TestAccount accountInDB) {
		Session session= getCurrentSession();
		
		session.merge(accountInDB);
	}
	
	
	

}
