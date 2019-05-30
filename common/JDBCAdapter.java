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
 * @author:张冬青
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
	
    // 打开文件, 读取数据库初始化配置信息
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
			System.err.println("未找到文件！");
		} catch (IOException e) {
			System.err.println("读取文件数据错误！");
		}
	}
	
	// 构造函数，执行加载驱动程序、建立
	// 数据库连接、创建语句对象等一系列操作
	public JDBCAdapter(){
		try{
			getParams();
			
			// 采用微软提供的驱动程序进行JDBC方式连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection
				("jdbc:sqlserver://"+host+":"+port+
				";DatabaseName="+dbName+";USER=" + user +
				";PASSWORD=" + pwd);
			
			/*
			//采用JDBC-ODBC桥方式，加载驱动以及建立连接
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:football",user,pwd);
			*/
			
			stat = conn.createStatement();
			
		}catch(ClassNotFoundException ex){
			System.err.println("加载驱动程序错误，无法连接！");
		}catch(SQLException ex2){
			ex2.printStackTrace();
			System.err.println("连接字符串错误，或者语句对象错误！");
		}
		
	}
	
	// 关闭连接对象
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
	
	// 关闭语句对象
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
	
	// 执行insert操作
	public void insert(String inserting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(inserting);
			JOptionPane.showMessageDialog
				(null,"插入成功！");
		}catch(Exception ex){
			System.err.println(ex);
			JOptionPane.showMessageDialog
				(null,"数据插入错误！");
		}
	}
	
	// 执行delete操作
	public void delete(String deleting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(deleting);
			JOptionPane.showMessageDialog
				(null,"删除成功！");
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"数据删除错误！");
		}
	}
	
	// 执行update操作
	public void update(String updating){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(updating);
			JOptionPane.showMessageDialog
				(null,"修改成功！");
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"数据修改错误！");
		}
	}

	// 查询操作, 输入参数是SQL的字符串
	// 返回结果是一个Vector的二维数组
	public Vector query(String selecting){
		if (conn==null || stat==null){
			JOptionPane.showMessageDialog
				(null, "没有建立数据库连接！");
			return null;
		}
		
		//元数据，即数据字典
		//通过它能够得到结果集有多少字段，
		//每个字段的名称
		ResultSetMetaData meta; 
		int colNum; //记录结果集的列数
		String colName[];//记录每个字段的名称
		
		try{
			rs = stat.executeQuery(selecting);
			meta = rs.getMetaData();
			colNum = meta.getColumnCount();
			colName = new String[colNum];
			for (int i=0; i<colNum; i++){
				colName[i]=meta.getColumnLabel(i+1);
			}
			rows = new Vector();
			
			//将返回的结果集存入rows二维数组中
			while(rs.next()){
				Vector oneRow = new Vector();
				//每一行各个单元格内容加入到oneRow数组中
				for(int i=1; i<=colNum; i++){
					oneRow.addElement
						((Object)rs.getObject(i));
				}
				rows.addElement(oneRow);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog
				(null, "数据查询错误！");
		}
		
		return rows;
	}

	// 关闭结果集对象
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

    // 关闭各个对象, 释放内存
    public void close(){
    	this.closeResultSet();
		this.closeStatement();
		this.closeConnection();
	}

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
    
    // 事务的提交操作
    public void commit() throws SQLException{
    	conn.commit();
    }
    
    // 事务的回滚操作
    public void rollback() throws SQLException{
    	conn.rollback();
    }
    
    // 专用于比赛过程插入, 由于在界面中按下确定按钮之后
    // 需要执行多次插入操作, 每次都提示插入成功
    // 并不合理, 所以这里的插入操作成功之后不进行提示
	public void insert2(String inserting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(inserting);
		}catch(Exception ex){
		}
	}

	// 执行update操作
	public void update2(String updating){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(updating);
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"数据修改错误！");
		}
	}

	// 执行delete操作
	public void delete2(String deleting){
		if(conn == null || stat == null){
			JOptionPane.showMessageDialog
				(null,"没有建立数据库连接！");
		}
		try{
			stat.executeUpdate(deleting);
		}catch(Exception ex){
			JOptionPane.showMessageDialog
				(null,"数据删除错误！");
		}
	}
}



