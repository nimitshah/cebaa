package ns.dp.cebaa.uiswing.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ShowTransactionsView extends JPanel {
	private JTable transactionsTable;
	public ShowTransactionsView() {
		setLayout(new MigLayout("", "[grow]", "[90.00,grow][grow]"));
		
		JPanel filterPanel = new JPanel();
		add(filterPanel, "cell 0 0,grow");
		filterPanel.setLayout(new MigLayout("", "[][][][][][][][][][][][]", "[][]"));
		
		JLabel lblFrom = new JLabel("From");
		filterPanel.add(lblFrom, "cell 0 1");
		
		JLabel lblTo = new JLabel("To");
		filterPanel.add(lblTo, "cell 4 1");
		
		JButton btnSubmit = new JButton("Submit");
		filterPanel.add(btnSubmit, "cell 11 1");
		
		JPanel transactionsPanel = new JPanel();
		add(transactionsPanel, "cell 0 1,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		transactionsPanel.add(scrollPane);
		
		
		DefaultTableModel dtm = new DefaultTableModel();

		transactionsTable = new JTable(dtm);
		scrollPane.setViewportView(transactionsTable);
	}
	public JTable getTransactionsTable() {
		return transactionsTable;
	}

	
}
