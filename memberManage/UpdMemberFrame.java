package memberManage;

import common.DateChooserJButton;
import common.JDBCAdapter;
import common.NumberText;
import common.TeamComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class UpdMemberFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField memberOldNameTxt;
	private JButton okBtn;
	private JButton backBtn;
	private JButton birthDateBtn;
	private JLabel jLabel12;
	private JTextField weightTxt;
	private JLabel jLabel11;
	private JTextField heightTxt;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JComboBox positionCombo;
	private JTextField numberTxt;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JComboBox teamNameCombo;
	private JTextField memberNameTxt;
	private JSeparator jSeparator1;

	public UpdMemberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u6839\u636e\u59d3\u540d\u4fee\u6539\u7403\u5458\u4fe1\u606f");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8f93\u5165\u7403\u5458\u59d3\u540d\u540e\uff0c\u5176\u4ed6\u4fe1\u606f\u81ea\u52a8\u51fa\u73b0");
				jLabel1.setBounds(88, 12, 243, 17);
				jLabel1.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u7403\u5458\u59d3\u540d");
				jLabel2.setBounds(33, 41, 66, 17);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-6, 74, 390, 10);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u7403\u5458\u59d3\u540d");
				jLabel3.setBounds(33, 84, 55, 17);
			}
			{
				memberNameTxt = new JTextField();
				getContentPane().add(memberNameTxt);
				memberNameTxt.setBounds(106, 83, 216, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("*");
				jLabel4.setBounds(332, 86, 10, 17);
				jLabel4.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6240\u5728\u7403\u961f");
				jLabel5.setBounds(33, 117, 55, 17);
			}
			{
				
				teamNameCombo = new TeamComboBox(jdbc);
				getContentPane().add(teamNameCombo);
			
				teamNameCombo.setBounds(106, 113, 216, 24);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7403\u8863\u53f7\u7801");
				jLabel6.setBounds(33, 153, 55, 17);
			}
			{
				numberTxt = new NumberText();
				getContentPane().add(numberTxt);
				numberTxt.setBounds(106, 150, 216, 24);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u573a\u4e0a\u4f4d\u7f6e");
				jLabel7.setBounds(33, 191, 55, 17);
			}
			{
				ComboBoxModel positionComboModel = 
					new DefaultComboBoxModel(
							new String[] { "守门员", "前锋","中场","后卫" });
				positionCombo = new JComboBox();
				getContentPane().add(positionCombo);
				positionCombo.setModel(positionComboModel);
				positionCombo.setBounds(106, 184, 216, 24);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("*");
				jLabel8.setBounds(334, 117, 10, 17);
				jLabel8.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("*");
				jLabel9.setBounds(334, 153, 10, 17);
				jLabel9.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("\u8eab\u9ad8");
				jLabel10.setBounds(33, 227, 46, 17);
			}
			{
				heightTxt = new JTextField();
				getContentPane().add(heightTxt);
				heightTxt.setBounds(106, 224, 67, 24);
			}
			{
				jLabel11 = new JLabel();
				getContentPane().add(jLabel11);
				jLabel11.setText("\u4f53\u91cd");
				jLabel11.setBounds(202, 226, 38, 17);
			}
			{
				weightTxt = new JTextField();
				getContentPane().add(weightTxt);
				weightTxt.setBounds(252, 223, 70, 24);
			}
			{
				jLabel12 = new JLabel();
				getContentPane().add(jLabel12);
				jLabel12.setText("\u51fa\u751f\u65e5\u671f");
				jLabel12.setBounds(33, 266, 59, 17);
			}
			{
				birthDateBtn = new DateChooserJButton();
				getContentPane().add(birthDateBtn);
				birthDateBtn.setBounds(104, 265, 211, 24);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(92, 307, 79, 24);
				okBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okBtnActionPerformed(evt);
					}
				});
			}
			{
				backBtn = new JButton();
				getContentPane().add(backBtn);
				backBtn.setText("\u8fd4\u56de");
				backBtn.setBounds(219, 307, 84, 24);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed();
					}
				});
			}
			{
				memberOldNameTxt = new JTextField();
				getContentPane().add(memberOldNameTxt);
				memberOldNameTxt.setBounds(106, 38, 216, 24);
				memberOldNameTxt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getMemberInfoByName();
					}
				});

			}
			this.setSize(400, 400);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void getMemberInfoByName() {
		String name = memberOldNameTxt.getText();
		if(name == null || name.equals("")){
			JOptionPane.showMessageDialog(this, "球员名字必须填写！");
			memberOldNameTxt.setFocusable(true);
			return;
		}if(name.length()>10){
			JOptionPane.showMessageDialog(this, "球员名字不能超过10个字，请重新输入!");
			memberOldNameTxt.setFocusable(true);
			return;
		}
		Vector members;
		Vector oneMember;
		String sql = "select * from member where name ='"+name+"'";
		members = jdbc.query(sql);
		if(members.size() == 0){
			JOptionPane.showMessageDialog(this, "没有对应的球员！请重新输入或返回。");
			memberOldNameTxt.setText(null);
			memberOldNameTxt.setFocusable(true);
		}else{
			oneMember = (Vector)members.elementAt(0);
			memberNameTxt.setText((String)oneMember.elementAt(0));
			teamNameCombo.setSelectedItem((String)oneMember.elementAt(1));
			numberTxt.setText(oneMember.elementAt(2).toString());
			positionCombo.setSelectedItem((String)oneMember.elementAt(3));
			heightTxt.setText(oneMember.elementAt(4).toString());
			weightTxt.setText(oneMember.elementAt(5).toString());
			birthDateBtn.setText(oneMember.elementAt(6).toString());
		}
		
	}

	//update
	private void update(String name,String newName,String teamname,String number,String position,String height,String weight,String birthdate){
		if(! memberOldNameTxt.getText().equals(memberNameTxt.getText())){
			String selecting = "select * from member where name = '"+newName+"'";
			Vector exist = jdbc.query(selecting);
			if(exist.size()>0){
				JOptionPane.showMessageDialog(this, "该球员已存在，请重新填写");
				return;
			}
		}
		String sql = "update member set name ='"+newName+"',teamname ='"+teamname+"',number ='"+number+"'" +
				",position ='"+position+"',height='" +height+"',weight ='"+weight+"',birthdate ='"+birthdate+"' where name ='"+name+"'";
		try{
			jdbc.update(sql);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
			
	}
	//ok
	private void okBtnActionPerformed(ActionEvent evt){
		String newName = memberNameTxt.getText();
		String name = memberOldNameTxt.getText();
		String teamname = teamNameCombo.getSelectedItem().toString();
		String number = numberTxt.getText();
		String position = positionCombo.getSelectedItem().toString();
		String height = heightTxt.getText();
		String weight = weightTxt.getText();
		String birthdate = birthDateBtn.getText();
		
		if(name == null || name.equals("")){
			JOptionPane.showMessageDialog(this,"球员名字必须填写！");
			memberNameTxt.setFocusable(true);
		}
		if(name.length()>10){
			JOptionPane.showMessageDialog(this, "名字不能超过10个字，请重新输入！");
			memberNameTxt.setFocusable(true);
			return;
		}
		if(JOptionPane.showConfirmDialog(this,"确定要修改这个球员信息吗？","询问",JOptionPane.YES_NO_OPTION)==
		JOptionPane.YES_OPTION)
			update(name,newName, teamname,number,position,height,weight,birthdate);	
		}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new UpdMemberFrame(Boolean.FALSE);
	}
	
	public UpdMemberFrame(Boolean initGUI) {
		super();
	}

}
