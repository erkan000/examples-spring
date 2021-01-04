package repository;

import java.util.List;

import pojo.TelNumber;

public interface TelNumberRepository {

	TelNumber update(TelNumber t);

	List<TelNumber> getAllTelNumber();

	TelNumber getTelNumber(String number);

}