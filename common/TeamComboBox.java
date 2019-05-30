package common;

import java.util.Vector;

import javax.swing.JComboBox;

/**
 * @author:�Ŷ���
 * @version:1.0
 * @date:2008-9-19
 * @copyright:(C) 2008
 * @company:NEUSOFT
 * @Title:������������б��
 * @Description:�ÿؼ���������������б��ֻ�����ڸ���Ŀ��������Ҫ����JDBCAdapter��
 * ʹ�÷���������Ҫ�ĵط���������ʼ��������ֱ��ʹ�ã����ҿ��Խ�һ�������������ԣ���editable
 */
public class TeamComboBox extends JComboBox {
	
	public TeamComboBox(JDBCAdapter jdbc){
		Vector teamNames = jdbc.query("select name from team");

		for(Object oneTeam:teamNames){
	          this.addItem(((Vector)oneTeam).elementAt(0));		
		}
	}
}
