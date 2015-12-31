package ns.dp.cebaa.uiswing.view;

import javax.swing.*;

import ns.dp.cebaa.domain.TransactionColumnName;
import ns.dp.cebaa.domain.TransactionFileFormat;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TransactionFileFormatView extends JPanel {
	private JComboBox<String> bankAccountSelect= new JComboBox<>();
	private JComboBox<TransactionFileFormat.SeparationType> fileFormatSelect = new JComboBox<>();
	private List<JComboBox<TransactionColumnName>> fields=new ArrayList<JComboBox<TransactionColumnName>>();
	private List<JButton> addFieldBtns= new ArrayList<JButton>();
	private List<JButton> removeFieldBtns= new ArrayList<JButton>();
	private JButton submit;
	public TransactionFileFormatView() {
		setSize(500, 500);
		int gridy = 1;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 70, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblSelectBankAccount = new JLabel("Select Bank Account");
		GridBagConstraints gbc_lblSelectBankAccount = new GridBagConstraints();
		gbc_lblSelectBankAccount.anchor = GridBagConstraints.WEST;
		gbc_lblSelectBankAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectBankAccount.gridx = 1;
		gbc_lblSelectBankAccount.gridy = gridy;
		this.add(lblSelectBankAccount, gbc_lblSelectBankAccount);
		
		GridBagConstraints gbc_bankAccountSelect = new GridBagConstraints();
		gbc_bankAccountSelect.insets = new Insets(0, 0, 5, 5);
		gbc_bankAccountSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_bankAccountSelect.gridx = 3;
		gbc_bankAccountSelect.gridy = gridy++;
		this.add(bankAccountSelect, gbc_bankAccountSelect);
		

	}
	
	public void showFileFormatFields(){
		int gridy = 2;
		JLabel lblFileFormat = new JLabel("File Format");
		GridBagConstraints gbc_lblFileFormat = new GridBagConstraints();
		gbc_lblFileFormat.anchor = GridBagConstraints.WEST;
		gbc_lblFileFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileFormat.gridx = 1;
		gbc_lblFileFormat.gridy = gridy;
		this.add(lblFileFormat, gbc_lblFileFormat);
		
		GridBagConstraints gbc_fileFormatSelect = new GridBagConstraints();
		gbc_fileFormatSelect.insets = new Insets(0, 0, 5, 5);
		gbc_fileFormatSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_fileFormatSelect.gridx = 3;
		gbc_fileFormatSelect.gridy = gridy++;
		this.add(fileFormatSelect, gbc_fileFormatSelect);
		
		JLabel lblFields = new JLabel("Fields");
		GridBagConstraints gbc_lblFields = new GridBagConstraints();
		gbc_lblFields.anchor = GridBagConstraints.WEST;
		gbc_lblFields.insets = new Insets(0, 0, 0, 5);
		gbc_lblFields.gridx = 1;
		gbc_lblFields.gridy = gridy;
		this.add(lblFields, gbc_lblFields);

		for(int i=0;i<fields.size();i++){
			JComboBox<TransactionColumnName> field= fields.get(i);
			GridBagConstraints gbc_field1 = new GridBagConstraints();
			gbc_field1.insets = new Insets(0, 0, 0, 5);
			gbc_field1.fill = GridBagConstraints.HORIZONTAL;
			gbc_field1.gridx = 3;
			gbc_field1.gridy = gridy;
			this.add(field, gbc_field1);
			
			JButton btnAddButton = addFieldBtns.get(i);
			GridBagConstraints gbc_btnAddButton = new GridBagConstraints();
			gbc_btnAddButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnAddButton.gridx = 4;
			gbc_btnAddButton.gridy = gridy;
			this.add(btnAddButton, gbc_btnAddButton);
			
			JButton btnRemoveButton = removeFieldBtns.get(i);
			GridBagConstraints gbc_btnRemoveButton = new GridBagConstraints();
			gbc_btnRemoveButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnRemoveButton.gridx = 5;
			gbc_btnRemoveButton.gridy = gridy++;
			this.add(btnRemoveButton, gbc_btnRemoveButton);
		}
		JButton btnNewButton = new JButton("Submit");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = gridy++;
		this.add(btnNewButton, gbc_btnNewButton);
	}
	
	public void addTransactionField(){
		fields.add(new JComboBox<>());
		addFieldBtns.add(new JButton("+"));
		addFieldBtns.get(addFieldBtns.size()-1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addTransactionField();
			}
		});
		
		removeFieldBtns.add(new JButton("-"));
		removeFieldBtns.get(removeFieldBtns.size()-1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fields.remove(removeFieldBtns.size()-1);
				addFieldBtns.remove(removeFieldBtns.size()-1);
				removeFieldBtns.remove(removeFieldBtns.size()-1);
			}
		});
	}
	public JComboBox<String> getBankAccountSelect() {
		return bankAccountSelect;
	}
	public List<JButton> getAddFieldBtns() {
		return addFieldBtns;
	}
	public JButton getSubmit() {
		return submit;
	}

	public List<JComboBox<TransactionColumnName>> getFields() {
		return fields;
	}

	public JComboBox<TransactionFileFormat.SeparationType> getFileFormatSelect() {
		return fileFormatSelect;
	}

	public List<JButton> getRemoveFieldBtns() {
		return removeFieldBtns;
	}
	
	

}
