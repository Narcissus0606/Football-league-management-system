package common;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
/**
 * @author:Narcissus
 * @date:2018.12.27 
 * @Description:该类用于将对话框居中显示，使用是只要在创建对话框时继承该类，
 * 并且在设置完对话框大小之后调用super.center();方法即可。
 */

public class CenterDialog extends JDialog {
	
	public void center(){
		this.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
		  frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		  frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

	}
	
}
