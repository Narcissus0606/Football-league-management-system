package teamManage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.JDBCAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;


public class AddTeamFrame extends common.CenterDialog {

	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JTextField teamNameTxt;
	private JLabel jLabel4;
	private JButton backBtn;
	private JButton okBtn;
	private JTextField coachTxt;
	private JTextField homeTxt;
	private JLabel jLabel3;
	private JLabel jLabel2;

	public AddTeamFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u6dfb\u52a0\u7403\u961f");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7403\u961f\u540d\u79f0\uff1a");
				jLabel1.setBounds(28, 42, 93, 17);
			}
			{
				teamNameTxt = new JTextField();
				getContentPane().add(teamNameTxt);
				teamNameTxt.setBounds(133, 39, 183, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("*");
				jLabel2.setBounds(322, 42, 10, 17);
				jLabel2.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u7403\u961f\u4e3b\u573a\uff1a");
				jLabel3.setBounds(28, 88, 67, 17);
			}
			{
				homeTxt = new JTextField();
				getContentPane().add(homeTxt);
				homeTxt.setBounds(133, 85, 183, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u4e3b\u6559\u7ec3\uff1a");
				jLabel4.setBounds(28, 140, 76, 17);
			}
			{
				coachTxt = new JTextField();
				getContentPane().add(coachTxt);
				coachTxt.setBounds(133, 133, 183, 24);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(71, 204, 81, 28);
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
				backBtn.setBounds(209, 204, 83, 28);
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
	protected void insert(String name, String home, String coach) {
		String selecting="select name from team where name='"+name+"'";
		Vector exist=jdbc.query(selecting);
		if(exist.size()>0){
			JOptionPane.showMessageDialog(this,"该球队已经存在，请重新填写！");
			return;
		}
		String sql="insert into team"+"(name,home,coach) values('"+name+"','"+home+"','"+coach+"')";
		System.out.println(sql);
		try{
			jdbc.insert(sql);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void OKBtnActionPerformed(ActionEvent evt){
		String name=teamNameTxt.getText();
		String home=homeTxt.getText();
		String coach=coachTxt.getText();
		if(name==null||name.equals("")){
			
			JOptionPane.showMessageDialog(this,"球队名称必须填写！");
			teamNameTxt.setFocusable(true);
			return;
		}
		if(name!=null&&name.length()>10){
			JOptionPane.showMessageDialog(this, "球队名称不能超过10个字，请重新输入！");
			teamNameTxt.setFocusable(true);
			return;
		}
		if(home!=null&&home.length()>15){
			JOptionPane.showMessageDialog(this, "球队主场不能超过15个字，请重新输入！");
			homeTxt.setFocusable(true);
			return;
		}
		if(coach!=null&&coach.length()>10){
			JOptionPane.showMessageDialog(this, "主教练姓名不能超过10个字，请重新输入！");
			coachTxt.setFocusable(true);
			return;
		}
		insert(name,home,coach);
		teamNameTxt.setText(null);
		homeTxt.setText(null);
		coachTxt.setText(null);
		
	}protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}


	public static Object getGUIBuilderInstance() {
		return new AddTeamFrame(Boolean.FALSE);
	}
	
	
	public AddTeamFrame(Boolean initGUI) {
		super();
	}

}
