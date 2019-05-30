package common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**
 * @author:张冬青
 * @version:1.0
 * @date:2008-9-19
 * @copyright:(C) 2008
 * @company:NEUSOFT
 * @Title:只能输入数字的文本框
 * @Description:该控件用于限制在文本框中只能输入0和正整数（可以退格）
 * 使用方法：只要声明成该类的对象并初始化，直接使用即可。
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
