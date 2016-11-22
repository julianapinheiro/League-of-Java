package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;

public class SearchSummonerWindow extends JFrame {

	private static final long serialVersionUID = -5847759268957115398L;

	public SearchSummonerWindow(RiotApi api) {
		super("Search");
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
		
		JLabel label = new JLabel("Search summoner name:");
		panel.add(label);
		
		JTextField search = new JTextField();
		panel.add(search);
		
		String input = search.getText();
			
		panel.add(Box.createRigidArea(new Dimension(0,0)));
		
		JButton summonerInfoButton = new JButton("Summoner Info");
		summonerInfoButton.addActionListener((e) -> {
			setVisible(false);
			try {
				new SummonerInfoWindow(api, api.getSummonerByName(Region.BR, "supperino")).setVisible(true);
			} catch (RiotApiException | IOException e1) {
				System.out.println("Data not found ");
				//e1.printStackTrace();
			}
		});
		panel.add(summonerInfoButton);
		
		panel.add(Box.createRigidArea(new Dimension(0,0)));
		
		JButton matchStatusButton = new JButton("Current Match");
		matchStatusButton.addActionListener((e) -> {
			setVisible(false);
			new MatchStatusWindow(api).setVisible(true);
		});

		panel.add(matchStatusButton);
		
		add(panel);
	}
	
}
