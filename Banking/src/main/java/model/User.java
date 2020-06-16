package model;

public class User {

	private String id;
	private String username;
	private String password;
	private SavingsAccount savingsAccount;

	public User() {
	}

	public User(String p_id, String p_username, String p_password, SavingsAccount p_account) {
		this.id = p_id;
		this.username = p_username;
		this.password = p_password;
		this.savingsAccount = p_account;
	}

	public String getId() {
		return id;
	}

	public void setId(String p_id) {
		this.id = p_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String p_username) {
		this.username = p_username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String p_password) {
		this.password = p_password;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount p_account) {
		this.savingsAccount = p_account;
	}

	public boolean hasSavingsAccount() {
		return getSavingsAccount() != null;
	}
	
	public void createSavingsAccount(double initialDeposit) {
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.deposit(initialDeposit);
		savingsAccount.setUserId(id);
		this.setSavingsAccount(savingsAccount);;
	}
	
	public void deleteSavingsAccount() {
		this.setSavingsAccount(null);
	}
}
