package com.example.sunshine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	ArrayAdapter<String> mForecastAdapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //dummy data to populate ListView
            //representing day, weather, high/low
            String[] forecastArray = {
            	"Today - Sunny - 88/63",
            	"Tomorrow - Foggy - 70/40",
            	"Weds - Cloudy - 72/63",
            	"Thurs - Asteroids - 75/65",
            	"Fri - Heavy Rain - 65/56",
            	"Sat - HELP TRAPPED IN WEATHER STATION - 60/51",
            	"Sun - Sunny - 80/68"
            };
            
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));
            
            mForecastAdapter = new ArrayAdapter<String>(
            		//the current context(this fragment's parent activity)
            		getActivity(),
            		//ID of list item layout
            		R.layout.list_item_forecast,
            		//ID of the textview to populate
            		R.id.list_item_forecast_textview,
            		//Forecast data
            		weekForecast);
            //get reference to ListView, and attach this adapter to it
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);
            
            return rootView;
        }
    }
}
