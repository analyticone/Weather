package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.weather.Weather.Weather;

import org.json.JSONException;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    Weather weather;
    // https://openweathermap.org/
    final String API_KEY ="4c0b04940376050ab9ff85700fad3570";

    String url = "https://api.openweathermap.org/data/2.5/weather?zip=07090&units=imperial&appid=" + API_KEY;
    public static final String TAG = "MainActivity";

    TextView tvName;
    TextView tvTemp;
    TextView tvWind;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTemp = findViewById(R.id.tvTemp);
        tvWind = findViewById(R.id.tvWind);
        tvDescription = findViewById(R.id.tvDescription);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, json.toString());

                try {
                    weather = new Weather(json.jsonObject);
                    Log.d(TAG, "Weather: " + weather);

                    tvName.setText(weather.getName());
                    tvTemp.setText("" + weather.getTemp() +" F");
                    tvWind.setText("" + weather.getWind() + " MPH");
                    tvDescription.setText(weather.getDescription());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });




    }
}