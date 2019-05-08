package com.openweathermap;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.openweathermap.model.Temperature;
import com.openweathermap.model.Weather;

public class WeatherTest {
	private static Logger log = LogManager.getLogger(OpenWeatherMap.class.getName());
	public static void main(String[] args) {

		OpenWeatherMap openWeatherMap = new OpenWeatherMap("2000,au");
		Weather weather = openWeatherMap.getHourlyMaxTemperatureByZip();
		if( null != weather.getErrorMsg()) {
			log.error("Error :" + weather.getErrorMsg());
		}else {
			List<Temperature> temperature = weather.getTemperature();
			if(temperature != null && temperature.size() > 0) {
				for(Temperature temp: temperature) {
					
					log.info("temp.getDateTime() :" + temp.getDateTime());
					log.info("temp.getMaxTemperature() :" + temp.getMaxTemperature());
				}
			}
			log.info("weather.getSunnyHours() :" + weather.getSunnyHours());
		}
	}

}
