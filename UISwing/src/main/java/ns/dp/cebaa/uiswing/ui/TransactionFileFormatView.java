package ns.dp.cebaa.uiswing.ui;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransactionFileFormatView extends JInternalFrame{
	public TransactionFileFormatView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 70, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSelectBankAccount = new JLabel("Select Bank Account");
		GridBagConstraints gbc_lblSelectBankAccount = new GridBagConstraints();
		gbc_lblSelectBankAccount.anchor = GridBagConstraints.WEST;
		gbc_lblSelectBankAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectBankAccount.gridx = 1;
		gbc_lblSelectBankAccount.gridy = 1;
		getContentPane().add(lblSelectBankAccount, gbc_lblSelectBankAccount);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblFileFormat = new JLabel("File Format");
		GridBagConstraints gbc_lblFileFormat = new GridBagConstraints();
		gbc_lblFileFormat.anchor = GridBagConstraints.WEST;
		gbc_lblFileFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileFormat.gridx = 1;
		gbc_lblFileFormat.gridy = 2;
		getContentPane().add(lblFileFormat, gbc_lblFileFormat);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 2;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblFields = new JLabel("Fields");
		GridBagConstraints gbc_lblFields = new GridBagConstraints();
		gbc_lblFields.anchor = GridBagConstraints.WEST;
		gbc_lblFields.insets = new Insets(0, 0, 0, 5);
		gbc_lblFields.gridx = 1;
		gbc_lblFields.gridy = 3;
		getContentPane().add(lblFields, gbc_lblFields);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 3;
		getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 3;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
