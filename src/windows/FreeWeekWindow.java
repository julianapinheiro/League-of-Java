package windows;

import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import tests.SimpleGetSummonerID;

public class FreeWeekWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6598339067519297994L;

	public FreeWeekWindow(RiotApi api) throws RiotApiException, IOException {
		super("Free Week Champion Rotation");
			
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 4));
		
		List<String> championNames = new SimpleGetSummonerID().GetFWChampions();
		
		JLabel championLabel;
		
		for (String name : championNames) {
			//ImageIcon icon = new ImageIcon("", "champion image");
			championLabel = new JLabel(name);
			URL url = new URL(new String ("http://ddragon.leagueoflegends.com/cdn/6.22.1/img/champion/" + name + ".png"));
			championLabel.setIcon(new ImageIcon (ImageIO.read(url)));
			System.out.println();
			//championLabel.setIcon(new ImageIcon("http://ddragon.leagueoflegends.com/cdn/6.22.1/img/champion/Aatrox.png"));
			add(championLabel);
		}
		
		
	}
	
}
