package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import ns.dp.cebaa.uiswing.Application;
import ns.dp.cebaa.uiswing.BeanFactory;
import ns.dp.cebaa.uiswing.view.MainWindowView;
import ns.dp.cebaa.uiswing.view.ShowTransactionsView;
import ns.dp.cebaa.uiswing.view.TransactionFileFormatView;
import ns.dp.cebaa.uiswing.view.TransactionFileUploadView;

public class MainWindowController implements ActionListener, WindowListener {

	private MainWindowView mainWindowView;
	private TransactionFileFormatController transactionFileFormatController;
	private TransactionFileUploadController transactionFileUploadController;
	private TransactionController transactionController;
	
	public MainWindowController(MainWindowView mainWindowView) {
		this.mainWindowView = mainWindowView;
	}
	
	public void init(){
		mainWindowView.getMntmFileFormat().addActionListener(this);
		mainWindowView.getMntmUpload().addActionListener(this);
		mainWindowView.getMntmViewTtansactions().addActionListener(this);
		mainWindowView.addWindowListener(this);
		mainWindowView.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainWindowView.getContentPane().removeAll();
		if(e.getSource().equals(mainWindowView.getMntmFileFormat())){
			TransactionFileFormatView tffView = BeanFactory.transactionFileFormatView;
			transactionFileFormatController = BeanFactory.transactionFileFormatController;
			mainWindowView.setContentPane(tffView);
			
			//transactionFileFormatController.getTransactionFileFormatView().setVisible(true);
		}
		if(e.getSource().equals(mainWindowView.getMntmUpload())){
			TransactionFileUploadView tfUploadView = BeanFactory.transactionFileUploadView;
			transactionFileUploadController = BeanFactory.transactionFileUploadController;
			transactionFileUploadController.init();
			mainWindowView.setContentPane(tfUploadView);
		}
		if(e.getSource().equals(mainWindowView.getMntmViewTtansactions())){
			ShowTransactionsView showTransactionsView = BeanFactory.showTransactionsView;
			transactionController = BeanFactory.transactionController;
			transactionController.init();
			mainWindowView.setContentPane(showTransactionsView);
		}
		mainWindowView.pack();
		mainWindowView.repaint();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mainWindowView.setVisible(false);
		mainWindowView.dispose();
		Application.shutdown();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
