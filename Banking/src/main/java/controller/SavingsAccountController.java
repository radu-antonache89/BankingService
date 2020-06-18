package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.SavingsAccount;
import model.User;
import service.SavingsAccountService;
import service.UserService;
import utils.DateTimeUtility;
import utils.JsonSerializer;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/savingsAccounts")
public class SavingsAccountController {
	
	@Autowired
	SavingsAccountService accountService = new SavingsAccountService();
	
	JsonSerializer xmlSerializer = new JsonSerializer();
	
	@RequestMapping("/all")
	public LinkedHashMap<String, SavingsAccount> getAll() {
		return accountService.getAll();
	}
	
	@RequestMapping("/add")
	public String addSavingsAccount(@RequestParam("user") String p_username,
									@RequestParam("pass") String p_password,
									@RequestParam("initialDeposit") double p_initialDeposit) {
		
		UserService userService = new UserService();
		accountService = xmlSerializer.readSavingsAccounts();
		if (!userService.isValidUser(p_username, p_password)) {
			return "Error! The account with username: " + p_username + " and password: " + p_password + " does not exist."; 
		}
		
		if (!DateTimeUtility.canOpenNewAccount()) {
			return "Error! A new savings account can only be opened from Monday to Friday, within working hours (" 
					+ DateTimeUtility.WORKING_DAY_START + " - " + DateTimeUtility.WORKING_DAY_END + ")";
		}
		
		User user = userService.getUserByUsername(p_username);
		String userId = user.getId();
		LinkedHashMap<String, SavingsAccount> accounts = accountService.getAll();
		for (Map.Entry<String, SavingsAccount> account : accounts.entrySet()) {
			if (account.getValue().getUserId().equals(userId)) {
				return "Error! This user already has a savings account.";
			}
		}
		
		user.createSavingsAccount(p_initialDeposit);
		accountService.addAccount(user.getId(), p_initialDeposit);
		
		JsonSerializer jsonSerializer = new JsonSerializer();
		jsonSerializer.writeSavingsAccounts(accountService);
		
		SavingsAccount account = user.getSavingsAccount();
		return "Success! New savings account opened. ID: " + account.getUserId() + " Balance: " + account.getBalance();
		
	}
	
	@RequestMapping("/delete")
	public String deleteSavingsAccount(@RequestParam("user") String p_username,
									   @RequestParam("pass") String p_password) {
		
		UserService userService = new UserService();
		
		if (!userService.isValidUser(p_username, p_password)) {
			return "Error! The account with username: " + p_username + " and password: " + p_password + " does not exist."; 
		}
		
		User user = userService.getUserByUsername(p_username);
		
		if (user.hasSavingsAccount()) {
			user.deleteSavingsAccount();
		}
		
		return "Savings account deleted for user with ID: " + user.getId();
	}
	
	@RequestMapping("{id}")
	public SavingsAccount getAccount(@PathVariable("id") String id) {
		return accountService.getAccountWithId(id);
	}
	
	
}
