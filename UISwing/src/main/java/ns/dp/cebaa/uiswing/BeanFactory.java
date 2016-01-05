package ns.dp.cebaa.uiswing;

import ns.dp.cebaa.uiswing.controller.MainWindowController;
import ns.dp.cebaa.uiswing.controller.TransactionFileFormatController;
import ns.dp.cebaa.uiswing.controller.TransactionFileUploadController;
import ns.dp.cebaa.uiswing.service.BankAccountService;
import ns.dp.cebaa.uiswing.service.TransactionFileFormatService;
import ns.dp.cebaa.uiswing.service.TransactionFileUploadService;
import ns.dp.cebaa.uiswing.view.MainWindowView;
import ns.dp.cebaa.uiswing.view.TransactionFileFormatView;
import ns.dp.cebaa.uiswing.view.TransactionFileUploadView;

public class BeanFactory {
	public static final MainWindowView mainWindowView = new MainWindowView();
	public static final TransactionFileFormatView transactionFileFormatView = new TransactionFileFormatView();
	public static final TransactionFileUploadView transactionFileUploadView= new TransactionFileUploadView();
	
	public static final TransactionFileUploadService transactionFileUploadService = new TransactionFileUploadService();
	public static final BankAccountService bankAccountService = new BankAccountService();
	public static final TransactionFileFormatService transactionFileFormatService = new TransactionFileFormatService();
	
	public static final MainWindowController mainWindowController = new MainWindowController(mainWindowView);
	public static final TransactionFileFormatController transactionFileFormatController = new TransactionFileFormatController(transactionFileFormatView);
	public static final TransactionFileUploadController transactionFileUploadController = new TransactionFileUploadController(transactionFileUploadView);
	
}
