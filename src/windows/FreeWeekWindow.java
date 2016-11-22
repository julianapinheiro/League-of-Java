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
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.dto.Static.Champion;

public class FreeWeekWindow extends JFrame {

	private static final long serialVersionUID = -6598339067519297994L;

	public FreeWeekWindow(RiotApi api) throws RiotApiException, IOException {
		super("Free Week Champion Rotation");
			
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 4));
		
		JLabel championLabel;
		
		List<net.rithms.riot.dto.Champion.Champion> lista = api.getChampions(Region.BR, true).getChampions();
		for (int i = 0; i < 8; i++) {
			Champion campeao = api.getDataChampion(Region.BR, (int) lista.get(i).getId(), "pt_BR", "6.22.1", ChampData.ALL);
	        championLabel = new JLabel(campeao.getName());
	        URL url = new URL(new String ("http://ddragon.leagueoflegends.com/cdn/6.22.1/img/champion/" + campeao.getImage().getFull()));
	        championLabel.setIcon(new ImageIcon (ImageIO.read(url)));
			add(championLabel);
		}

	}
	
}
