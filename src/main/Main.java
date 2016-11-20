package main;


import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.CurrentGame.CurrentGameInfo;
import net.rithms.riot.dto.CurrentGame.Participant;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Static.Image;
import windows.MainMenuWindow;

public class Main {
	
	public static void main(String[] args) {
		
		RiotApi api = new RiotApi("YOUR API KEY");
		
		new MainMenuWindow(api).setVisible(true);
		/*try {
			new SimpleGetSummonerID().GetFreeWeekChampions();
		} catch (RiotApiException e) {
			e.printStackTrace();
		}*/
		
		testCurrentGame(api);
				
	}
	
	public static void testImage(RiotApi api){
		
		try {
			System.out.println(api.getDataChampion(11).getName());
			Image imagem = api.getDataChampion(11).getImage();
			System.out.println(imagem.getFull());
		} catch (RiotApiException e) {e.printStackTrace();}
		
	}
	
	public static void testCurrentGame(RiotApi api) {
		try {
			CurrentGameInfo game = api.getCurrentGameInfo(PlatformId.BR, 2451524);
			System.out.println("in game");
			for (Participant jogador : game.getParticipants()) {
				long id = jogador.getSummonerId();
				System.out.println(api.getSummonerName(Region.BR, id));
				testGetTier(api, id);
			}
		} catch (RiotApiException e) {
			//e.printStackTrace();
			System.out.println("Summoner not in game.");
		}
	}
	
	public static void testGetTier(RiotApi api, long id) {
		try {
			League liga = api.getLeagueBySummoner(Region.BR, id).get(0);
			LeagueEntry entrada = liga.getEntries().get(0);
			System.out.println("queue: " + liga.getQueue() + " tier: " + liga.getTier() + " " + entrada.getDivision());
		} catch (RiotApiException e) {
			//e.printStackTrace();
			System.out.println("Can't return Summoner tier.");
		}
	}
}
