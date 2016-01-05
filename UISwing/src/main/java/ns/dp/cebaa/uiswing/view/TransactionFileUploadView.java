package ns.dp.cebaa.uiswing.view;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import ns.dp.cebaa.uiswing.BeanFactory;

public class TransactionFileUploadView extends JPanel {
	private JTextField textField;
	private JButton btnUploadFile;
	private JComboBox<String> bankAccountSelect;
	public TransactionFileUploadView() {
		setSize(new Dimension(500, 500));
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setControlButtonsAreShown(false);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		JDialog dialog = new JDialog(BeanFactory.mainWindowView);
		
		setLayout(new MigLayout("", "[][grow]", "[][44.00][]"));
		
		JLabel lblSelectBankAccount = new JLabel("Select Bank Account");
		add(lblSelectBankAccount, "cell 0 0");
		
		bankAccountSelect = new JComboBox<>();
		add(bankAccountSelect, "cell 1 0,growx");
		
		JLabel lblUploadFile = new JLabel("Upload File");
		add(lblUploadFile, "cell 0 1");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		
		textField = new JTextField();
		textField.setColumns(20);
		
		JButton chooseFile = new JButton("...");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(chooseFile, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chooseFile)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(6, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		btnUploadFile = new JButton("Upload File");
		add(btnUploadFile, "cell 1 2");
		
		chooseFile.addActionListener(ae -> {
			fileChooser.showOpenDialog(dialog);
		});
		fileChooser.addActionListener(ae -> {
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			repaint();
		});

	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnUploadFile() {
		return btnUploadFile;
	}
	public JComboBox<String> getBankAccountSelect() {
		return bankAccountSelect;
	}
	
	

}
