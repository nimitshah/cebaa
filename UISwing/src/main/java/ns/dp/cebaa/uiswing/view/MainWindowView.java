package ns.dp.cebaa.uiswing.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindowView extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnTransactionFile;
	private JMenuItem mntmUpload;
	private JMenuItem mntmFileFormat;
	
	public MainWindowView() {
		setSize(500,500);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTransactionFile = new JMenu("Transaction File");
		menuBar.add(mnTransactionFile);
		
		mntmUpload = new JMenuItem("Upload");
		mnTransactionFile.add(mntmUpload);
		
		mntmFileFormat = new JMenuItem("File Format");
		mnTransactionFile.add(mntmFileFormat);
	}

	public JMenuItem getMntmUpload() {
		return mntmUpload;
	}

	public JMenuItem getMntmFileFormat() {
		return mntmFileFormat;
	}
	
	

}
