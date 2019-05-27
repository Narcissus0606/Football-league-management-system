package calculate;
import javax.swing.JButton;
import common.JDBCAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculateFrame extends common.CenterDialog {
	JDBCAdapter  jdbc;
	private JButton scoreBtn;
	private JButton goalBtn;
	private JButton backBtn;
	
	ScoreFrame sf;
	GoalFrame gf;


	public CalculateFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("\u7edf\u8ba1\u4fe1\u606f");
				{
					scoreBtn = new JButton();
					getContentPane().add(scoreBtn);
					scoreBtn.setText("\u79ef\u5206\u699c");
					scoreBtn.setBounds(111, 36, 146, 33);
					scoreBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							sf = new ScoreFrame(jdbc);
							sf.setVisible(true);
						}
					});
				}
				{
					goalBtn = new JButton();
					getContentPane().add(goalBtn);
					goalBtn.setText("\u5c04\u624b\u699c");
					goalBtn.setBounds(111, 110, 146, 34);
					goalBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gf = new GoalFrame(jdbc);
							gf.setVisible(true);
						}
					});
				}
				{
					backBtn = new JButton();
					getContentPane().add(backBtn);
					backBtn.setText("\u8fd4\u56de");
					backBtn.setBounds(111, 183, 146, 35);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							backBtnActionPerformed();
						}
					});
				}
			}
			setSize(400, 300);
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
		return new CalculateFrame(Boolean.FALSE);
	}
	
	public CalculateFrame(Boolean initGUI) {
		super();
	}

}
