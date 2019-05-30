package common;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author:Narcissus
 * @date:2018.12.28
 * @Title:���ģ��
 * @Description:��ʾSQL����ѯ���
 */

public class DBTableModel extends AbstractTableModel {
	private Vector tbTitles;//�����ֶεı���
	private Vector rows;//��Ҫ��ʾ������
	private TableModel table;
	private JDBCAdapter jdbc;
	public int getColumnCount(){
		return tbTitles.size();
	}
	public int getRowCount(){
		return rows.size();
	}
	public Object getValueAt(int arg0, int arg1){
		return this.table.getValueAt(arg0, arg1);
	}
	public void setTitles(String titles[]){
		tbTitles = new Vector();
		for(int i=0; i<titles.length; i++){
			tbTitles.addElement(titles[i]);
		}
	}
	public void setRows(String query){
		rows = jdbc.query(query);
		if(rows.size()==0){
			JOptionPane.showMessageDialog
				(null,"û�в�ѯ�Ľ����");
		}
	}	
	public DBTableModel(String titles[],String query,JDBCAdapter jdbc){
		this.jdbc = jdbc;
		setTitles(titles);
		setRows(query);	
		table = new DefaultTableModel(rows,tbTitles);
	}
	public Vector getRows(){
		return rows;
	}
	public Vector getColumnNames(){
		return tbTitles;
	}	
	public String getColumnName(int col){
		return tbTitles.elementAt(col).toString();
	}
	public int getRowSize(){
		return rows.size();
	}
}