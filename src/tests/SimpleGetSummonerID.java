package tests;

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
	
	public void GetFreeWeekChampions() throws RiotApiException{
		ChampionList lista = api.getChampions(Region.BR, true);
        for (Champion champ : lista.getChampions()) {
        	long id = champ.getId();
        	System.out.println(api.getDataChampion((int) id).getName());
        }
	}
}
