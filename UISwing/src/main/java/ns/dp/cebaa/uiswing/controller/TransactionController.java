package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import ns.dp.cebaa.domain.Transaction;
import ns.dp.cebaa.uiswing.BeanFactory;
import ns.dp.cebaa.uiswing.service.TransactionService;
import ns.dp.cebaa.uiswing.view.ShowTransactionsView;

public class TransactionController implements ActionListener {

	private ShowTransactionsView showTransactionsView;
	private TransactionService transactionService;

	public TransactionController(ShowTransactionsView showTxnView) {
		this.showTransactionsView = showTxnView;
		transactionService = BeanFactory.transactionService;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	public void init() {
		//TODO: get local dates from the view
		List<Transaction> transactions= transactionService.get(LocalDate.now(), LocalDate.now());
		DefaultTableModel dtm = (DefaultTableModel) showTransactionsView.getTransactionsTable().getModel();
	    String header[] = new String[] { "Date", "Desc", "Amount", "Type" };
	    dtm.setColumnIdentifiers(header);
		IntStream.range(0, transactions.size()).forEach(i -> {
			Transaction txn = transactions.get(0);
			dtm.addRow(new Object[]{txn.getTransactionDate(), txn.getDescription(), txn.getAmount(), txn.getPaymentType()});
		});
		
		showTransactionsView.repaint();
	}

}
