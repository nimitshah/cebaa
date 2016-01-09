package ns.dp.cebaa.uiswing.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import ns.dp.cebaa.domain.Bank;
import ns.dp.cebaa.domain.BankAccount;
import ns.dp.cebaa.domain.PaymentType;
import ns.dp.cebaa.domain.Transaction;

public class TransactionService {
	public List<Transaction> get(LocalDate startDate, LocalDate endDate){
		Bank bank = new Bank();
		bank.setName("Santandar");
		bank.setId(1);
		
		BankAccount ba = new BankAccount();
		ba.setAccountHolder("NS");
		ba.setAccountNumber("12345678");
		ba.setSortCode("123456");
		ba.setAccountType("current");
		ba.setBank(bank);
		
		Transaction tr1 = new Transaction();
		tr1.setId(1);
		tr1.setAmount(50);
		tr1.setPaymentType(PaymentType.DR);
		tr1.setDescription("sainsburrys");
		tr1.setPostingDate(LocalDate.of(2015, 12, 1));
		tr1.setTransactionDate(LocalDate.of(2015, 12, 1));
		tr1.setBankAccount(ba);
		
		Transaction tr2 = new Transaction();
		tr2.setId(1);
		tr2.setAmount(50);
		tr2.setPaymentType(PaymentType.DR);
		tr2.setDescription("sainsburrys");
		tr2.setPostingDate(LocalDate.of(2015, 12, 1));
		tr2.setTransactionDate(LocalDate.of(2015, 12, 1));
		tr2.setBankAccount(ba);
		return Arrays.asList(tr1, tr2);
	}
}
