package com.openweathermap;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import com.openweathermap.model.Temperature;
import com.openweathermap.model.Weather;
import com.openweathermap.util.Constants;
import com.openweathermap.util.Utilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * This class is defined to test open weather api
 * 
 * @author Chandra
 *
 */
public class OpenWeatherMap {
	private static Logger log = LogManager.getLogger(OpenWeatherMap.class.getName());
	private String zip;
	public OpenWeatherMap(String zip) {
		this.zip = zip;
	}
	/**
	 * This method logs the maximum temperature when it is more than twenty degrees
	 * celsius
	 */
	public Weather getHourlyMaxTemperatureByZip() {
		HashMap<String, Float> temperatureRecord;
		RestAssured.baseURI = Constants.BASE_URI;

		Response resp = given().queryParam(Constants.APP_ID, Constants.APP_ID_VALUE)
				.queryParam(Constants.ZIP, this.zip).queryParam(Constants.UNITS, Constants.UNITS_VALUE)
				.queryParam(Constants.CNT, Constants.CNT_VALUE).when().get(Constants.RESOURCE_URI).then().extract()
				.response();
		JsonPath js = Utilities.rawToJson(resp);
		int noOfSunnyHours = Constants.NUM_ZERO;
		Weather weather = new Weather();
		if(null == js || null == js.getList("list.main")) {
			String errorMsg = js.get("cod") + " - " + js.get("message");
			weather.setErrorMsg(errorMsg);
			return weather;
		}
		List<Temperature> tempList = new ArrayList<Temperature>();
		for (int recIndex = Constants.NUM_ZERO; recIndex < js.getList("list.main").size(); recIndex++) {
			temperatureRecord = js.get("list[" + recIndex + "].main");	
			for (Map.Entry<String, Float> temparature : temperatureRecord.entrySet()) {
				if (temparature.getKey().equalsIgnoreCase("temp_max") && temparature.getValue() > Constants.NUM_TWENTY) {
					Temperature temp = new Temperature();
					temp.setDateTime(String.valueOf(js.get("list[" + recIndex + "].dt_txt")));
					temp.setMaxTemperature(temparature.getValue());
					tempList.add(temp);
					log.info("Date and time :   " + js.get("list[" + recIndex + "].dt_txt")
							+ " and max temperature is  :  " + temparature.getValue());
					noOfSunnyHours++;
				}
			}		
		}
		weather.setTemperature(tempList);
		weather.setSunnyHours(noOfSunnyHours);
		log.info("The number of hours predicted to be sunny is/are  : "+ noOfSunnyHours);
		return weather;
	}
}
