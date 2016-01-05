package ns.dp.cebaa.uiswing.view;

import javax.swing.*;

import ns.dp.cebaa.domain.TransactionColumnName;
import ns.dp.cebaa.domain.TransactionFileFormat;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TransactionFileFormatView extends JPanel {
	private JComboBox<String> bankAccountSelect= new JComboBox<>();
	private JComboBox<TransactionFileFormat.SeparationType> fileFormatSelect = new JComboBox<>();
	private List<JComboBox<TransactionColumnName>> fields=new ArrayList<JComboBox<TransactionColumnName>>();
	private JButton addFieldBtn;
	private JButton removeFieldBtn;
	private JButton submit;
	private JPanel innerPanel;
	public TransactionFileFormatView() {
		int gridy = 1;
		setLayout(new MigLayout("", "[40%][40%][10%]", "[27px][438px]"));
		
		JLabel lblSelectBankAccount = new JLabel("Select Bank Account");
		this.add(lblSelectBankAccount, "cell 0 0,alignx left,aligny center");
		setSize(500, 500);
		this.add(bankAccountSelect, "cell 1 0,growx,aligny center");
		
		innerPanel = new JPanel();
		add(innerPanel, "cell 0 1 3 1,grow");
				innerPanel.setLayout(new MigLayout("", "[40%][40%][10%]", "[27px][29px][29px][16px][]"));
		
				JLabel lblFileFormat = new JLabel("File Format");
				innerPanel.add(lblFileFormat, "cell 0 0,alignx left,aligny center");
		innerPanel.add(fileFormatSelect, "cell 1 0,growx,aligny center");
		
		removeFieldBtn = new JButton("-");
		innerPanel.add(removeFieldBtn, "cell 0 1,alignx center,aligny center");
		
		
		addFieldBtn = new JButton("+");
		innerPanel.add(addFieldBtn, "cell 0 2,alignx center,aligny center");
		
		
		JButton btnNewButton = new JButton("Submit");
		innerPanel.add(btnNewButton, "cell 0 3,alignx center,aligny center");
		
		JLabel lblFields = new JLabel("Fields");
		innerPanel.add(lblFields, "cell 0 4,alignx left,aligny center");

		addTransactionColComboToPanel();
		innerPanel.setVisible(false);
	}
	
	public void addTransactionColComboToPanel() {
		int gridy = 4;
		for(int i=0;i<fields.size();i++){
			JComboBox<TransactionColumnName> field= fields.get(i);
			innerPanel.add(field, "cell 1 "+(gridy+i)+",alignx left,aligny center");
		}
		
	}

	public void removeAllTransactionFields(){
		for(int i=0;i<fields.size();i++){
			innerPanel.remove(fields.get(i));
		}
		fields = new ArrayList<>();
	}

	public JComboBox<String> getBankAccountSelect() {
		return bankAccountSelect;
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

	public JPanel getInnerPanel() {
		return innerPanel;
	}

	public JButton getAddFieldBtn() {
		return addFieldBtn;
	}

	public JButton getRemoveFieldBtn() {
		return removeFieldBtn;
	}
	
	

}
