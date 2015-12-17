package ns.dp.cebaa.uiswing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TransactionFileFormatView extends JPanel {
	private JComboBox bankAccountSelect;
	private JComboBox fileFormatSelect;
	private List<JComboBox> fields=new ArrayList<JComboBox>();
	private List<JButton> addFieldBtns= new ArrayList<JButton>();
	private JButton submit;
	public TransactionFileFormatView() {
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
		
		bankAccountSelect = new JComboBox();
		GridBagConstraints gbc_bankAccountSelect = new GridBagConstraints();
		gbc_bankAccountSelect.insets = new Insets(0, 0, 5, 5);
		gbc_bankAccountSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_bankAccountSelect.gridx = 3;
		gbc_bankAccountSelect.gridy = gridy++;
		this.add(bankAccountSelect, gbc_bankAccountSelect);
		
		JLabel lblFileFormat = new JLabel("File Format");
		GridBagConstraints gbc_lblFileFormat = new GridBagConstraints();
		gbc_lblFileFormat.anchor = GridBagConstraints.WEST;
		gbc_lblFileFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileFormat.gridx = 1;
		gbc_lblFileFormat.gridy = gridy;
		this.add(lblFileFormat, gbc_lblFileFormat);
		
		fileFormatSelect = new JComboBox();
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
		
		fields.add(new JComboBox<>());
		addFieldBtns.add(new JButton("+"));
		for(int i=0;i<fields.size();i++){
			JComboBox field= fields.get(i);
			GridBagConstraints gbc_field1 = new GridBagConstraints();
			gbc_field1.insets = new Insets(0, 0, 0, 5);
			gbc_field1.fill = GridBagConstraints.HORIZONTAL;
			gbc_field1.gridx = 3;
			gbc_field1.gridy = gridy;
			this.add(field, gbc_field1);
			
			JButton btnNewButton = addFieldBtns.get(i);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 4;
			gbc_btnNewButton.gridy = gridy++;
			this.add(btnNewButton, gbc_btnNewButton);
		}
		JButton btnNewButton = new JButton("Submit");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = gridy++;
		this.add(btnNewButton, gbc_btnNewButton);
	}

}
