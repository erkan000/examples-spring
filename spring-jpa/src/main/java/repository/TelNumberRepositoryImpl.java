package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import pojo.TelNumber;

@Repository
public class TelNumberRepositoryImpl implements TelNumberRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public TelNumber update(TelNumber t){
		TelNumber tel = em.merge(t);
		return tel;
	}

	@Override
	public List<TelNumber> getAllTelNumber(){
		TypedQuery<TelNumber> q = em.createNamedQuery(TelNumber.GEL_ALL_NUMBERS, TelNumber.class);
		return q.getResultList();
	}

	@Override
	public TelNumber getTelNumber(String number){
		TypedQuery<TelNumber> q = em.createQuery("select t from TelNumber t where t.number = :num", TelNumber.class);
		q.setParameter("num", number);
		return q.getSingleResult();
	}	

}
