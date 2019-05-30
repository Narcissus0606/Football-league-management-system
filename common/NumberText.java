package common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**
 * @author:�Ŷ���
 * @version:1.0
 * @date:2008-9-19
 * @copyright:(C) 2008
 * @company:NEUSOFT
 * @Title:ֻ���������ֵ��ı���
 * @Description:�ÿؼ������������ı�����ֻ������0���������������˸�
 * ʹ�÷�����ֻҪ�����ɸ���Ķ��󲢳�ʼ����ֱ��ʹ�ü��ɡ�
 */
public class NumberText extends JTextField {
	
	class NumberKeyAdapter extends KeyAdapter{
		public void keyTyped(KeyEvent evt){
			char keyChar = evt.getKeyChar();
			if ((keyChar>='0' && keyChar<='9') || keyChar =='\b'){
				return;
			}
			evt.consume();
		}
	}
	
	public NumberText(){
		super();
		NumberKeyAdapter keyAdp = new NumberKeyAdapter();
		this.addKeyListener(keyAdp);
	}

}
