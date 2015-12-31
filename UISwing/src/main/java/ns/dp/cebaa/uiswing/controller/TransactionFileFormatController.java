package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.html.Option;

import ns.dp.cebaa.domain.BankAccount;
import ns.dp.cebaa.domain.TransactionColumnName;
import ns.dp.cebaa.domain.TransactionFileFormat;
import ns.dp.cebaa.uiswing.service.BankAccountService;
import ns.dp.cebaa.uiswing.service.TransactionFileFormatService;
import ns.dp.cebaa.uiswing.view.TransactionFileFormatView;

public class TransactionFileFormatController implements ActionListener {
	private TransactionFileFormatView transactionFileFormatView;
	
	private static final BankAccountService bankAccountService = new BankAccountService();
	private static final TransactionFileFormatService transactionFileFormatService = new TransactionFileFormatService();

	public TransactionFileFormatController(TransactionFileFormatView view) {
		transactionFileFormatView = view;
	}

	public TransactionFileFormatView getTransactionFileFormatView() {
		List<String> bankAccountsStr = new ArrayList<>();
		bankAccountsStr.add("--SELECT--");
		bankAccountsStr.addAll(bankAccountService.get().stream().map(ba-> ba.toString()).collect(Collectors.toList()));
		String[] baAry = bankAccountsStr.toArray(new String[]{});
		transactionFileFormatView.getBankAccountSelect().setModel(
				new DefaultComboBoxModel<String>(baAry));
		
		transactionFileFormatView.getBankAccountSelect().addActionListener(this);
		return transactionFileFormatView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == transactionFileFormatView.getBankAccountSelect()){
			String selectedBaStr= (String) transactionFileFormatView.getBankAccountSelect().getSelectedItem();
			Optional<BankAccount> baOpt = bankAccountService.get().stream()
					.filter(ba -> ba.getSortCode().equals(selectedBaStr.split("-")[0]) && ba.getAccountNumber().equals(selectedBaStr.split("-")[1])).findFirst();
			if(!baOpt.isPresent()){
				//TODO: error message
				return;
			}
			BankAccount selectedBa = baOpt.get();
			TransactionFileFormat tff = transactionFileFormatService.get(selectedBa.getId());
			transactionFileFormatView.getFileFormatSelect().setModel(
					new DefaultComboBoxModel<TransactionFileFormat.SeparationType>(TransactionFileFormat.SeparationType.values()));
			if(tff == null){
				transactionFileFormatView.addTransactionField();
				transactionFileFormatView.getFields().forEach(f -> {
					f.setModel(new DefaultComboBoxModel<TransactionColumnName>(TransactionColumnName.values()));
				});
			}else{

				tff.getFields().forEach(f -> {
					transactionFileFormatView.addTransactionField();
					JComboBox<TransactionColumnName> field= transactionFileFormatView.getFields().get(transactionFileFormatView.getFields().size()-1);
					ComboBoxModel<TransactionColumnName> transactionColumns = new DefaultComboBoxModel<>(TransactionColumnName.values());
					transactionColumns.setSelectedItem(tff.getFields());
					field.setModel(transactionColumns);
					field.setSelectedItem(f);
				});
			}
		}
		
	}
	
	
	
}
