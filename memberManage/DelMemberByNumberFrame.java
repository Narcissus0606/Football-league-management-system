package memberManage;


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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DelMemberByNumberFrame extends common.CenterDialog {
	JDBCAdapter  jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField numberTxt;
	private JLabel jLabel5;
	private JButton okBtn;
	private JButton backBtn;
	private JButton birthDateBtn;
	private JLabel jLabel10;
	private JTextField weightTxt;
	private JLabel jLabel9;
	private JTextField heightTxt;
	private JLabel jLabel8;
	private JTextField positionTxt;
	private JLabel jLabel7;
	private JTextField memberNameTxt;
	private JLabel jLabel6;
	private JComboBox teamNameCombo;

	public DelMemberByNumberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u9009\u62e9\u6240\u5728\u7403\u961f\uff0c\u5e76\u8f93\u5165\u7403\u8863\u53f7\u7801\uff0c\u5176\u4ed6\u4fe1\u606f\u81ea\u52a8\u51fa\u73b0");
				jLabel1.setBounds(52, 17, 292, 17);
				jLabel1.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u6240\u5728\u7403\u961f");
				jLabel2.setBounds(35, 46, 57, 17);
			}
			{
				
				teamNameCombo = new TeamComboBox(jdbc);
				getContentPane().add(teamNameCombo);
				
				teamNameCombo.setBounds(104, 42, 219, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("*");
				jLabel3.setBounds(329, 46, 10, 17);
				jLabel3.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u7403\u8863\u53f7\u7801");
				jLabel4.setBounds(35, 75, 57, 17);
			}
			{
				numberTxt = new NumberText();
				getContentPane().add(numberTxt);
				numberTxt.setBounds(104, 72, 219, 24);
				numberTxt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getMemberInfoByNumber();
					}
				});
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("*");
				jLabel5.setBounds(329, 75, 10, 17);
				jLabel5.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7403\u5458\u59d3\u540d");
				jLabel6.setBounds(35, 104, 57, 17);
			}
			{
				memberNameTxt = new JTextField();
				getContentPane().add(memberNameTxt);
				memberNameTxt.setBounds(104, 101, 219, 24);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u573a\u4e0a\u4f4d\u7f6e");
				jLabel7.setBounds(35, 133, 57, 17);
			}
			{
				positionTxt = new JTextField();
				getContentPane().add(positionTxt);
				positionTxt.setBounds(104, 130, 219, 24);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("\u8eab\u9ad8");
				jLabel8.setBounds(35, 162, 37, 17);
			}
			{
				heightTxt = new JTextField();
				getContentPane().add(heightTxt);
				heightTxt.setBounds(104, 159, 68, 24);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("\u4f53\u91cd");
				jLabel9.setBounds(196, 162, 32, 17);
			}
			{
				weightTxt = new JTextField();
				getContentPane().add(weightTxt);
				weightTxt.setBounds(240, 159, 83, 24);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("\u51fa\u751f\u65e5\u671f");
				jLabel10.setBounds(35, 191, 57, 17);
			}
			{
				birthDateBtn = new DateChooserJButton();
				getContentPane().add(birthDateBtn);
				birthDateBtn.setBounds(104, 188, 214, 20);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(116, 219, 69, 24);
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
				backBtn.setBounds(228, 219, 80, 24);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed();
					}
				});
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	//getInfo
	private void getMemberInfoByNumber(){
		String number = numberTxt.getText(); 
		String teamname = teamNameCombo.getSelectedItem().toString();
		if(number == null ||number.equals("")){
			JOptionPane.showMessageDialog(this, "球衣号码必须填写！");
			numberTxt.setFocusable(true);
			return;
		}
		Vector members;
		Vector oneMember;
		String sql = "select * from member where teamname = '"+teamname+"'and number ='"+number+"'";
		members = jdbc.query(sql);//得到所有队员信息
		if(members.size() == 0){
			JOptionPane.showMessageDialog(this,"没有对应球员，请重新输入！");
			memberNameTxt.setFocusable(true);
			return;
		}
		oneMember = (Vector)members.elementAt(0);//取一个队员信息
		memberNameTxt.setText((String)oneMember.elementAt(0));
		teamNameCombo.setSelectedItem((String)oneMember.elementAt(1));
		numberTxt.setText(oneMember.elementAt(2).toString());
		positionTxt.setText((String)oneMember.elementAt(3));
		heightTxt.setText(oneMember.elementAt(4).toString());
		weightTxt.setText(oneMember.elementAt(5).toString());
		birthDateBtn.setText(oneMember.elementAt(6).toString());
	}
//	delete
	private void delete(String name,String teamname,String number,String position,String height,String weight,String birthdate) {
		String sql = "delete from member where teamname ='"+teamname+"'and number ='"+number+"'";
		System.out.println(sql);
		try{
			jdbc.delete(sql);		
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
	}
//ok
	protected void okBtnActionPerformed(ActionEvent evt) {
		String name = memberNameTxt.getText();
		String teamname = teamNameCombo.getSelectedItem().toString();
		String position = positionTxt.getText();
		String number = numberTxt.getText();
		String height = heightTxt.getText();
		String weight = weightTxt.getText();
		String birthdate = birthDateBtn.getText();
		
			if(JOptionPane.showConfirmDialog(this, "确实要删除这个球员吗？","询问",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				delete(name,teamname,number,position,height,weight,birthdate);
		memberNameTxt.setText(null);
		teamNameCombo.setSelectedItem(null);
		numberTxt.setText(null);
		positionTxt.setText(null);
		heightTxt.setText(null);
		weightTxt.setText(null);
		
	}


	public static Object getGUIBuilderInstance() {
		return new DelMemberByNumberFrame(Boolean.FALSE);
	}
	
	public DelMemberByNumberFrame(Boolean initGUI) {
		super();
	}

}
