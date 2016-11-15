package tests;

import java.util.Map;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
//import com.google.gson.*;

public class SimpleGetSummonerID {
	
	/*
	 * Just a simple class for learning how the wrapper works
	 */
	
	public SimpleGetSummonerID(RiotApi api) {

        Map<String, Summoner> summoners;
		try {
			summoners = api.getSummonersByName(Region.BR, "theaan");
			Summoner summoner = summoners.get("theaan");
	        long id = summoner.getId();
	        System.out.println(id);
		} catch (RiotApiException e) {
			e.printStackTrace();
		}
	}
}
