package common;

public class Main {

	/**
	 * �������
	 */
	public static void main(String[] args) {
		JDBCAdapter jdbc = new JDBCAdapter();
		MainFrame mainFrame = new MainFrame(jdbc);
		mainFrame.setVisible(true);
	}

}
