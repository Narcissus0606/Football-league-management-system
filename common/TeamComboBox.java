package common;

import java.util.Vector;

import javax.swing.JComboBox;

/**
 * @author:张冬青
 * @version:1.0
 * @date:2008-9-19
 * @copyright:(C) 2008
 * @company:NEUSOFT
 * @Title:球队名称下拉列表框
 * @Description:该控件是球队名称下拉列表框，只能用于该项目，并且需要引用JDBCAdapter类
 * 使用方法：在需要的地方声明并初始化，即可直接使用，并且可以进一步设置其他属性，如editable
 */
public class TeamComboBox extends JComboBox {
	
	public TeamComboBox(JDBCAdapter jdbc){
		Vector teamNames = jdbc.query("select name from team");

		for(Object oneTeam:teamNames){
	          this.addItem(((Vector)oneTeam).elementAt(0));		
		}
	}
}
