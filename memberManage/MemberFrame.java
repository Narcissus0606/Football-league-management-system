package memberManage;


import common.JDBCAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



public class MemberFrame extends common.CenterDialog {

	JDBCAdapter jdbc;
	private JButton addMemberBtn;
	private JButton updMemberByNumberBtn;
	private JButton delMemberByNamber;
	private JButton backBtn;
	private JButton dispMemberBtn;
	private JButton delMemberBtn;
	private JButton updMemberBtn;
	
	AddMemberFrame amf;
	UpdMemberFrame umf;
	UpdMemberByNumberFrame emf;
	DelMemberFrame dmf;
	DelMemberByNumberFrame nmf;
	DispMemberFrame smf;
	
	public MemberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u7403\u5458\u7ba1\u7406");
			}
			{
				addMemberBtn = new JButton();
				getContentPane().add(addMemberBtn);
				addMemberBtn.setText("\u6dfb\u52a0\u7403\u5458");
				addMemberBtn.setBounds(94, 5, 184, 30);
				addMemberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						amf = new AddMemberFrame(jdbc);
						amf.setVisible(true);
					}
				});
			}
			{
				updMemberBtn = new JButton();
				getContentPane().add(updMemberBtn);
				updMemberBtn.setText("\u6839\u636e\u59d3\u540d\u4fee\u6539\u7403\u5458");
				updMemberBtn.setBounds(94, 40, 184, 30);
				updMemberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						umf = new UpdMemberFrame(jdbc);
						umf.setVisible(true);
					}
				});
			}
			{
				updMemberByNumberBtn = new JButton();
				getContentPane().add(updMemberByNumberBtn);
				updMemberByNumberBtn.setText("\u6839\u636e\u7403\u961f\u548c\u53f7\u7801\u53d8\u66f4\u7403\u5458");
				updMemberByNumberBtn.setBounds(94, 75, 184, 30);
				updMemberByNumberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						emf = new UpdMemberByNumberFrame(jdbc);
						emf.setVisible(true);
					}
				});
			}
			{
				delMemberBtn = new JButton();
				getContentPane().add(delMemberBtn);
				delMemberBtn.setText("\u6309\u59d3\u540d\u5220\u9664\u7403\u5458");
				delMemberBtn.setBounds(94, 110, 184, 30);
				delMemberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dmf = new DelMemberFrame(jdbc);
						dmf.setVisible(true);
					}
				});
			}
			{
				delMemberByNamber = new JButton();
				getContentPane().add(delMemberByNamber);
				delMemberByNamber.setText("\u6309\u7403\u961f\u548c\u53f7\u7801\u5220\u9664\u7403\u5458");
				delMemberByNamber.setBounds(94, 145, 184, 30);
				delMemberByNamber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						nmf = new DelMemberByNumberFrame(jdbc);
						nmf.setVisible(true);
					}
				});
			}
			{
				dispMemberBtn = new JButton();
				getContentPane().add(dispMemberBtn);
				dispMemberBtn.setText("\u663e\u793a\u7403\u5458");
				dispMemberBtn.setBounds(94, 180, 184, 30);
				dispMemberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						smf = new DispMemberFrame(jdbc);
						smf.setVisible(true);
					}
				});
			}
			{
				backBtn = new JButton();
				getContentPane().add(backBtn);
				backBtn.setText("\u8fd4\u56de");
				backBtn.setBounds(94, 215, 184, 30);
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

	protected void backBtnActionPerformed(JDBCAdapter jdbc2) {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new MemberFrame(Boolean.FALSE);
	}
	
	
	public MemberFrame(Boolean initGUI) {
		super();
	}

}
