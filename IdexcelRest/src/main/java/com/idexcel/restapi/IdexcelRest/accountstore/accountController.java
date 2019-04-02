package com.idexcel.restapi.IdexcelRest.accountstore;

/*
 * 
 * Controller Class defined to manage All Rest API calls
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="AccountDatabase",description="Online Account UI")
@RequestMapping("/account")
public class accountController {

	@Autowired
	accountService accountService;
	@ApiOperation(value="View a List of accounts",response= Iterable.class)
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(method= RequestMethod.GET)
	public List<Account> findAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Fetches Account for a specific AccountNumber")
	public ResponseEntity<Account> find(@PathVariable("id") long id) {
		if(accountService.findById(id)) {
			Account account= accountService.find(id);
			return ResponseEntity.ok().body(account);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ApiOperation(value="Creates a Account")
	@RequestMapping(method = RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Account> createAccounts(@RequestBody Account account) {
		if(accountService.findById(account.getAccountNumber())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		 account=accountService.save(account);
		return ResponseEntity.ok().body(account);
	}
	
	@ApiOperation(value="Updates Account")
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateaccountDetails(@RequestBody Account account, @PathVariable("id") long id){
		if(accountService.findById(id)) {
			accountService.update(account);
			return ResponseEntity.ok().body(account);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="Deletes a Account")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteaccountDetails(@PathVariable("id") long id){
		if(accountService.findById(id)) {
			accountService.delete(id);
			return ResponseEntity.ok().body("Deleted Successfully");
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
