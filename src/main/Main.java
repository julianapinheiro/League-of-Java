package main;


import net.rithms.riot.api.RiotApi;
import windows.MainMenuWindow;

public class Main {
	
	public static void main(String[] args) {
		
		RiotApi api = new RiotApi("YOUR API KEY");
		
		new MainMenuWindow(api).setVisible(true);
		
	}
	
}
