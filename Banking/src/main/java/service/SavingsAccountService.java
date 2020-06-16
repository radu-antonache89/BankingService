package service;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import model.SavingsAccount;

@Service
public class SavingsAccountService {

	LinkedHashMap<String, SavingsAccount> accounts = new LinkedHashMap<String, SavingsAccount>();

	public SavingsAccountService() {
	}

	public SavingsAccount getAccountWithId(String id) {
		if (accounts.containsKey(id))
			return accounts.get(id);
		else
			return null;
	}

	public LinkedHashMap<String, SavingsAccount> getAll() {
		return accounts;
	}

	public void addAccount(String userId, double initialBalance) {
		SavingsAccount newAccount = new SavingsAccount();
		newAccount.setUserId(userId);
		newAccount.deposit(initialBalance);
		accounts.put(userId, newAccount);
	}
}
