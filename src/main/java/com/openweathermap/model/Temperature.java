package com.openweathermap.model;
/**
 * This class holds date time and temperature.
 * @author Chandra
 *
 */
public class Temperature {
	private String dateTime;
	private Float maxTemperature;

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the maxTemperature
	 */
	public Float getMaxTemperature() {
		return maxTemperature;
	}

	/**
	 * @param maxTemperature the maxTemperature to set
	 */
	public void setMaxTemperature(Float maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

}
