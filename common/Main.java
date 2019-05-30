package common;

public class Main {

	/**
	 * ³ÌÐòÈë¿Ú
	 */
	public static void main(String[] args) {
		JDBCAdapter jdbc = new JDBCAdapter();
		MainFrame mainFrame = new MainFrame(jdbc);
		mainFrame.setVisible(true);
	}

}
