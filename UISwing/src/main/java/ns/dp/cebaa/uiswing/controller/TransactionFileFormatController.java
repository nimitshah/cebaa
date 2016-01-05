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
import ns.dp.cebaa.domain.TransactionColumn;
import ns.dp.cebaa.domain.TransactionColumnName;
import ns.dp.cebaa.domain.TransactionFileFormat;
import ns.dp.cebaa.domain.TransactionFileFormat.SeparationType;
import ns.dp.cebaa.uiswing.BeanFactory;
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
			selectBankAccount();
		}
		if(e.getSource() == transactionFileFormatView.getAddFieldBtn()){
			addNewTransactionFileFieldCombo();
		}
		if(e.getSource() == transactionFileFormatView.getRemoveFieldBtn()){
			removeTransactionFileFieldCombo();
			
		}
		if(e.getSource() == transactionFileFormatView.getSubmit()){
			submitForm();
		}
		transactionFileFormatView.revalidate();
		transactionFileFormatView.repaint();
	}

	private void removeTransactionFileFieldCombo() {
		List<JComboBox<TransactionColumnName>> newCols = new ArrayList<>(transactionFileFormatView.getFields());
		newCols.remove(newCols.size()-1);
		transactionFileFormatView.removeAllTransactionFields();
		transactionFileFormatView.getFields().addAll(newCols);
		transactionFileFormatView.addTransactionColComboToPanel();
		
	}

	private void submitForm() {
		String selectedBaStr= (String) transactionFileFormatView.getBankAccountSelect().getSelectedItem();
		Optional<BankAccount> baOpt = bankAccountService.get().stream()
				.filter(ba -> ba.getSortCode().equals(selectedBaStr.split("-")[0]) && ba.getAccountNumber().equals(selectedBaStr.split("-")[1])).findFirst();
		if(!baOpt.isPresent()){
			//TODO: error message
			return;
		}
		BankAccount selectedBa = baOpt.get();
		TransactionFileFormat tff = transactionFileFormatService.get(selectedBa.getId());
		if(tff == null){
			tff = new TransactionFileFormat();
			tff.setBankAccount(selectedBa);
		}
		tff.setSeparation((SeparationType) transactionFileFormatView.getFileFormatSelect().getSelectedItem());
		List<TransactionColumn> txnColumns = transactionFileFormatView.getFields().stream().map(combo -> {
			TransactionColumn col = new TransactionColumn();
			col.setIndex(transactionFileFormatView.getFields().indexOf(combo));
			col.setTransactionColumnName((TransactionColumnName) combo.getSelectedItem());
			return col;
		}).collect(Collectors.toList());
		tff.setFields(txnColumns);
		if(tff.getId() > 0){
			transactionFileFormatService.put(tff);
		}else{
			transactionFileFormatService.post(tff);
		}
	}

	private void selectBankAccount() {
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
		transactionFileFormatView.removeAllTransactionFields();
		if(tff == null){
			addNewTransactionFileFieldCombo();
		}else{
			
			tff.getFields().forEach(f -> {
				transactionFileFormatView.getFields().add(new JComboBox<>());
				JComboBox<TransactionColumnName> field= transactionFileFormatView.getFields().get(transactionFileFormatView.getFields().size()-1);
				ComboBoxModel<TransactionColumnName> transactionColumns = new DefaultComboBoxModel<>(TransactionColumnName.values());
				transactionColumns.setSelectedItem(f.getTransactionColumnName());
				field.setModel(transactionColumns);
				//field.setSelectedItem(f);
			});
		}
		transactionFileFormatView.addTransactionColComboToPanel();
		transactionFileFormatView.getInnerPanel().setVisible(true);
		transactionFileFormatView.getAddFieldBtn().addActionListener(this);
		transactionFileFormatView.getRemoveFieldBtn().addActionListener(this);
	}

	private void addNewTransactionFileFieldCombo() {
		List<JComboBox<TransactionColumnName>> newCols = new ArrayList<>(transactionFileFormatView.getFields());

		JComboBox<TransactionColumnName> txnField= new JComboBox<>();
		txnField.setModel(new DefaultComboBoxModel<TransactionColumnName>(TransactionColumnName.values()));
		newCols.add(txnField);
		transactionFileFormatView.removeAllTransactionFields();
		transactionFileFormatView.getFields().addAll(newCols);
		transactionFileFormatView.addTransactionColComboToPanel();
	}
	
	
	
}
