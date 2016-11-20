package tests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;
import net.rithms.riot.dto.Summoner.Summoner;
//import com.google.gson.*;

public class SimpleGetSummonerID {
	
	/*
	 * Just a simple class for learning how the wrapper works
	 */
	
	private RiotApi api;
	
	public SimpleGetSummonerID(RiotApi api) throws RiotApiException{
		this.api = api;
        Map<String, Summoner> summoners;
		summoners = api.getSummonersByName(Region.BR, "theaan");
		Summoner summoner = summoners.get("theaan");
	    long id = summoner.getId();
	    System.out.println(id);
	     
	}
	
	public SimpleGetSummonerID(){
		
	}
	
	/*
	 * below method works :D
	 */
	
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
}
