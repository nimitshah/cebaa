package ns.dp.cebaa.uiswing.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindowView extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnTransactionFile;
	private JMenu mnViewTxn;
	private JMenuItem mntmUpload;
	private JMenuItem mntmFileFormat;
	private JMenuItem mntmViewTtansactions;
	
	public MainWindowView() {
		setSize(600,600);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTransactionFile = new JMenu("File");
		menuBar.add(mnTransactionFile);
		
		mntmUpload = new JMenuItem("Upload");
		mnTransactionFile.add(mntmUpload);
		
		mntmFileFormat = new JMenuItem("File Format");
		mnTransactionFile.add(mntmFileFormat);
		
		mnViewTxn = new JMenu("View");
		menuBar.add(mnViewTxn);
		
		mntmViewTtansactions = new JMenuItem("Transactions");
		mnViewTxn.add(mntmViewTtansactions);
		getContentPane().setPreferredSize(new Dimension(500, 500));
	}

	public JMenuItem getMntmUpload() {
		return mntmUpload;
	}

	public JMenuItem getMntmFileFormat() {
		return mntmFileFormat;
	}

	public JMenuItem getMntmViewTtansactions() {
		return mntmViewTtansactions;
	}
	
	

}
