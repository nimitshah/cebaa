package ns.dp.cebaa.uiswing.service;

import java.util.Arrays;
import java.util.List;

import ns.dp.cebaa.domain.Bank;
import ns.dp.cebaa.domain.BankAccount;

public class BankAccountService {
	public List<BankAccount> get(){
		Bank bank = new Bank();
		bank.setName("Santandar");
		bank.setId(1);
		
		BankAccount ba = new BankAccount();
		ba.setAccountHolder("NS");
		ba.setAccountNumber("12345678");
		ba.setSortCode("123456");
		ba.setAccountType("current");
		ba.setBank(bank);
		
		BankAccount ba1 = new BankAccount();
		ba.setAccountHolder("NS");
		ba.setAccountNumber("12345679");
		ba.setSortCode("123456");
		ba.setAccountType("savings");
		ba.setBank(bank);
		return Arrays.asList(ba, ba1);
	}
}
