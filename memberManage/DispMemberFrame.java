package memberManage;


import common.DBTableModel;
import common.DateChooserJButton;
import common.JDBCAdapter;
import common.TeamComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



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
public class DispMemberFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JTabbedPane jTabbedPane1;
	private JPanel ��������;
	private JPanel �������;
	private JPanel ����;
	private JButton okBtn;
	private JButton backBtn;
	private JLabel chkNumberLabel;
	private JLabel jLabel9;
	private JButton birthDateToBtn;
	private JLabel jLabel8;
	private JCheckBox nameLikeChk;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton birthDateFromBtn;
	private JLabel jLabel7;
	private JTextField weightToTxt;
	private JLabel jLabel6;
	private JTextField weightFromTxt;
	private JTextField heightToTxt;
	private JTextField heightFromTxt;
	private JLabel jLabel3;
	private JCheckBox teamLikeChk;
	private JComboBox teamNameCombo;
	private JLabel jLabel2;
	private JTable jTable;
	private JTextField nameTxt;
	private JLabel jLabel1;
	private JPanel ���;

	public DispMemberFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u663e\u793a\u7403\u5458");
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1);
				jTabbedPane1.setBounds(17, 7, 448, 89);
				{
					���� = new JPanel();
					jTabbedPane1.addTab("����", null, ����, null);
					����.setPreferredSize(new java.awt.Dimension(473, 349));
					����.setLayout(null);
					{
						jLabel1 = new JLabel();
						����.add(jLabel1);
						jLabel1.setText("\u59d3\u540d");
						jLabel1.setBounds(26, 19, 53, 17);
					}
					{
						nameTxt = new JTextField();
						����.add(nameTxt);
						nameTxt.setBounds(75, 16, 208, 24);
					}
					{
						nameLikeChk = new JCheckBox();
						����.add(nameLikeChk);
						nameLikeChk.setText("\u6a21\u7cca\u67e5\u8be2");
						nameLikeChk.setBounds(319, 17, 113, 21);
					}
				}
				{
					��� = new JPanel();
					jTabbedPane1.addTab("���", null, ���, null);
					���.setPreferredSize(new java.awt.Dimension(400, 46));
					���.setLayout(null);
					{
						jLabel2 = new JLabel();
						���.add(jLabel2);
						jLabel2.setText("\u7403\u961f\u540d\u79f0");
						jLabel2.setBounds(22, 12, 61, 17);
					}
					{
						
						teamNameCombo = new TeamComboBox(jdbc);
						���.add(teamNameCombo);
						
						teamNameCombo.setBounds(95, 8, 156, 24);
						teamNameCombo.setEditable(true);
					}
					{
						teamLikeChk = new JCheckBox();
						���.add(teamLikeChk);
						teamLikeChk.setText("\u6a21\u7cca\u67e5\u8be2");
						teamLikeChk.setBounds(287, 9, 102, 21);
					}
				}
				{
					������� = new JPanel();
					jTabbedPane1.addTab("�������", null, �������, null);
					�������.setPreferredSize(new java.awt.Dimension(443, 59));
					�������.setLayout(null);
					{
						jLabel3 = new JLabel();
						�������.add(jLabel3);
						jLabel3.setText("\u8eab\u9ad8\u4e0a\u9650");
						jLabel3.setBounds(41, 5, 71, 17);
					}
					{
						heightFromTxt = new JTextField();
						�������.add(heightFromTxt);
						heightFromTxt.setBounds(106, 2, 90, 24);
					}
					{
						jLabel4 = new JLabel();
						�������.add(jLabel4);
						jLabel4.setText("\u8eab\u9ad8\u4e0b\u9650");
						jLabel4.setBounds(39, 38, 67, 17);
					}
					{
						heightToTxt = new JTextField();
						�������.add(heightToTxt);
						heightToTxt.setBounds(106, 35, 90, 24);
					}
					{
						jLabel5 = new JLabel();
						�������.add(jLabel5);
						jLabel5.setText("\u4f53\u91cd\u4e0a\u9650");
						jLabel5.setBounds(225, 5, 63, 17);
					}
					{
						weightFromTxt = new JTextField();
						�������.add(weightFromTxt);
						weightFromTxt.setBounds(288, 2, 97, 24);
					}
					{
						jLabel6 = new JLabel();
						�������.add(jLabel6);
						jLabel6.setText("\u4f53\u91cd\u4e0b\u9650");
						jLabel6.setBounds(225, 38, 56, 17);
					}
					{
						weightToTxt = new JTextField();
						�������.add(weightToTxt);
						weightToTxt.setBounds(288, 35, 97, 24);
					}
				}
				{
					�������� = new JPanel();
					jTabbedPane1.addTab("��������", null, ��������, null);
					��������.setPreferredSize(new java.awt.Dimension(306, 19));
					��������.setLayout(null);
					{
						jLabel7 = new JLabel();
						��������.add(jLabel7);
						jLabel7.setText("\u51fa\u751f\u65e5\u671f\u4e0a\u9650");
						jLabel7.setBounds(12, 17, 96, 17);
					}
					{
						birthDateFromBtn = new DateChooserJButton();
						��������.add(birthDateFromBtn);
						birthDateFromBtn.setBounds(94, 12, 121, 27);
					}
					{
						jLabel8 = new JLabel();
						��������.add(jLabel8);
						jLabel8.setText("\u51fa\u751f\u65e5\u671f\u4e0b\u9650");
						jLabel8.setBounds(234, 17, 90, 17);
					}
					{
						birthDateToBtn = new DateChooserJButton();
						��������.add(birthDateToBtn);
						birthDateToBtn.setBounds(309, 12, 127, 27);
					}
					��������.setLayout(null);
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(17, 108, 448, 207);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(443, 198));
					jScrollPane1.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(15, 216));
					{
						TableModel nameTableModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] {"����","�������","���º���","����λ��","���","����","��������"});
						jTable = new JTable();
						jScrollPane1.setViewportView(jTable);
						jTable.setModel(nameTableModel);
						jTable.setPreferredSize(new java.awt.Dimension(440, 116));
					}
				}
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("\u67e5\u8be2\u5f97\u5230\u7ed3\u679c\u6570\u91cf\uff1a");
				jLabel9.setBounds(24, 334, 139, 17);
			}
			{
				chkNumberLabel = new JLabel();
				getContentPane().add(chkNumberLabel);
				chkNumberLabel.setText("0");
				chkNumberLabel.setBounds(135, 334, 33, 17);
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(245, 331, 73, 24);
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
				backBtn.setBounds(338, 331, 72, 24);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed();
					}
				});
			}
			this.setSize(500, 400);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void okBtnActionPerformed(ActionEvent evt) {
		
		if(����.isShowing()){
			String name = nameTxt.getText();
			String sql = "select * from member where name ";
			String[] titles = {"����","�������","���º���","����λ��","���","����","��������"};
			if(nameLikeChk.isSelected()){
				//ģ����ѯ�Ĵ���
				sql = sql+"like'%"+name+"%'";
				
				Vector member = jdbc.query(sql);
				for(int count = 0;count<=member.size();count++){
					chkNumberLabel.setText(""+count);
				}
			}else{
				//��ȷ��ѯ�Ĵ���
				sql = sql+" = '"+name+"'";
				Vector member = jdbc.query(sql);
				for(int count = 0;count<=member.size();count++){
					chkNumberLabel.setText(""+count);
				}
			}
			
			DBTableModel nameTableModel = new DBTableModel(titles,sql,jdbc);
			jTable =new JTable();
			jScrollPane1.setViewportView(jTable);
			jTable.setModel(nameTableModel);
			jTable.setPreferredSize(new java.awt.Dimension(362,216));
			
		}
		if(���.isShowing()){
			String teamname = teamNameCombo.getSelectedItem().toString();
			String sql = "select * from member where teamname";
			String[] titles = {"����","�������","���º���","����λ��","���","����","��������"};
			
			if(teamLikeChk.isSelected()){
				//ģ����ѯ
				sql = "select * from member where teamname like'%"+teamname+"%'";
				Vector member = jdbc.query(sql);
				for(int count = 0;count<=member.size();count++){
					chkNumberLabel.setText(""+count);
				}
			}else{
				//��ȷ��ѯ�Ĵ���
				sql = sql+" = '"+teamname+"'";
				Vector member = jdbc.query(sql);
				for(int count = 0;count<=member.size();count++){
					chkNumberLabel.setText(""+count);
				}
			}
			
			DBTableModel nameTableModel = new DBTableModel(titles,sql,jdbc);
			jTable =new JTable();
			jScrollPane1.setViewportView(jTable);
			jTable.setModel(nameTableModel);
			jTable.setPreferredSize(new java.awt.Dimension(362,216));
			
		}
		if(�������.isShowing()){
			String sql = "select * from member where height between'"+heightFromTxt.getText()
			+"'and'"+heightToTxt.getText()+"' or weight between'"+weightFromTxt.getText()+"'and'"+weightToTxt.getText()+"'";
			Vector member = jdbc.query(sql);
			for(int count = 0;count<=member.size();count++){
				chkNumberLabel.setText(""+count);
			}
			String[] titles ={"����","�������","���º���","����λ��","���","����","��������"};
		DBTableModel nameTableModel = new DBTableModel(titles,sql,jdbc);
		jTable =new JTable();
		jScrollPane1.setViewportView(jTable);
		jTable.setModel(nameTableModel);
		jTable.setPreferredSize(new java.awt.Dimension(362,216));
		}
		if(��������.isShowing()){
			String sql = "select * from member where birthdate between'"+birthDateFromBtn.getText()+"'and'"+birthDateToBtn.getText()+"'";
			String[] titles ={"����","�������","���º���","����λ��","���","����","��������"};
			Vector member = jdbc.query(sql);
			for(int count = 0;count<=member.size();count++){
				chkNumberLabel.setText(""+count);
			}
			DBTableModel nameTableModel = new DBTableModel(titles,sql,jdbc);
			jTable =new JTable();
			jScrollPane1.setViewportView(jTable);
			jTable.setModel(nameTableModel);
			jTable.setPreferredSize(new java.awt.Dimension(443, 214));
		}
	}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new DispMemberFrame(Boolean.FALSE);
	}
	

	public DispMemberFrame(Boolean initGUI) {
		super();
	}

}
