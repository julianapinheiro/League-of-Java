package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.rithms.riot.api.RiotApi;

public class SummonerInfoWindow extends JFrame{

	private static final long serialVersionUID = 6116708719882153960L;
	
	public SummonerInfoWindow(RiotApi api) {
		super("Summoner Info");
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		add(panel);
	}
}
