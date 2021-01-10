package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.TelNumber;
import repository.TelNumberRepository;

@Service
public class TelNumberService {
	
	@Autowired
	private TelNumberRepository telRepo;

	public TelNumber getPersonNumber(String number) {
		return telRepo.getTelNumber(number);
	}
	
	public TelNumber updateNumber(TelNumber t) {
		return telRepo.update(t);
	}
	
	@Transactional
	public void batchJob(TelNumber t) {
		updateNumber(t);
		throw new RuntimeException("Number is wrong");
	}
}
