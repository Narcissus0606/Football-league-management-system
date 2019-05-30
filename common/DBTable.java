package common;
import java.sql.SQLException;

import javax.swing.JTable;


public class DBTable extends JTable{
	public DBTable(String query){
		DBTableModel1 mt = new DBTableModel1();	    	    
		mt.executeQuery(query);
		this.setModel(mt);
		try {
			mt.close();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
	public DBTable(String query,String[] columns){
		DBTableModel1 mt = new DBTableModel1();	        
	    mt.executeQuery(query);
	    mt.setColumnName(columns);
	    this.setModel(mt);
		try {
			mt.close();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}	    
	}	
	public void update(String query){
		DBTableModel1 mt = new DBTableModel1();	    	    
		mt.executeQuery(query);
		
		this.setModel(mt);
		try {
			mt.close();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
}
