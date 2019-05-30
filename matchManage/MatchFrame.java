package matchManage;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import common.DateChooserJButton;
import common.JDBCAdapter;
import common.TeamComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MatchFrame extends common.CenterDialog {
	
	JDBCAdapter jdbc;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JComboBox homeCombo;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField turnTxt;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JButton awayBtn;
	private JButton homeBtn;
	private JButton okBtn;
	private JTextArea awayTimeTa;
	private JTextArea awayTa;
	private JTextArea homeTimeTa;
	private JTextArea homeTa;
	private JTextField awayScoreTxt;
	private JTextField homeScoreTxt;
	private JLabel jLabel12;
	private JComboBox awayCombo;
	private JLabel jLabel11;
	private JButton backBtn;
	private JTextField awayGoalTimeTxt;
	private JLabel jLabel7;
	private JTextField homeGoalTimeTxt;
	private JLabel jLabel6;
	private JComboBox awayMemberCombo;
	private JComboBox homeMemberCombo;
	private JButton matchDateBtn;
	int score1=0 ;
	int score2 = 0;
	
	public MatchFrame(JDBCAdapter jdbc) {
		this.jdbc = jdbc;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("\u6bd4\u8d5b\u60c5\u51b5\u5f55\u5165");
				getContentPane().setLayout(null);
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("\u6bd4\u8d5b\u65e5\u671f");
					jLabel1.setBounds(41, 12, 58, 17);
				}
				{
					matchDateBtn = new DateChooserJButton();
					getContentPane().add(matchDateBtn);
					matchDateBtn.setBounds(121, 12, 108, 20);
					matchDateBtn.setPreferredSize(new java.awt.Dimension(92, 17));

				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("\u4e3b\u961f");
					jLabel2.setBounds(12, 52, 35, 17);
				}
				{
					
					homeCombo = new TeamComboBox(jdbc);
					getContentPane().add(homeCombo);					
					homeCombo.setBounds(44, 48, 146, 21);
					homeCombo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							homeMemberCombo.removeAllItems();
							getHomeComboInfo();
						}
					});
				}
				
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("\u5ba2\u961f");
					jLabel3.setBounds(432, 52, 40, 17);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("\u8fdb\u7403\u961f\u5458");
					jLabel4.setBounds(44, 93, 61, 17);
				}
				{
					
					ComboBoxModel homeNumberComboModel = 
						new DefaultComboBoxModel(new String[] {""});
					homeMemberCombo = new JComboBox();
					getContentPane().add(homeMemberCombo);
					homeMemberCombo.setModel(homeNumberComboModel);
					homeMemberCombo.setBounds(101, 91, 115, 21);
					
					
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("\u8fdb\u7403\u961f\u5458");
					jLabel5.setBounds(254, 93, 56, 17);
				}
				{
					
					ComboBoxModel awayNumberComboModel = 
						new DefaultComboBoxModel(new String[] { ""});
					awayMemberCombo = new JComboBox();
					getContentPane().add(awayMemberCombo);
					awayMemberCombo.setModel(awayNumberComboModel);
					awayMemberCombo.setBounds(308, 91, 122, 21);
					
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("\u8fdb\u7403\u65f6\u95f4");
					jLabel6.setBounds(44, 127, 57, 17);
				}
				{
					homeGoalTimeTxt = new JTextField();
					getContentPane().add(homeGoalTimeTxt);
					homeGoalTimeTxt.setBounds(105, 124, 111, 24);
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("\u8fdb\u7403\u65f6\u95f4");
					jLabel7.setBounds(254, 131, 54, 17);
				}
				{
					awayGoalTimeTxt = new JTextField();
					getContentPane().add(awayGoalTimeTxt);
					awayGoalTimeTxt.setBounds(308, 124, 122, 24);
				}
				{
					homeBtn = new JButton();
					getContentPane().add(homeBtn);
					homeBtn.setText("\u6dfb\u52a0");
					homeBtn.setBounds(124, 160, 70, 22);
					homeBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							score1++;
							homeBtnActionPerformed(evt);	
						}
					});
				}
				{
					awayBtn = new JButton();
					getContentPane().add(awayBtn);
					awayBtn.setText("\u6dfb\u52a0");
					awayBtn.setBounds(298, 159, 75, 24);
					awayBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							score2++;
							awayBtnActionPerformed(evt);
							
						}
					});
				}
				{
					jLabel8 = new JLabel();
					getContentPane().add(jLabel8);
					jLabel8.setText("\u9996\u5148\u6dfb\u52a0\u8fdb\u7403\u961f\u5458\u548c\u8fdb\u7403\u65f6\u95f4\uff0c\u6309\u4e0b\u6dfb\u52a0\u6309\u94ae\uff0c");
					jLabel8.setBounds(7, 314, 283, 17);
					jLabel8.setForeground(new java.awt.Color(255,0,0));
				}
				{
					jLabel9 = new JLabel();
					getContentPane().add(jLabel9);
					jLabel9.setText("\u628a\u672c\u573a\u6bd4\u8d5b\u6240\u6709\u8fdb\u7403\u90fd\u6dfb\u52a0\u5b8c\u6210\uff0c\u4f1a\u81ea\u52a8\u663e\u793a\u6bd4\u5206");
					jLabel9.setBounds(7, 334, 295, 17);
					jLabel9.setForeground(new java.awt.Color(255,0,0));
				}
				{
					jLabel10 = new JLabel();
					getContentPane().add(jLabel10);
					jLabel10.setText("\u6bd4\u8d5b\u8f6e\u6b21");
					jLabel10.setBounds(271, 12, 63, 17);
				}
				{
					turnTxt = new JTextField();
					getContentPane().add(turnTxt);
					turnTxt.setBounds(334, 9, 92, 24);
				}
				{
					okBtn = new JButton();
					getContentPane().add(okBtn);
					okBtn.setText("\u786e\u5b9a");
					okBtn.setBounds(299, 321, 64, 24);
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
					backBtn.setBounds(373, 321, 65, 24);
					backBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							backBtnActionPerformed();
						}
					});
				}
				{
					jLabel11 = new JLabel();
					getContentPane().add(jLabel11);
					jLabel11.setText("*");
					jLabel11.setBounds(432, 14, 10, 17);
					jLabel11.setForeground(new java.awt.Color(255,0,0));
				}
				{
					
					awayCombo = new TeamComboBox(jdbc);
					getContentPane().add(awayCombo);
					
					awayCombo.setBounds(308, 48, 118, 24);
					awayCombo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							awayMemberCombo.removeAllItems();
							getMemberInfoByAway();
						}
					});
				}
				{
					jLabel12 = new JLabel();
					getContentPane().add(jLabel12);
					jLabel12.setBounds(237, 53, -1, 250);
				}
				{
					homeScoreTxt = new JTextField();
					getContentPane().add(homeScoreTxt);
					homeScoreTxt.setBounds(199, 49, 38, 24);
					homeScoreTxt.setEditable(false);
				}
				{
					awayScoreTxt = new JTextField();
					getContentPane().add(awayScoreTxt);
					awayScoreTxt.setBounds(249, 49, 35, 24);
					awayScoreTxt.setEditable(false);
				}
				{
					homeTa = new JTextArea();
					getContentPane().add(homeTa);
					homeTa.setBounds(47, 193, 97, 109);
				}
				{
					homeTimeTa = new JTextArea();
					getContentPane().add(homeTimeTa);
					homeTimeTa.setBounds(150, 194, 69, 108);
				}
				{
					awayTa = new JTextArea();
					getContentPane().add(awayTa);
					awayTa.setBounds(270, 194, 89, 108);
				}
				{
					awayTimeTa = new JTextArea();
					getContentPane().add(awayTimeTa);
					awayTimeTa.setBounds(365, 194, 65, 108);
				}
			}
			this.setSize(500, 400);
			super.center();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ok
	protected void okBtnActionPerformed(ActionEvent evt) {
		String sql = "insert into course(home,away,turn,matchdate,homescore,awayscore) " +
				"values('"+homeCombo.getSelectedItem()+"','"+awayCombo.getSelectedItem()+"','"+turnTxt.getText()+"','"
				+matchDateBtn.getText()+"','"+homeScoreTxt.getText()+"','"+awayScoreTxt.getText()+"')";
System.out.print(sql);
		jdbc.insert(sql);
		
	}

