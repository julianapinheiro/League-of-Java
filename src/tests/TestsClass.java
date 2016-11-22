package tests;

import java.util.Arrays;
import java.util.List;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;
import net.rithms.riot.dto.CurrentGame.CurrentGameInfo;
import net.rithms.riot.dto.CurrentGame.Participant;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;

public class TestsClass {
	
	/*
	 * Just a simple class for learning how the wrapper works
	 */
	
	private RiotApi api;
	
	public TestsClass(RiotApi api) throws RiotApiException{
		this.api = api;
	}

	public void GetFreeWeekChampions() throws RiotApiException{
		ChampionList lista = api.getChampions(Region.BR, true);
        for (Champion champ : lista.getChampions()) {
        	long id = champ.getId();
        	System.out.println(api.getDataChampion((int) id).getName());
        }
	}
	
	/*
	 * Model method so I don't need to use make requests while testing the GUI
	 */
	
	public List<String> GetFWChampions() {
		List<String> lista = Arrays.asList("Braum", "Cassiopeia", "Gangplank", "Janna", /*"Jarvan IV",*/ "Jhin", "Lucian", /*"Master Yi",*/ "Tryndamere" /*, "Vel'Koz"*/);
		return lista;
	}
	
	public void testImage(RiotApi api){
		try {
			net.rithms.riot.dto.Static.Champion campeao = api.getDataChampion(Region.BR, 266, "pt_BR", "6.22.1", ChampData.IMAGE);
			System.out.println(campeao.getName());
			System.out.println(campeao.getImage().getFull());
		} catch (RiotApiException e) {e.printStackTrace();}
		
	}
	
	/*
	 * CurrentGame isn't working, problem: request limit
	 */
	public void testCurrentGame(RiotApi api) {
		try {
			CurrentGameInfo game = api.getCurrentGameInfo(PlatformId.BR, 1926057);
			System.out.println("in game");
			for (Participant jogador : game.getParticipants()) {
				long id = jogador.getSummonerId();
				System.out.println(api.getSummonerName(Region.BR, id));
				testGetTier(api, id);
				Thread.sleep(1000);
			}
		} catch (RiotApiException e) {
			e.printStackTrace();
			System.out.println("Summoner not in game.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * GetTier is working, images must be stored locally
	 */
	public void testGetTier(RiotApi api, long id) {
		try {
			League liga = api.getLeagueBySummoner(Region.BR, id).get(0);
			LeagueEntry entrada = liga.getEntries().get(0);
			System.out.println("queue: " + liga.getQueue() + " tier: " + liga.getTier() + " " + entrada.getDivision());
		} catch (RiotApiException e) {
			System.out.println("Unranked");
		}
	}
}
