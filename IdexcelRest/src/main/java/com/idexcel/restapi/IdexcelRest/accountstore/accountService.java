package com.idexcel.restapi.IdexcelRest.accountstore;

/*
 * 
 * Business Layer to Interact Between Controller and  Repository
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class accountService {

	@Autowired
	accountRepository accountRepo;
	
	public List<Account> findAll(){
		List<Account> carDetails = new ArrayList<>();
		accountRepo.findAll().forEach(carDetails::add);
		return carDetails;
	}
	
	public Account save(Account car) {
		return accountRepo.save(car);
	}
	
	public Account find(long id) {
		return accountRepo.find(id);
	}
	public boolean findById(long id) {
		if(accountRepo.findById(id).isPresent())return true;
		return false;
	}
	
	public void update(Account car) {
		accountRepo.save(car);
	}
	
	public void delete(long id) {
		accountRepo.deleteById(id);
	}
	
	public void deleteByEntity(Account car) {
		accountRepo.delete(car);
	}
	
	public void deleteAll() {
		accountRepo.deleteAll();
	}
}
