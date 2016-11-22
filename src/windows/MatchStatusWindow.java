package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.rithms.riot.api.RiotApi;

public class MatchStatusWindow extends JFrame {
	
	private static final long serialVersionUID = 1192723093042637699L;

	public MatchStatusWindow(RiotApi api) {
		super("Match Status");
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		add(panel);
		
	}
}
