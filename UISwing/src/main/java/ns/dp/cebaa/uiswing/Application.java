package ns.dp.cebaa.uiswing;

import javax.swing.SwingUtilities;

import ns.dp.cebaa.uiswing.controller.MainWindowController;

/**
 * Created by nimit on 13/12/2015.
 */
public class Application {
    public static void main(String... a){
        //ns.dp.cebaa.Application.main(a);
        new MainWindowController();
//        SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				new MainWindowController();
//			}
//		});
    }

    public static void shutdown(){
    	ns.dp.cebaa.Application.close();
    }
}
