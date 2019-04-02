package com.idexcel.restapi.IdexcelRest.accountstore;

/*
 * 
 * Repository to interact with DB
 */
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("accountRepository")
public interface accountRepository extends CrudRepository<Account,Long>{
	
	@Query(value="Select a from Account a where a.accountNumber =:accountNumber")
	public Account find(long accountNumber);
}
