package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * @author:�Ŷ���
 * @version:1.0
 * @date:2008-9-10
 * @copyright:(C) 2008
 * @company:NEUSOFT
 * @Title:
 * @Description:
 */
public class JDBCAdapter {
	private String user;
	private String pwd;
	private String host;
	private String port;
	private String dbName;
	
	Connection conn;
	Statement stat;
    ResultSet rs;

    Vector rows;
	
    // ���ļ�, ��ȡ���ݿ��ʼ��������Ϣ
	private void getParams(){
		try {
			FileReader fr = new FileReader("databaseInit.txt");
			BufferedReader br = new BufferedReader(fr);
			user = br.readLine();
			pwd = br.readLine();
			host = br.readLine();
			port = br.readLine();
			dbName = br.readLine();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("δ�ҵ��ļ���");
		} catch (IOException e) {
			System.err.println("��ȡ�ļ����ݴ���");
		}
	}
	
	// ���캯����ִ�м����������򡢽���
	// ���ݿ����ӡ������������һϵ�в���
	public JDBCAdapter(){
		try{
			getParams();
			
			// ����΢���ṩ�������������JDBC��ʽ����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection
				("jdbc:sqlserver://"+host+":"+port+
				";DatabaseName="+dbName+";USER=" + user +
				";PASSWORD=" + pwd);
			
			/*
			//����JDBC-ODBC�ŷ�ʽ�����������Լ���������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:football",user,pwd);
			*/
			
			stat = conn.createStatement();
			
		}catch(ClassNotFoundException ex){
			System.err.println("����������������޷����ӣ�");
		}catch(SQLException ex2){
			ex2.printStackTrace();
			System.err.println("�����ַ������󣬻������������");
		}
		
	}
	
	// �ر����Ӷ���
	public void closeConnection(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	// �ر�������
	public void closeStatement(){
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			stat = null;
		}
	}
	
	// ִ��insert����
	public void insert(String inserting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(inserting);
			JOptionPane.showMessageDialog
				(null,"����ɹ���");
		}catch(Exception ex){
			System.err.println(ex);
			JOptionPane.showMessageDialog
				(null,"���ݲ������");
		}
	}
	
	// ִ��delete����
	public void delete(String deleting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(deleting);
			JOptionPane.showMessageDialog
				(null,"ɾ���ɹ���");
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"����ɾ������");
		}
	}
	
	// ִ��update����
	public void update(String updating){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(updating);
			JOptionPane.showMessageDialog
				(null,"�޸ĳɹ���");
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"�����޸Ĵ���");
		}
	}

	// ��ѯ����, ���������SQL���ַ���
	// ���ؽ����һ��Vector�Ķ�ά����
	public Vector query(String selecting){
		if (conn==null || stat==null){
			JOptionPane.showMessageDialog
				(null, "û�н������ݿ����ӣ�");
			return null;
		}
		
		//Ԫ���ݣ��������ֵ�
		//ͨ�����ܹ��õ�������ж����ֶΣ�
		//ÿ���ֶε�����
		ResultSetMetaData meta; 
		int colNum; //��¼�����������
		String colName[];//��¼ÿ���ֶε�����
		
		try{
			rs = stat.executeQuery(selecting);
			meta = rs.getMetaData();
			colNum = meta.getColumnCount();
			colName = new String[colNum];
			for (int i=0; i<colNum; i++){
				colName[i]=meta.getColumnLabel(i+1);
			}
			rows = new Vector();
			
			//�����صĽ��������rows��ά������
			while(rs.next()){
				Vector oneRow = new Vector();
				//ÿһ�и�����Ԫ�����ݼ��뵽oneRow������
				for(int i=1; i<=colNum; i++){
					oneRow.addElement
						((Object)rs.getObject(i));
				}
				rows.addElement(oneRow);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog
				(null, "���ݲ�ѯ����");
		}
		
		return rows;
	}

	// �رս��������
    public  void closeResultSet() {
		if (rs != null) {
			try {
				rs.close();	
				rs=null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
		}		
	}

    // �رո�������, �ͷ��ڴ�
    public void close(){
    	this.closeResultSet();
		this.closeStatement();
		this.closeConnection();
	}

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
    
    // ������ύ����
    public void commit() throws SQLException{
    	conn.commit();
    }
    
    // ����Ļع�����
    public void rollback() throws SQLException{
    	conn.rollback();
    }
    
    // ר���ڱ������̲���, �����ڽ����а���ȷ����ť֮��
    // ��Ҫִ�ж�β������, ÿ�ζ���ʾ����ɹ�
    // ��������, ��������Ĳ�������ɹ�֮�󲻽�����ʾ
	public void insert2(String inserting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(inserting);
		}catch(Exception ex){
		}
	}

	// ִ��update����
	public void update2(String updating){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(updating);
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"�����޸Ĵ���");
		}
	}

	// ִ��delete����
	public void delete2(String deleting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"û�н������ݿ����ӣ�");
		}
		try{
			stat.executeUpdate(deleting);
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"����ɾ������");
		}
	}
}



