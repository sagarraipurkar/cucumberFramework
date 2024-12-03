package testData;

import java.util.ArrayList;
import java.util.List;

import Pojo.addPlacePayLoad;
import Pojo.location_AddPlace;

public class AddPlaceTestData {
	
	public addPlacePayLoad AddPlaceData(String name, String address, String website, String language) {
		
		addPlacePayLoad payload = new addPlacePayLoad();
		payload.setAccuracy("50");
		payload.setAddress(address);
		payload.setLanguage(language);
		payload.setName(name);
		payload.setPhone_number("8877990066");
		payload.setWebsite(website);
		
		List <String> types = new ArrayList<String>();
		types.add("Starbuck");
		types.add("Mcdoland");	
		payload.setTypes(types);
		
		location_AddPlace loc = new location_AddPlace();
		loc.setLat("-22.456745");
		loc.setLng("22.45321234");
		payload.setLocation(loc);
		
		return payload;
		
	}
	
	public String deletePlace(String place_id) {
		String deleteplayload = "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
		return deleteplayload;
	}

}
