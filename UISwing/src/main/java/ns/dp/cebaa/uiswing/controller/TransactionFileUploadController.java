package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;

import ns.dp.cebaa.uiswing.BeanFactory;
import ns.dp.cebaa.uiswing.service.BankAccountService;
import ns.dp.cebaa.uiswing.service.TransactionFileUploadService;
import ns.dp.cebaa.uiswing.view.TransactionFileUploadView;

public class TransactionFileUploadController implements ActionListener {
	private TransactionFileUploadView transactionFileUploadView;
	private TransactionFileUploadService transactionFileUploadService;
	private BankAccountService bankAccountService;
	
	public TransactionFileUploadController(TransactionFileUploadView tfuView) {
		super();
		this.transactionFileUploadView = tfuView;
		transactionFileUploadService = BeanFactory.transactionFileUploadService;
		bankAccountService = BeanFactory.bankAccountService;
		transactionFileUploadView.getBtnUploadFile().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == transactionFileUploadView.getBtnUploadFile()){
			transactionFileUploadService.uploadFile(new File(transactionFileUploadView.getTextField().getText()));
		}
		
	}


	public void init() {
		List<String> bankAccountsStr = new ArrayList<>();
		bankAccountsStr.add("--SELECT--");
		bankAccountsStr.addAll(bankAccountService.get().stream().map(ba-> ba.toString()).collect(Collectors.toList()));
		String[] baAry = bankAccountsStr.toArray(new String[]{});
		transactionFileUploadView.getBankAccountSelect().setModel(new DefaultComboBoxModel<String>(baAry));
	}

}