//	awayBtn
	protected void awayBtnActionPerformed(ActionEvent evt) {
		String name  = awayMemberCombo.getSelectedItem().toString();
			String time = awayGoalTimeTxt.getText();
			awayTa.setText(awayTa.getText()+name+"\n");
			awayTimeTa.setText(awayTimeTa.getText()+time+"\n");
			String matchDate = matchDateBtn.getText();
			String year = matchDate.substring(0, 4);
			try{
			awayScoreTxt.setText(""+score2);
			String selecting = "select number from member where name ='"+
			name+"'and teamname ='"+awayCombo.getSelectedItem()+"'";
System.out.println(selecting);
			Vector member = jdbc.query(selecting);
			Vector oneM = (Vector)member.get(0);
			String number = oneM.elementAt(0).toString();
//			String s = matchDate+" "+time;  
//			Timestamp time1 = Timestamp.valueOf(s);  
//System.out.println(time1);
		String sql ="insert into goal (teamname,number,turn,goaltime) values('"+awayCombo.getSelectedItem()+"','"+number+"','"+
		turnTxt.getText()+"',"+time+")";
System.out.println(sql);
		jdbc.insert(sql);
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
			try{
				String update = "update goalscore set year="+year+" where name='"+awayCombo.getSelectedItem().toString()+"'";
				System.out.println(update);
				jdbc.update2(update);
			}catch(Exception e){
				e.printStackTrace();
			}
			
	}

	//homeBtn
	protected void homeBtnActionPerformed(ActionEvent evt) {
		String name  = homeMemberCombo.getSelectedItem().toString();
		String time = homeGoalTimeTxt.getText();
		String matchDate = matchDateBtn.getText();
		String year = matchDate.substring(0, 4);
			homeTa.setText(homeTa.getText()+name+"\n");
			homeTimeTa.setText(homeTimeTa.getText()+time+"\n");
			homeScoreTxt.setText(""+score1);
			try{
			String selecting = "select number from member where name ='"+
			name+"'and teamname ='"+homeCombo.getSelectedItem()+"'";
System.out.println(selecting);
			Vector member = jdbc.query(selecting);
			Vector oneM = (Vector)member.get(0);
			String number = oneM.elementAt(0).toString();
		String sql ="insert into goal values('"+homeCombo.getSelectedItem()+"','"+number+"','"+
		turnTxt.getText()+"',"+time+")";
System.out.println(sql);
		jdbc.insert(sql);
		
		}
			catch(Exception ex){
				ex.printStackTrace();
			}

			try{
				String update = "update goalscore set year="+year+" where name='"+homeCombo.getSelectedItem().toString()+"'";
				System.out.println(update);
				jdbc.update2(update);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
	}
	
	
	//awayMember
protected void getMemberInfoByAway() {
	String teamname  = awayCombo.getSelectedItem().toString();
	String selecting = "select name from member where teamname ='"+teamname+"'";
	Vector members = jdbc.query(selecting);

	for(Object oneTeam:members){
		awayMemberCombo.addItem(((Vector)oneTeam).elementAt(0)); 
//System.out.println(((Vector)oneTeam).elementAt(0));
		}
	}

//homeMember
	protected void getHomeComboInfo() {
		String teamname  = homeCombo.getSelectedItem().toString();
		String selecting = "select name from member where teamname ='"+teamname+"'";
		Vector members = jdbc.query(selecting);
	
		for(Object oneTeam:members){
			homeMemberCombo.addItem(((Vector)oneTeam).elementAt(0)); 
//System.out.println(((Vector)oneTeam).elementAt(0));
			}
	}

	protected void backBtnActionPerformed() {
		this.setVisible(false);
		this.dispose();
		
	}

	public static Object getGUIBuilderInstance() {
		return new MatchFrame(Boolean.FALSE);
	}
	

	public MatchFrame(Boolean initGUI) {
		super();
	}

}
