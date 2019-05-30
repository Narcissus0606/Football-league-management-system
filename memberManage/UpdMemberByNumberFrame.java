package memberManage;


import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import common.DateChooserJButton;
import common.JDBCAdapter;
import common.NumberText;
import common.TeamComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UpdMemberByNumberFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton okBtn;
	private JButton backBtn;
	private JButton birthDateBtn;
	private JLabel jLabel13;
	private JTextField weightTxt;
	private JLabel jLabel12;
	private JTextField heightTxt;
	private JLabel jLabel11;
	private JComboBox positionCombo;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JTextField numberTxt;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JComboBox teamNameCombo;
	private JLabel jLabel6;
	private JTextField memberNameTxt;
	private JSeparator jSeparator1;
	private JTextField oldNumberTxt;
	private JComboBox oldTeamNameCombo;

	public UpdMemberByNumberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u6839\u636e\u961f\u540d\u548c\u53f7\u7801\u4fee\u6539\u7403\u5458\u4fe1\u606f");
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("\u9009\u62e9\u6240\u5728\u7403\u961f\uff0c\u5e76\u8f93\u5165\u7403\u8863\u53f7\u7801\uff0c\u5176\u4ed6\u4fe1\u606f\u81ea\u52a8\u51fa\u73b0");
					jLabel1.setForeground(new java.awt.Color(255,0,0));
					jLabel1.setPreferredSize(new java.awt.Dimension(303, 17));
					jLabel1.setBounds(41, 12, 303, 17);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("\u6240\u5728\u7403\u961f");
					jLabel2.setPreferredSize(new java.awt.Dimension(62, 17));
					jLabel2.setBounds(24, 46, 62, 17);
				}
				{
					
					oldTeamNameCombo = new TeamComboBox(jdbc);
					getContentPane().add(oldTeamNameCombo);

					oldTeamNameCombo.setPreferredSize(new java.awt.Dimension(123, 24));
					oldTeamNameCombo.setBounds(80, 42, 123, 24);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("\u7403\u8863\u53f7\u7801");
					jLabel3.setPreferredSize(new java.awt.Dimension(62, 17));
					jLabel3.setBounds(215, 46, 62, 17);
				}
				{
					oldNumberTxt = new JTextField();
					getContentPane().add(oldNumberTxt);
					oldNumberTxt.setPreferredSize(new java.awt.Dimension(67, 24));
					oldNumberTxt.setBounds(277, 43, 67, 24);
					oldNumberTxt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							getMemberInfoByName();
						}
					});
				}
				{
					jSeparator1 = new JSeparator();
					getContentPane().add(jSeparator1);
					jSeparator1.setPreferredSize(new java.awt.Dimension(366, 10));
					jSeparator1.setBounds(6, 75, 366, 10);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("\u7403\u5458\u59d3\u540d");
					jLabel4.setPreferredSize(new java.awt.Dimension(56, 17));
					jLabel4.setBounds(24, 91, 56, 17);
				}
				{
					memberNameTxt = new JTextField();
					getContentPane().add(memberNameTxt);
					memberNameTxt.setPreferredSize(new java.awt.Dimension(264, 24));
					memberNameTxt.setBounds(80, 88, 264, 24);
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("*");
					jLabel5.setForeground(new java.awt.Color(255,0,0));
					jLabel5.setPreferredSize(new java.awt.Dimension(9, 17));
					jLabel5.setBounds(349, 91, 9, 17);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("\u6240\u5728\u7403\u961f");
					jLabel6.setPreferredSize(new java.awt.Dimension(56, 17));
					jLabel6.setBounds(24, 127, 56, 17);
				}
				{
					
					teamNameCombo = new TeamComboBox(jdbc);
					getContentPane().add(teamNameCombo);

					teamNameCombo.setPreferredSize(new java.awt.Dimension(264, 24));
					teamNameCombo.setBounds(80, 123, 264, 24);
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("*");
					jLabel7.setForeground(new java.awt.Color(255,0,0));
					jLabel7.setPreferredSize(new java.awt.Dimension(10, 17));
					jLabel7.setBounds(350, 127, 10, 17);
				}
				{
					jLabel8 = new JLabel();
					getContentPane().add(jLabel8);
					jLabel8.setText("\u7403\u8863\u53f7\u7801");
					jLabel8.setPreferredSize(new java.awt.Dimension(56, 17));
					jLabel8.setBounds(24, 156, 56, 17);
				}
				{
					numberTxt = new NumberText();
					getContentPane().add(numberTxt);
					numberTxt.setPreferredSize(new java.awt.Dimension(264, 24));
					numberTxt.setBounds(80, 153, 264, 24);
				}
				{
					jLabel9 = new JLabel();
					getContentPane().add(jLabel9);
					jLabel9.setText("*");
					jLabel9.setForeground(new java.awt.Color(255,0,0));
					jLabel9.setPreferredSize(new java.awt.Dimension(10, 17));
					jLabel9.setBounds(350, 156, 10, 17);
				}
				{
					jLabel10 = new JLabel();
					getContentPane().add(jLabel10);
					jLabel10.setText("\u573a\u4e0a\u4f4d\u7f6e");
					jLabel10.setPreferredSize(new java.awt.Dimension(56, 17));
					jLabel10.setBounds(24, 192, 56, 17);
				}
				{
					ComboBoxModel positionComboModel = 
						new DefaultComboBoxModel(
								new String[] { "守门员", "前锋","中场","后卫" });
					positionCombo = new JComboBox();
					getContentPane().add(positionCombo);
					positionCombo.setModel(positionComboModel);
					positionCombo.setPreferredSize(new java.awt.Dimension(264, 24));
					positionCombo.setBounds(80, 188, 264, 24);
				}
				{
					jLabel11 = new JLabel();
					getContentPane().add(jLabel11);
					jLabel11.setText("\u8eab\u9ad8");
					jLabel11.setPreferredSize(new java.awt.Dimension(37, 17));
					jLabel11.setBounds(24, 230, 37, 17);
				}
				{
					heightTxt = new JTextField();
					getContentPane().add(heightTxt);
					heightTxt.setPreferredSize(new java.awt.Dimension(89, 24));
					heightTxt.setBounds(79, 227, 89, 24);
				}
				{
					jLabel12 = new JLabel();
					getContentPane().add(jLabel12);
					jLabel12.setText("\u4f53\u91cd");
					jLabel12.setPreferredSize(new java.awt.Dimension(34, 17));
					jLabel12.setBounds(203, 230, 34, 17);
				}
				{
					weightTxt = new JTextField();
					getContentPane().add(weightTxt);
					weightTxt.setPreferredSize(new java.awt.Dimension(95, 24));
					weightTxt.setBounds(249, 227, 95, 24);
				}
				{
					jLabel13 = new JLabel();
					getContentPane().add(jLabel13);
					jLabel13.setText("\u51fa\u751f\u65e5\u671f");
					jLabel13.setPreferredSize(new java.awt.Dimension(55, 17));
					jLabel13.setBounds(24, 265, 55, 17);
				}
				{
					birthDateBtn = new DateChooserJButton();
					getContentPane().add(birthDateBtn);
					birthDateBtn.setPreferredSize(new java.awt.Dimension(265, 25));
					birthDateBtn.setBounds(79, 262, 265, 25);
				}
				{
					okBtn = new JButton();
					getContentPane().add(okBtn);
					okBtn.setText("\u786e\u5b9a");
					okBtn.setPreferredSize(new java.awt.Dimension(77, 24));
					okBtn.setBounds(79, 312, 77, 24);
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
					backBtn.setPreferredSize(new java.awt.Dimension(80, 24));
					backBtn.setBounds(203, 312, 80, 24);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							backBtnActionPerformed();
						}
					});
				}
			}
			this.setSize(400, 400);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void getMemberInfoByName() {
		String oldnumber = oldNumberTxt.getText();
		String oldteamname =oldTeamNameCombo.getSelectedItem().toString(); 
		if(oldnumber == null || oldnumber.equals("")){
			JOptionPane.showMessageDialog(this, "球衣号码必须填写！");
			oldNumberTxt.setFocusable(true);
			return;
		}if(oldnumber.length()>10){
			JOptionPane.showMessageDialog(this, "球衣号码不能超过10个字，请重新输入!");
			oldNumberTxt.setFocusable(true);
			return;
		}
		Vector members;
		Vector oneMember;
		String sql = "select * from member where teamname ='"+oldteamname+"'and number ='"+oldnumber+"'";
		members = jdbc.query(sql);
		if(members.size() == 0){
			JOptionPane.showMessageDialog(this, "没有对应的球员！请重新输入或返回。");
			oldNumberTxt.setText(null);
			oldTeamNameCombo.setSelectedItem(null);
			
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
	private void update(String name,String teamname,String oldteam,String number,String oldnumber,String position,String height,String weight,String birthdate){
		if(! oldNumberTxt.getText().equals(numberTxt.getText())){
			String selecting = "select * from member where teamname = '"+teamname+"'and number ='"+number+"'";
			Vector exist = jdbc.query(selecting);
			if(exist.size()>0){
				JOptionPane.showMessageDialog(this, "该球员已存在，请重新填写");
				return;
			}
		}
		String sql = "update member set name ='"+name+"',teamname ='"+teamname+"',number ='"+number+"'" +
				",position ='"+position+"',height='" +height+"',weight ='"+weight+"',birthdate ='"+birthdate+"'" +
		" where number ='"+oldNumberTxt.getText()+"'and teamname='"+oldTeamNameCombo.getSelectedItem().toString()+"'";
	
		try{
			jdbc.update(sql);
//System.out.println(sql);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}			
	}
//ok
	protected void okBtnActionPerformed(ActionEvent evt) {
		String name = memberNameTxt.getText();
		String oldteam = oldTeamNameCombo.getSelectedItem().toString();
		String teamname = teamNameCombo.getSelectedItem().toString();
		String oldnumber = oldNumberTxt.getText();
		String number = numberTxt.getText();
		String position = positionCombo.getSelectedItem().toString();
		String height = heightTxt.getText();
		String weight = weightTxt.getText();
		String birthdate = birthDateBtn.getText();
		
		if(number == null || number.equals("")){
			JOptionPane.showMessageDialog(this,"球衣号码必须填写！");
			numberTxt.setFocusable(true);
		}
		if(JOptionPane.showConfirmDialog(this,"确定要修改这个球员信息吗？","询问",JOptionPane.YES_NO_OPTION)==
		JOptionPane.YES_OPTION)
			update(name,teamname,oldteam,number,oldnumber,position,height,weight,birthdate);	
		
	}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new UpdMemberByNumberFrame(Boolean.FALSE);
	}

	public UpdMemberByNumberFrame(Boolean initGUI) {
		super();
	}

}
