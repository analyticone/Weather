package com.example.weather.Weather;

import org.json.JSONException;
import org.json.JSONObject;

public class Weather
{
    String name;
    double temp;
    double feels_like;
    String description;
    double wind;

    public Weather(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        temp = main.getDouble("temp");
        feels_like = main.getDouble(("feels_like"));
        description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        wind = jsonObject.getJSONObject("wind").getDouble("speed");
    }

    public String getName() {
        return name;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public String getDescription() {
        return description;
    }

    public double getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", temp=" + temp +
                ", feels_like=" + feels_like +
                ", description='" + description + '\'' +
                ", wind=" + wind +
                '}';
    }
}