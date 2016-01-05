package ns.dp.cebaa.uiswing.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ns.dp.cebaa.domain.Bank;
import ns.dp.cebaa.domain.BankAccount;
import ns.dp.cebaa.domain.TransactionColumn;
import ns.dp.cebaa.domain.TransactionColumnName;
import ns.dp.cebaa.domain.TransactionFileFormat;
import ns.dp.cebaa.domain.TransactionFileFormat.SeparationType;

public class TransactionFileFormatService {
	public TransactionFileFormat get(long bankAccountId){
		TransactionFileFormat tff = new TransactionFileFormat();
		Bank bank = new Bank();
		bank.setName("Santandar");
		BankAccount ba = new BankAccount();
		ba.setAccountHolder("NS");
		ba.setAccountNumber("12345678");
		ba.setSortCode("123456");
		ba.setBank(bank);
		tff.setBankAccount(ba);
		
		List<TransactionColumn> fields = new ArrayList<>();
		TransactionColumn col1 = new TransactionColumn();
		col1.setIndex(1);
		col1.setTransactionColumnName(TransactionColumnName.TRANSACTION_DATE);
		
		TransactionColumn col2 = new TransactionColumn();
		col2.setIndex(2);
		col2.setTransactionColumnName(TransactionColumnName.DESCRIPTION);
		
		TransactionColumn col3 = new TransactionColumn();
		col3.setIndex(3);
		col3.setTransactionColumnName(TransactionColumnName.PAYMENT_TYPE);
		
		TransactionColumn col4 = new TransactionColumn();
		col4.setIndex(4);
		col4.setTransactionColumnName(TransactionColumnName.AMOUNT);
		
		fields.add(col1);
		fields.add(col2);
		fields.add(col3);
		fields.add(col4);
		tff.setFields(fields);
		tff.setSeparation(SeparationType.COMMA);
		return tff;
	}
	
	public void post(TransactionFileFormat tff){
		
	}
	
	public void put(TransactionFileFormat tff){
		
	}
}
