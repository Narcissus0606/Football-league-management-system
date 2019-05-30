package common;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
/**
 * @author:Narcissus
 * @date:2018.12.27 
 * @Description:�������ڽ��Ի��������ʾ��ʹ����ֻҪ�ڴ����Ի���ʱ�̳и��࣬
 * ������������Ի����С֮�����super.center();�������ɡ�
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
