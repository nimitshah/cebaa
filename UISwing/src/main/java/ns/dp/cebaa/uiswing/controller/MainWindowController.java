package ns.dp.cebaa.uiswing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ns.dp.cebaa.uiswing.ui.MainWindowView;

public class MainWindowController implements ActionListener {

	private MainWindowView mainWindowView;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainWindowView = new MainWindowView();

	}

}
