package memberManage;

import common.DateChooserJButton;
import common.JDBCAdapter;
import common.NumberText;
import common.TeamComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddMemberFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JTextField memberNameTxt;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton birthDateBtn;
	private JButton okBtn;
	private JButton backBtn;
	private JLabel jLabel10;
	private JTextField weightTxt;
	private JLabel jLabel9;
	private JTextField heightTxt;
	private JTextField numberTxt;
	private JLabel jLabel8;
	private JComboBox positionCombo;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JComboBox teamNameCombo;

	public AddMemberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u6dfb\u52a0\u7403\u5458");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7403\u5458\u59d3\u540d");
				jLabel1.setBounds(25, 24, 84, 17);
			}
			{
				memberNameTxt = new JTextField();
				getContentPane().add(memberNameTxt);
				memberNameTxt.setBounds(99, 21, 207, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("*");
				jLabel2.setBounds(318, 24, 10, 17);
				jLabel2.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6240\u5728\u7403\u961f");
				jLabel3.setBounds(25, 61, 68, 17);
			}
			{
				
				teamNameCombo = new TeamComboBox(jdbc);
				getContentPane().add(teamNameCombo);
				teamNameCombo.setBounds(99, 57, 207, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("*");
				jLabel4.setBounds(318, 65, 10, 17);
				jLabel4.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u7403\u8863\u53f7\u7801");
				jLabel5.setBounds(25, 90, 68, 17);
			}
			{
				numberTxt = new NumberText();
				getContentPane().add(numberTxt);
				numberTxt.setBounds(99, 87, 207, 24);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("*");
				jLabel6.setBounds(318, 94, 16, 17);
				jLabel6.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u573a\u4e0a\u4f4d\u7f6e");
				jLabel7.setBounds(25, 121, 68, 17);
			}
			{
				ComboBoxModel positionComboModel = 
					new DefaultComboBoxModel(
							new String[] { "守门员", "前锋","中场","后卫" });
				positionCombo = new JComboBox();
				getContentPane().add(positionCombo);
				positionCombo.setModel(positionComboModel);
				positionCombo.setBounds(99, 117, 207, 24);	
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("\u8eab\u9ad8");
				jLabel8.setBounds(25, 157, 43, 17);
			}
			{
				heightTxt = new JTextField();
				getContentPane().add(heightTxt);
				heightTxt.setBounds(99, 154, 73, 24);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("\u4f53\u91cd");
				jLabel9.setBounds(190, 157, 48, 17);
			}
			{
				weightTxt = new JTextField();
				getContentPane().add(weightTxt);
				weightTxt.setBounds(232, 154, 72, 24);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("\u51fa\u751f\u65e5\u671f");
				jLabel10.setBounds(25, 186, 68, 17);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(93, 218, 64, 24);
				okBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						OKBtnActionPerformed(evt);
					}
				});
			}
			{
				backBtn = new JButton();
				getContentPane().add(backBtn);
				backBtn.setText("\u8fd4\u56de");
				backBtn.setBounds(202, 218, 71, 24);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed();
					}
				});
			}
			{
				birthDateBtn = new DateChooserJButton();
				getContentPane().add(birthDateBtn);
				birthDateBtn.setBounds(99, 183, 205, 23);
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//插入处理
	protected void insert(String name,String teamname,String number,String position,String height,String weight,String birthdate) {
		String selecting="select name from member where name='"+name+"'";
		Vector exist=jdbc.query(selecting);
		if(exist.size()>0){
			JOptionPane.showMessageDialog(this,"该号码已经存在，请重新填写！");
			return;
		}
		String sql="insert into member"+"(name,teamname,number,position,height,weight,birthdate) values('"+name+"','"+teamname+"','"+number+"','"+position+"','"+height+"','"+weight+"','"+birthdate+"')";
		System.out.println(sql);
		try{
			jdbc.insert(sql);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	protected void OKBtnActionPerformed(ActionEvent evt) {
		String name=memberNameTxt.getText();
		String number = numberTxt.getText();
		String teamname = teamNameCombo.getSelectedItem().toString();
		String position = positionCombo.getSelectedItem().toString();
		String height=heightTxt.getText();
		String weight=weightTxt.getText();
		String birthdate = birthDateBtn.getText();
		
		if(name==null||name.equals("")){
			
			JOptionPane.showMessageDialog(this,"球员名称必须填写！");
			memberNameTxt.setFocusable(true);
			return;
		}
		if(name!=null&&name.length()>10){
			JOptionPane.showMessageDialog(this, "球员名称不能超过10个字，请重新输入！");
			memberNameTxt.setFocusable(true);
			return;
		}
		if(numberTxt.getText() == null ||numberTxt.getText().equals("")){
			JOptionPane.showMessageDialog(this, "球衣号码必须填写！");
			numberTxt.setFocusable(true);
			return;
		}
		insert(name,teamname,number,position,height,weight,birthdate);
		memberNameTxt.setText(null);
		
		teamNameCombo.setSelectedItem(null);
		numberTxt.setText(null);
		positionCombo.setSelectedItem(null);
		heightTxt.setText(null);
		weightTxt.setText(null);

		
	}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new AddMemberFrame(Boolean.FALSE);
	}
	

	public AddMemberFrame(Boolean initGUI) {
		super();
	}

}
