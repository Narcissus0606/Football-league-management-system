package teamManage;


import javax.swing.JLabel;
import javax.swing.JTextField;

import common.JDBCAdapter;
import common.TeamComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UpdTeamFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JComboBox teamNameCombo;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton okBtn;
	private JLabel jLabel5;
	private JTextField homeTxt;
	private JLabel jLabel3;
	private JTextField teamNameTxt;
	private JButton backBtn;
	private JTextField coachTxt;

	public UpdTeamFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u53d8\u66f4\u7403\u961f");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5728\u4e0b\u62c9\u6846\u4e2d\u9009\u62e9\u7403\u961f\u540d\u79f0\u540e\uff0c\u5176\u4ed6\u4fe1\u606f\u81ea\u52a8\u51fa\u73b0");
				jLabel1.setBounds(49, 6, 323, 36);
				jLabel1.setForeground(new java.awt.Color(255,0,0));
			}
			{
				teamNameCombo = new TeamComboBox(jdbc);
				
				getContentPane().add(teamNameCombo);
				
				teamNameCombo.setBounds(143, 54, 139, 24);
				teamNameCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getTeamInfoByTeamName();
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u7403\u961f\u540d\u79f0\uff1a");
				jLabel2.setBounds(44, 58, 72, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u4e3b\u6559\u7ec3 \uff1a");
				jLabel4.setBounds(44, 166, 72, 17);
			}
			{
				coachTxt = new JTextField();
				getContentPane().add(coachTxt);
				coachTxt.setBounds(143, 163, 139, 24);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(74, 210, 69, 29);
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
				backBtn.setBounds(194, 210, 72, 29);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActonPerformed(jdbc);
						
					}
				});
			}
			{
				teamNameTxt = new JTextField();
				getContentPane().add(teamNameTxt);
				teamNameTxt.setBounds(143, 87, 139, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u7403\u961f\u540d\u79f0\uff1a");
				jLabel3.setBounds(44, 90, 67, 17);
			}
			{
				homeTxt = new JTextField();
				getContentPane().add(homeTxt);
				homeTxt.setBounds(143, 125, 139, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u7403\u961f\u4e3b\u573a\uff1a");
				jLabel5.setBounds(44, 128, 67, 17);
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//修改信息
	private int update(String oldName,String newName,String home,String coach){
		if(!oldName.equals(newName)){
			String selecting = "select name from team where name ='" +newName +"'";
			Vector exist = jdbc.query(selecting);
			if(exist.size()>0){
				JOptionPane.showMessageDialog(this, "该球队已经存在，请重新填写！");
				return 0;
			}
		}String sql = "update team set name ='" +newName +"',home ='"+home+"',coach ='"+coach+"' where name ='"+oldName+"'";
			try{
				jdbc.update(sql);
			}catch(Exception  ex){
				JOptionPane.showMessageDialog(this, ex.getMessage());
				return 0;
			}return 1;
		}
	
	//确定按钮事件
	protected void okBtnActionPerformed(ActionEvent evt) {
		String oldName = teamNameCombo.getSelectedItem().toString();
		String newName = teamNameTxt.getText();
		String home = homeTxt.getText();
		String coach = coachTxt.getText();
		if(newName == null || newName.equals("")){
			JOptionPane.showMessageDialog(this, "球队名称必须填写！");
			teamNameTxt.setFocusable(true);
		}
		if(newName.length()>10){
			JOptionPane.showMessageDialog(this, "球队名称不能超过10个字，请重新输入！");
			teamNameTxt.setFocusable(true);
			return;
		}
		if(home.length()>15){
			JOptionPane.showMessageDialog(this, "球队主场不能超过15个字，请重新输入！");
			homeTxt.setFocusable(true);
			return;
		}
		if(coach.length()>10){
			JOptionPane.showMessageDialog(this, "主教练的名字不能超过10个字，请重新输入！");
			coachTxt.setFocusable(true);
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "确实要修改这支球队信息吗？",
				"询问",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			update(oldName,newName,home,coach);
		teamNameTxt.setText(null);
		homeTxt.setText(null);
		coachTxt.setText(null);
	}
	//从下拉菜单取出球队信息
	protected void getTeamInfoByTeamName() {
		
		String oldName = teamNameCombo.getSelectedItem().toString();
		Vector teams;
		Vector oneTeam;
		String sql = "select * from team where name = '"+oldName+"'";
		teams = jdbc.query(sql);//得到所有队信息
		oneTeam = (Vector)teams.elementAt(0);//取一支球队信息
		teamNameTxt.setText((String)oneTeam.elementAt(0));
		homeTxt.setText((String)oneTeam.elementAt(1));
		coachTxt.setText((String)oneTeam.elementAt(2));	
	}
	
	//返回按钮事件
	protected void backBtnActonPerformed(JDBCAdapter jdbc2) {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new UpdTeamFrame(Boolean.FALSE);
	}
	
	public UpdTeamFrame(Boolean initGUI) {
		super();
	}

}
