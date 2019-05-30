package teamManage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import common.JDBCAdapter;


public class TeamFrame extends common.CenterDialog {


	JDBCAdapter jdbc;
	private JButton addTeamBtn;
	private JButton updTeamBtn;
	private JButton delTeamBtn;
	private JButton backTeamBtn;
	private JButton dispTeamBtn;
	
	AddTeamFrame atf;
	UpdTeamFrame utf;
	DelTeamFrame dtf;
	DispTeamFrame stf;

	public TeamFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u7403\u961f\u7ba1\u7406");
			{
				addTeamBtn = new JButton();
				getContentPane().add(addTeamBtn);
				addTeamBtn.setText("\u6dfb\u52a0\u7403\u961f");
				addTeamBtn.setBounds(132, 12, 92, 37);
				addTeamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						atf = new AddTeamFrame(jdbc);
						atf.setVisible(true);
					}
				});
			}
			{
				updTeamBtn = new JButton();
				getContentPane().add(updTeamBtn);
				updTeamBtn.setText("\u4fee\u6539\u7403\u961f");
				updTeamBtn.setBounds(132, 60, 92, 37);
				updTeamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						utf = new UpdTeamFrame(jdbc);
						utf.setVisible(true);
					}
				});
			}
			{
				delTeamBtn = new JButton();
				getContentPane().add(delTeamBtn);
				delTeamBtn.setText("\u5220\u9664\u7403\u961f");
				delTeamBtn.setBounds(132, 108, 92, 36);
				delTeamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dtf = new DelTeamFrame(jdbc);
						dtf.setVisible(true);
					}
				});
			}
			{
				dispTeamBtn = new JButton();
				getContentPane().add(dispTeamBtn);
				dispTeamBtn.setText("\u663e\u793a\u7403\u961f");
				dispTeamBtn.setBounds(132, 155, 92, 37);
				dispTeamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						stf = new DispTeamFrame(jdbc);
						stf.setVisible(true);
					}
				});
			}
			{
				backTeamBtn = new JButton();
				getContentPane().add(backTeamBtn);
				backTeamBtn.setText("\u8fd4\u56de");
				backTeamBtn.setBounds(132, 203, 92, 34);
				backTeamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed(evt);
					}
				});
			}
			this.setSize(400, 302);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void backBtnActionPerformed(ActionEvent evt) {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new TeamFrame(Boolean.FALSE);
	}
	

	public TeamFrame(Boolean initGUI) {
		super();
	}
}
