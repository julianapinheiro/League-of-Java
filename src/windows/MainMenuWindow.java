package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;

public class MainMenuWindow extends JFrame {
	
	private static final long serialVersionUID = -6686772812748502050L;
	
	public MainMenuWindow(RiotApi api) {
		
		super("League of Java");
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		
		JButton freeWeekButton = new JButton("Free Week Champions");
		freeWeekButton.addActionListener((e) -> {
			try {
				new FreeWeekWindow(api).setVisible(true);
			} catch (IOException | RiotApiException e1) {
				e1.printStackTrace();
			}
		});
		panel.add(freeWeekButton);
		
		panel.add(Box.createRigidArea(new Dimension(5,0)));
		
		JButton summonerInfoButton = new JButton("Search summoner");
		summonerInfoButton.addActionListener((e) -> {
			new SummonerInfoWindow().setVisible(true);
		});
		panel.add(summonerInfoButton);
		
		panel.add(Box.createRigidArea(new Dimension(5,0)));
		
		JButton matchStatusButton = new JButton("Search match by summoner name");
		matchStatusButton.addActionListener((e) -> {
			new MatchStatusWindow().setVisible(true);
		});
		panel.add(matchStatusButton);
		
		panel.add(Box.createRigidArea(new Dimension(5,0)));
		
		JButton urfTunesButton = new JButton("Urf Tunes");
		urfTunesButton.addActionListener((e) -> {
			new UrfTunesWindow().setVisible(true);
		});
		panel.add(urfTunesButton);
		
		add(panel);
	}
	
}
