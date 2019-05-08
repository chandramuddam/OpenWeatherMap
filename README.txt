
Description:

This project is small and simple example for getting response from openweathermap api
to display the hours when the temperature is more than twenty degrees for the next five hours 
and the number of sunny hours

Usage:

1. Build this project to generate openweathermap jar file
2. Place the jar file in the libraries folder
3. Create an object of OpenWeatherMap class with zip code as a parameter to the constructor

Eg. OpenWeatherMap openWeatherMap = new OpenWeatherMap("2000,au");
OpenWeatherMap openWeatherMap = new OpenWeatherMap("2145,au");
OpenWeatherMap openWeatherMap = new OpenWeatherMap("2150,au");

4. Use the method - getHourlyMaxTemperatureByZip() from OpenWeatherMap class to get the next five hours temperature and the
number of sunny hours
