package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import ns.dp.cebaa.uiswing.Application;
import ns.dp.cebaa.uiswing.ui.MainWindowView;
import ns.dp.cebaa.uiswing.ui.TransactionFileFormatView;

public class MainWindowController implements ActionListener, WindowListener {

	private MainWindowView mainWindowView;
	private TransactionFileFormatController transactionFileFormatController;
	
	public MainWindowController() {
		mainWindowView = new MainWindowView();
		mainWindowView.getMntmFileFormat().addActionListener(this);
		mainWindowView.addWindowListener(this);
		mainWindowView.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(mainWindowView.getMntmFileFormat())){
			mainWindowView.getContentPane().removeAll();
			TransactionFileFormatView tffView = new TransactionFileFormatView();
			transactionFileFormatController = new TransactionFileFormatController(tffView);
			mainWindowView.setContentPane(tffView);
			mainWindowView.pack();
			transactionFileFormatController.getTransactionFileFormatView().setVisible(true);
			//mainWindowView.paint(g);
		}

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
