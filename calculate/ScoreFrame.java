package calculate;
import com.cloudgarden.layout.AnchorLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import common.DBTableModel;
import common.JDBCAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

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
public class ScoreFrame extends common.CenterDialog {
	JDBCAdapter jdbc;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton backBtn;
	private JTable showTable;

	public ScoreFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("\u79ef\u5206\u699c");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 560, 197);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(555, 199));
					{
						String[] titles ={"名次","球队名称","轮次","胜","平","负","进球数","失球数","净胜球","积分"};
						String sql = "select * from score order by point DESC,place ASC";
						DBTableModel dbtm = new DBTableModel(titles,sql,jdbc);
						showTable = new JTable();
						jScrollPane1.setViewportView(showTable);
						showTable.setModel(dbtm);
						showTable.setPreferredSize(new java.awt.Dimension(384, 143));
					}
				}
			}
			{
				backBtn = new JButton();
				getContentPane().add(backBtn);
				backBtn.setText("\u8fd4\u56de");
				backBtn.setBounds(448, 227, 89, 24);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backBtnActionPerformed();
					}
				});
			}
			this.setSize(600, 300);
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
		return new ScoreFrame(Boolean.FALSE);
	}

	public ScoreFrame(Boolean initGUI) {
		super();
	}

}
