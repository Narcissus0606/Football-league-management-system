package calculate;


import common.DBTableModel;
import common.JDBCAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class GoalFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton backBtn;
	private JTable showTable;

	public GoalFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u5c04\u624b\u699c");
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1);
					jPanel1.setPreferredSize(new java.awt.Dimension(465, 198));
					jPanel1.setBounds(7, 12, 465, 198);
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setPreferredSize(new java.awt.Dimension(434, 193));
						{
							String[] titles ={"名次","姓名","所在球队","球衣号码","进球数"};
							String sql = "select * from goalscore ";
							DBTableModel dbtm = new DBTableModel(titles,sql,jdbc);
							showTable = new JTable();
							jScrollPane1.setViewportView(showTable);
							showTable.setModel(dbtm);
							showTable.setPreferredSize(new java.awt.Dimension(431, 145));
						}
					}
				}
				{
					backBtn = new JButton();
					getContentPane().add(backBtn);
					backBtn.setText("\u8fd4\u56de");
					backBtn.setPreferredSize(new java.awt.Dimension(82, 24));
					backBtn.setBounds(338, 216, 82, 24);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							backBtnActionPerformed();
						}
					});
				}
			}
			this.setSize(500, 300);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new GoalFrame(Boolean.FALSE);
	}

	public GoalFrame(Boolean initGUI) {
		super();
	}

}
