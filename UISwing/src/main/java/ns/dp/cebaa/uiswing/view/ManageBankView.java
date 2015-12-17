package ns.dp.cebaa.uiswing.view;

import javax.swing.*;
import java.awt.*;

public class ManageBankView extends JFrame {
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 150;
    private JTextField txtBankName;

    public ManageBankView(){
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
    	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	getContentPane().setLayout(gridBagLayout);
    	
    	JLabel lblEnterBank = new JLabel("Enter Bank");
    	GridBagConstraints gbc_lblEnterBank = new GridBagConstraints();
    	gbc_lblEnterBank.insets = new Insets(0, 0, 5, 5);
    	gbc_lblEnterBank.gridx = 1;
    	gbc_lblEnterBank.gridy = 1;
    	getContentPane().add(lblEnterBank, gbc_lblEnterBank);
    	
    	txtBankName = new JTextField();
    	GridBagConstraints gbc_txtBankName = new GridBagConstraints();
    	gbc_txtBankName.insets = new Insets(0, 0, 5, 0);
    	gbc_txtBankName.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtBankName.gridx = 3;
    	gbc_txtBankName.gridy = 1;
    	getContentPane().add(txtBankName, gbc_txtBankName);
    	txtBankName.setColumns(10);
    	
    	JButton btnAdd = new JButton("Add");
    	GridBagConstraints gbc_btnAdd = new GridBagConstraints();
    	gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
    	gbc_btnAdd.gridx = 1;
    	gbc_btnAdd.gridy = 3;
    	getContentPane().add(btnAdd, gbc_btnAdd);

    }
}
