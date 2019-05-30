package teamManage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import common.DBTableModel;
import common.JDBCAdapter;
import common.TeamComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


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
public class DispTeamFrame extends common.CenterDialog {

	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JComboBox teamNameCombo;
	private JScrollPane jScrollPane1;
	private JButton okBtn;
	private JButton backBtn;
	private JTable teamTable;
	private JPanel jPanel1;
	private JCheckBox likeChk;

	public DispTeamFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u663e\u793a\u7403\u961f");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7403\u961f\u540d\u79f0\uff1a");
				jLabel1.setBounds(44, 13, 80, 17);
			}
			{
				
				teamNameCombo = new TeamComboBox(jdbc);
				getContentPane().add(teamNameCombo);
				
				teamNameCombo.setBounds(114, 9, 152, 24);
				teamNameCombo.setEditable(true);
				
			}
			{
				likeChk = new JCheckBox();
				getContentPane().add(likeChk);
				likeChk.setText("\u6a21\u7cca\u67e5\u8be2");
				likeChk.setBounds(271, 11, 96, 21);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(5, 41, 367, 186);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(349, 180));
					{
						String[] titles ={"球队名称","球队主场","主教练"};
						String sql = "select * from team ";
						DBTableModel dbtm = new DBTableModel(titles,sql,jdbc);
						teamTable = new JTable();
						jScrollPane1.setViewportView(teamTable);
						teamTable.setModel(dbtm);
						
					}
				}
			}
			{
				okBtn = new JButton();
				getContentPane().add(okBtn);
				okBtn.setText("\u786e\u5b9a");
				okBtn.setBounds(76, 231, 64, 24);
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
				backBtn.setBounds(179, 233, 61, 24);
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
		
		String sql = "select * from team where name ";
		String[] titles = new String[]{"球队名称","球队主场","主教练"};
		if(likeChk.isSelected()){
			//模糊查询的处理
			sql = sql+"like'%"+teamNameCombo.getSelectedItem()+"%'";
		}else{
			//精确查询的处理
			sql = sql+" = '"+teamNameCombo.getSelectedItem()+"'";
		}
		DBTableModel teamTableModel = new DBTableModel(titles,sql,jdbc);
		teamTable =new JTable();
		jScrollPane1.setViewportView(teamTable);
		teamTable.setModel(teamTableModel);
		teamTable.setPreferredSize(new java.awt.Dimension(362,216));
		
		
	}


	protected void backBtnActionPerformed(JDBCAdapter jdbc2) {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new DispTeamFrame(Boolean.FALSE);
	}
	
	public DispTeamFrame(Boolean initGUI) {
		super();
	}

}
