package com.idexcel.restapi.IdexcelRest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IdexcelRestApplicationTests {

	@ClassRule
	public static final SpringClassRule springClassRule = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();

	@Autowired
	private MockMvc mockMvc;

	/**
	 *
	 * It tests creating a account
	 */
	@Test
	@Order(1)
	public void createAccounts() {

		/**
		 *
		 * Create account with id 1
		 *
		 * The request body is: { "accountNumber": 1, "address": "Chicago",
		 * "phonenUmber": 1234567, "accountHolderName": "Vaish", }
		 */

		String json = "{\"accountNumber\": 1, \"address\": \"Chicago\",\"phoneNumber\": 1234567, \"accountHolderName\":\"Vaish\"}";
		try {
			mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)

			).andDo(MockMvcResultHandlers.print()).andExpect(status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 *
		 * Create account with id 2
		 *
		 * The request body is: { "accountNumber": 2, "address": "Virginia",
		 * "phonenUmber": 123457890, "accountHolderName": "Navya", }
		 */

		json = "{\"accountNumber\": 2, \"address\": \"Virginia\",\"phoneNumber\": 123457890, \"accountHolderName\":\"Navya\"}";
		try {
			mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)

			).andDo(MockMvcResultHandlers.print()).andExpect(status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests fetching all accounts
	 */
	@Test
	@Order(2)
	public void findAllAccounts() {
		try {
			mockMvc.perform(get("/account")).andExpect(status().is(200));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests fetching account with existing AccNumber
	 */
	@Test
	@Order(3)
	public void findAccountbyAccNumber() {
		/**
		 *
		 * Find account by AccNumber 1
		 *
		 * The request response is: { "accountNumber": 1, "address": "Chicago",
		 * "phonenUmber": 3456789087, "accountHolderName": "Vaish", }
		 */

		try {
			mockMvc.perform(get("/account/1")).andExpect(status().is(200));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests fetching account with non-existing AccountNumber
	 */
	@Test
	@Order(4)
	public void findAccountwithnonexistingAccNumber() {
		try {
			mockMvc.perform(get("/account/7")).andExpect(status().is(400));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests updating Address of existing accountNumber
	 */
	@Test
	@Order(5)
	public void updateAccountOfExistingAccNumber() {

		String json = "{\"accountNumber\": 2, \"address\": \"Milwaukee\",\"phoneNumber\": 123457890, \"accountHolderName\":\"Navya\"}";

		try {
			mockMvc.perform(put("/account/2").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
					.andExpect(status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests updating Address for Non-existing AccNumber
	 */
	@Test
	@Order(6)
	public void updateAccountOfNonExistingAccNumber() {

		String json = "{\"accountNumber\": 3, \"address\": \"Milwaukee\",\"phoneNumber\": 123457890, \"accountHolderName\":\"Navya\"}";

		try {
			mockMvc.perform(put("/account/3").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
					.andExpect(status().is(400));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests creating account for existing AccNumber
	 */
	@Test
	@Order(7)
	public void createAccountWithExistingAccNumber() {

		/**
		 *
		 * Create account with AccNumber 2
		 *
		 */

		String json = "{\"accountNumber\": 2, \"address\": \"NaperVille\",\"phoneNumber\": 6789054563, \"accountHolderName\":\"Bhadresh\"}";
		try {
			mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(json)

			).andDo(MockMvcResultHandlers.print()).andExpect(status().is(400));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests deleting account for existing AccNumber
	 */
	@Test
	@Order(8)
	public void deleteAccountWithExistingAccNumber() {

		/**
		 *
		 * Delete account with AccNumber 1
		 *
		 */
		try {
			mockMvc.perform(delete("/account/1")).andExpect(status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * It tests deleting account for non-existing AccNumber
	 */
	@Test
	@Order(9)
	public void deleteAccountWithoutExistingAccNumber() {

		/**
		 *
		 * Delete account with AccNumber 8
		 *
		 */
		try {
			mockMvc.perform(delete("/account/8")).andExpect(status().is(400));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
