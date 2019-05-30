package memberManage;

import common.DateChooserJButton;
import common.JDBCAdapter;
import common.NumberText;

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


public class DelMemberFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton okBtn;
	private JTextField memberNameTxt;
	private JButton backBtn;
	private JButton birthDateBtn;
	private JLabel jLabel9;
	private JTextField weightTxt;
	private JLabel jLabel8;
	private JLabel jLabel5;
	private JTextField numberTxt;
	private JTextField heightTxt;
	private JLabel jLabel7;
	private JTextField positionTxt;
	private JLabel jLabel6;
	private JTextField teamNameTxt;
	private JLabel jLabel4;
	private JLabel jLabel3;

	public DelMemberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u6839\u636e\u59d3\u540d\u5220\u9664\u7403\u5458");
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("\u8f93\u5165\u7403\u5458\u59d3\u540d\u540e\u5176\u4ed6\u4fe1\u606f\u81ea\u52a8\u51fa\u73b0");
					jLabel1.setForeground(new java.awt.Color(255,0,0));
					jLabel1.setPreferredSize(new java.awt.Dimension(212, 17));
					jLabel1.setBounds(67, 12, 212, 17);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("\u7403\u5458\u59d3\u540d");
					jLabel2.setPreferredSize(new java.awt.Dimension(66, 17));
					jLabel2.setBounds(39, 48, 66, 17);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("*");
					jLabel3.setForeground(new java.awt.Color(255,0,0));
					jLabel3.setPreferredSize(new java.awt.Dimension(10, 17));
					jLabel3.setBounds(332, 48, 10, 17);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("\u6240\u5728\u7403\u961f");
					jLabel4.setPreferredSize(new java.awt.Dimension(59, 17));
					jLabel4.setBounds(39, 77, 59, 17);
				}
				{
					teamNameTxt = new JTextField();
					getContentPane().add(teamNameTxt);
					teamNameTxt.setPreferredSize(new java.awt.Dimension(216, 24));
					teamNameTxt.setBounds(110, 74, 216, 24);
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("\u7403\u5458\u53f7\u7801");
					jLabel5.setPreferredSize(new java.awt.Dimension(59, 17));
					jLabel5.setBounds(39, 106, 59, 17);
				}
				{
					numberTxt = new JTextField();
					getContentPane().add(numberTxt);
					numberTxt.setPreferredSize(new java.awt.Dimension(216, 24));
					numberTxt.setBounds(110, 103, 216, 24);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("\u573a\u4e0a\u4f4d\u7f6e");
					jLabel6.setPreferredSize(new java.awt.Dimension(54, 17));
					jLabel6.setBounds(39, 135, 54, 17);
				}
				{
					positionTxt = new JTextField();
					getContentPane().add(positionTxt);
					positionTxt.setPreferredSize(new java.awt.Dimension(215, 24));
					positionTxt.setBounds(111, 132, 215, 24);
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("\u8eab\u9ad8");
					jLabel7.setPreferredSize(new java.awt.Dimension(38, 17));
					jLabel7.setBounds(39, 169, 38, 17);
				}
				{
					heightTxt = new JTextField();
					getContentPane().add(heightTxt);
					heightTxt.setPreferredSize(new java.awt.Dimension(65, 24));
					heightTxt.setBounds(111, 166, 65, 24);
				}
				{
					jLabel8 = new JLabel();
					getContentPane().add(jLabel8);
					jLabel8.setText("\u4f53\u91cd");
					jLabel8.setPreferredSize(new java.awt.Dimension(34, 17));
					jLabel8.setBounds(199, 169, 34, 17);
				}
				{
					weightTxt = new JTextField();
					getContentPane().add(weightTxt);
					weightTxt.setPreferredSize(new java.awt.Dimension(81, 24));
					weightTxt.setBounds(245, 166, 81, 24);
				}
				{
					jLabel9 = new JLabel();
					getContentPane().add(jLabel9);
					jLabel9.setText("\u51fa\u751f\u65e5\u671f");
					jLabel9.setPreferredSize(new java.awt.Dimension(54, 17));
					jLabel9.setBounds(39, 198, 54, 17);
				}
				{
					birthDateBtn = new DateChooserJButton();
					getContentPane().add(birthDateBtn);
					birthDateBtn.setPreferredSize(new java.awt.Dimension(215, 25));
					birthDateBtn.setBounds(111, 195, 215, 25);
				}
				{
					okBtn = new JButton();
					getContentPane().add(okBtn);
					okBtn.setText("\u786e\u5b9a");
					okBtn.setPreferredSize(new java.awt.Dimension(83, 24));
					okBtn.setBounds(98, 227, 83, 24);
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
					backBtn.setBounds(205, 227, 80, 24);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							backBtnActionPerformed();
						}
					});
				}
				{
					memberNameTxt = new JTextField();
					getContentPane().add(memberNameTxt);
					memberNameTxt.setBounds(110, 45, 216, 24);
					memberNameTxt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							getMemberInfoByName();
						}
					});
				}
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//删除信息
	private void delete(String name,String teamname,String number,String position,String height,String weight,String birthdate){
		String sql = "delete from member where name ='"+name+"'";
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
		String teamname = teamNameTxt.getText();
		String position = positionTxt.getText();
		String number = numberTxt.getText();
		String height = heightTxt.getText();
		String weight = weightTxt.getText();
		String birthdate = birthDateBtn.getText();
		
			if(JOptionPane.showConfirmDialog(this, "确实要删除这个球员吗？","询问",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				delete(name,teamname,number,position,height,weight,birthdate);
		memberNameTxt.setText(null);
		teamNameTxt.setText(null);
		numberTxt.setText(null);
		positionTxt.setText(null);
		heightTxt.setText(null);
		weightTxt.setText(null);
		
		
		
	}

	//获得球员信息
	protected void getMemberInfoByName(){
		String name = memberNameTxt.getText();
		if(name == null || name.equals("")){
			JOptionPane.showMessageDialog(this, "球员名称必须填写！");
			memberNameTxt.setFocusable(true);
			return;
		}
		Vector members;
		Vector oneMember;
		String sql = "select * from member where name = '"+name+"'";
		members = jdbc.query(sql);//得到所有队员信息
		if(members.size() == 0){
			JOptionPane.showMessageDialog(this,"没有对应球员，请重新输入！");
			memberNameTxt.setFocusable(true);
			return;
		}
		oneMember = (Vector)members.elementAt(0);//取一个队员信息
		teamNameTxt.setText((String)oneMember.elementAt(1));
		numberTxt.setText(oneMember.elementAt(2).toString());
		positionTxt.setText((String)oneMember.elementAt(3));
		heightTxt.setText(oneMember.elementAt(4).toString());
		weightTxt.setText(oneMember.elementAt(5).toString());
		birthDateBtn.setText(oneMember.elementAt(6).toString());
	}


	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new DelMemberFrame(Boolean.FALSE);
	}
	
	public DelMemberFrame(Boolean initGUI) {
		super();
	}

}
