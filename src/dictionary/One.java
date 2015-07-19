package dictionary;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class One {
	
	static JFrame diction;
	public One() {
		
		diction = new JFrame("AMdictionary");
		diction.setSize(300,300);
		diction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		diction.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				One o = new One();
				two to = new two(diction);
			}
		});
	}
	
}
