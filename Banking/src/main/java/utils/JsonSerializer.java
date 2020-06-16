package utils;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.SavingsAccountService;

public class JsonSerializer {

	public void writeSavingsAccounts(SavingsAccountService accountService) {
		
		try
		{
			File file = new File("savings_account_data.json");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(file, accountService);
		}
		catch (Exception e)
		{
			System.out.println("Error while serializing SavingsAccountService. Message: " + e.getMessage());
		}
		
	}
	
	public SavingsAccountService readSavingsAccounts() {
		try 
		{
			File file = new File("savings_account_data.json");
			ObjectMapper objectMapper = new ObjectMapper();
			SavingsAccountService service = objectMapper.readValue(file, SavingsAccountService.class);
			return service;
		}
		catch (Exception e)
		{
			System.out.println("Error while deserializing SavingsAccountService. Message: " + e.getMessage());
		}
		return null;
	}
}
