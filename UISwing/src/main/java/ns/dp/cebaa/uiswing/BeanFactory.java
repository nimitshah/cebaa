package ns.dp.cebaa.uiswing;

import ns.dp.cebaa.uiswing.controller.MainWindowController;
import ns.dp.cebaa.uiswing.controller.TransactionFileFormatController;
import ns.dp.cebaa.uiswing.view.MainWindowView;
import ns.dp.cebaa.uiswing.view.TransactionFileFormatView;

public class BeanFactory {
	public static final MainWindowView mainWindowView = new MainWindowView();
	public static final TransactionFileFormatView transactionFileFormatView = new TransactionFileFormatView();
	
	public static final MainWindowController mainWindowController = new MainWindowController(mainWindowView);
	public static final TransactionFileFormatController transactionFileFormatController = new TransactionFileFormatController(transactionFileFormatView);
}
