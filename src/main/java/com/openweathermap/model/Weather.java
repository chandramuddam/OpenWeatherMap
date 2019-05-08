package com.openweathermap.model;

import java.util.List;

/**
 * This class holds weather information
 * 
 * @author Chandra
 *
 */
public class Weather {

	private int sunnyHours;
	private List<Temperature> temperature;
	private String errorMsg;

	/**
	 * @return the sunnyHours
	 */
	public int getSunnyHours() {
		return sunnyHours;
	}

	/**
	 * @param sunnyHours the sunnyHours to set
	 */
	public void setSunnyHours(int sunnyHours) {
		this.sunnyHours = sunnyHours;
	}

	/**
	 * @return the temperature
	 */
	public List<Temperature> getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(List<Temperature> temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
