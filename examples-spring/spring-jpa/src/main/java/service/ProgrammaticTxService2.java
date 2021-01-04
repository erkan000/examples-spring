package service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import pojo.Person;

@Service
public class ProgrammaticTxService2 {

	private final TransactionTemplate transactionTemplate;	

	public ProgrammaticTxService2(PlatformTransactionManager transactionManager) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);
		this.transactionTemplate.setPropagationBehaviorName("PROPAGATION_REQUIRES_NEW");
		this.transactionTemplate.setReadOnly(true);
	}

	public Person txMethod(Person person) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try{
					//    	            createPersons();
					//	            assignTelNumberToPerson(person);
				} catch (NoSuchElementException exception) {
					exception.printStackTrace();
					status.setRollbackOnly();
				}

			}
		});

		return person;
	}

}
