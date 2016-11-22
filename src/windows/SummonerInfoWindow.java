package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Summoner.Summoner;

public class SummonerInfoWindow extends JFrame{
	
	private static final long serialVersionUID = 6116708719882153960L;
	
	private RiotApi api;
	
	public SummonerInfoWindow(RiotApi api, Summoner jogador) throws IOException {
		super("Summoner Info");
		
		this.api = api;
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		
		URL url = new URL(new String ("http://ddragon.leagueoflegends.com/cdn/6.22.1/img/profileicon/" + jogador.getProfileIconId() + ".png"));
		JLabel summonerLabel = new JLabel(jogador.getName() + " - LVL" + jogador.getSummonerLevel(), new ImageIcon (ImageIO.read(url)), JLabel.CENTER);
		summonerLabel.setVerticalTextPosition(JLabel.BOTTOM);
		summonerLabel.setHorizontalTextPosition(JLabel.CENTER);
		panel.add(summonerLabel);	
		
		summonerLabel = new JLabel(getTier(jogador));
		panel.add(summonerLabel);
		panel.add(Box.createRigidArea(new Dimension(0,0)));
		panel.add(Box.createRigidArea(new Dimension(0,0)));
		add(panel);
	}
	
	private String getTier(Summoner jogador) {
		League liga;
		try {
			liga = api.getLeagueBySummoner(Region.BR, jogador.getId()).get(0);
			LeagueEntry entrada = liga.getEntries().get(0);
			String tier = new String("<html> Queue " + liga.getQueue() + "<br>Tier " + liga.getTier() + " " + entrada.getDivision() + "</html>");
			return tier;
		} catch (RiotApiException e) {
			return new String("Unranked");
		}
		
	}
}
