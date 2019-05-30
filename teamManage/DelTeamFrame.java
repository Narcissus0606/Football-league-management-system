package teamManage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import common.JDBCAdapter;
import common.TeamComboBox;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class DelTeamFrame extends common.CenterDialog {

	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton okBtn;
	private JButton backBtn;
	private JTextField coachTxt;
	private JTextField homeTxt;
	private JComboBox delTeamCombo;

	public DelTeamFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u5220\u9664\u7403\u961f");
			this.setUndecorated(false);
			this.setEnabled(true);
			this.setFocusTraversalKeysEnabled(false);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5728\u4e0b\u62c9\u83dc\u5355\u9009\u62e9\u7403\u961f\u540e\uff0c\u81ea\u52a8\u51fa\u73b0\u5176\u4ed6\u4fe1\u606f");
				jLabel1.setBounds(59, 19, 268, 17);
				jLabel1.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u7403\u961f\u540d\u79f0\uff1a");
				jLabel2.setBounds(62, 48, 80, 17);
			}
			{
				
				delTeamCombo = new TeamComboBox(jdbc);
				getContentPane().add(delTeamCombo);
				
				delTeamCombo.setBounds(154, 44, 129, 24);
				delTeamCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getTeamInfoByTeamName();
						
					}
				});
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u7403\u961f\u4e3b\u573a\uff1a");
				jLabel4.setBounds(59, 90, 74, 17);
			}
			{
				homeTxt = new JTextField();
				getContentPane().add(homeTxt);
				homeTxt.setBounds(151, 87, 129, 24);
				homeTxt.setFocusTraversalKeysEnabled(false);
				homeTxt.setEditable(false);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u4e3b\u6559\u7ec3\uff1a");
				jLabel5.setBounds(62, 132, 74, 17);
			}
			{
				coachTxt = new JTextField();
				getContentPane().add(coachTxt);
				coachTxt.setBounds(148, 129, 132, 24);
				coachTxt.setEditable(false);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(62, 198, 74, 28);
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
				backBtn.setBounds(188, 197, 81, 29);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed(jdbc);
					}
				});
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void okBtnActionPerformed(ActionEvent evt) {
		String name = delTeamCombo.getSelectedItem().toString();
		int i = getMembers(name);
		
		if(i>0){
			if(JOptionPane.showConfirmDialog(this, "这支球队有"+i+"名球员，" 
					+"如果删除将同时删掉这些球员，\r\n您确实要删除这支球队吗？","询问",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				delete(name);//具体删除球员的操作在后台由触发器实现
			}
			
		}else
			if(JOptionPane.showConfirmDialog(this, "确实要删除这支球队吗？","询问",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				delete(name);
		delTeamCombo.removeItem(name);
		homeTxt.setText(null);
		coachTxt.setText(null);
	
	}
	private void delete(String name){
		String sql = "delete from team where name ='"+name+"'";
		System.out.println(sql);
		try{
			jdbc.delete(sql);		
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	private int getMembers(String team){
		Vector members;
		String sql = "select name from member where teamname ='"+team+"'";
		members = jdbc.query(sql);
		return members.size();
	}


	protected void getTeamInfoByTeamName() {
		
		String teamName = delTeamCombo.getSelectedItem().toString();
		Vector teams;
		Vector oneTeam;
		String sql = "select * from team where name = '"+teamName+"'";
		teams = jdbc.query(sql);//得到所有队信息
		oneTeam = (Vector)teams.elementAt(0);//取一支球队信息
		homeTxt.setText((String)oneTeam.elementAt(1));
		coachTxt.setText((String)oneTeam.elementAt(2));	
	}

	protected void backBtnActionPerformed(JDBCAdapter jdbc2) {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new DelTeamFrame(Boolean.FALSE);
	}
	

	public DelTeamFrame(Boolean initGUI) {
		super();
	}

}
