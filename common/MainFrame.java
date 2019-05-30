package common;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculate.CalculateFrame;

import matchManage.MatchFrame;
import memberManage.MemberFrame;

import teamManage.TeamFrame;



public class MainFrame extends common.CenterDialog {
		JDBCAdapter jdbc;
		private JButton teamBtn;
		private JButton quitBtn;
		private JButton calBtn;
		private JButton matchBtn;
		private JButton memberBtn;
		
		TeamFrame tf;
		MemberFrame mf;
		MatchFrame af;
		CalculateFrame cf;
		
		public MainFrame(JDBCAdapter jdbc) {
			this.jdbc=jdbc;
			initGUI();
		}
	
	private void initGUI() {
		try {
			{
				this.setTitle("\u8db3\u7403\u8054\u8d5b\u7ba1\u7406\u7cfb\u7edf");
				getContentPane().setLayout(null);
			}
			{
				teamBtn = new JButton();
				getContentPane().add(teamBtn);
				teamBtn.setText("\u7403\u961f\u7ba1\u7406");
				teamBtn.setBounds(51, 49, 101, 37);
				teamBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

						tf = new TeamFrame(jdbc);
						tf.setVisible(true);
					}
				});
			}
			{
				memberBtn = new JButton();
				getContentPane().add(memberBtn);
				memberBtn.setText("\u7403\u5458\u7ba1\u7406");
				memberBtn.setBounds(221, 51, 104, 35);
				memberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						mf = new MemberFrame(jdbc);
						mf.setVisible(true);
					}
				});
			}
			{
				matchBtn = new JButton();
				getContentPane().add(matchBtn);
				matchBtn.setText("\u6bd4\u8d5b\u7ba1\u7406");
				matchBtn.setBounds(51, 135, 91, 35);
				matchBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						af = new MatchFrame(jdbc);
						af.setVisible(true);
					}
				});
			}
			{
				calBtn = new JButton();
				getContentPane().add(calBtn);
				calBtn.setText("\u7edf\u8ba1\u4fe1\u606f");
				calBtn.setBounds(226, 137, 99, 32);
				calBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cf = new CalculateFrame(jdbc);
						cf.setVisible(true);
					}
				});
			}
			{
				quitBtn = new JButton();
				getContentPane().add(quitBtn);
				quitBtn.setText("\u9000\u51fa");
				quitBtn.setBounds(142, 204, 79, 33);
				quitBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(jdbc != null)
						jdbc.close();						
						System.exit(0);						
					}
				});
			}
			setSize(400, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getGUIBuilderInstance() {
		return new MainFrame(Boolean.FALSE);
	}
	
	
	public MainFrame(Boolean initGUI) {
		super();
	}

}
