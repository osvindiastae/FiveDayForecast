package com.os.fivedayforecast;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.data_model.network.services.IRequestInterface;
import com.os.fivedayforecast.forecast.ForecastFragment;
import com.os.fivedayforecast.forecast.adapter.ForecastAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // Declare the fragment manager
    private FragmentManager fragmentManager;

    private TextView mTextMessage;
    private IRequestInterface requestInterface;
    private RecyclerView recyclerView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_day_1:
                    mTextMessage.setText("Day 1");
                    return true;
                case R.id.navigation_day_2:
                    mTextMessage.setText("Day 2");
                    return true;
                case R.id.navigation_day_3:
                    mTextMessage.setText("Day 3");
                    return true;
                case R.id.navigation_day_4:
                    mTextMessage.setText("Day 4");
                    return true;
                case R.id.navigation_day_5:
                    mTextMessage.setText("Day 5");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise the fragment manager
        fragmentManager = getSupportFragmentManager();

        // load the fragment as default
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new ForecastFragment())
                    .addToBackStack(null)
                    .commit();
        }


        // get service connection
//        requestInterface = ServiceConnection.getConnection();

//        recyclerView = (RecyclerView) findViewById(R.id.rvForecast);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //LoadWeatherForecast();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void LoadWeatherForecast() {
        requestInterface.getForecast()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Forecast>() {
                    @Override
                    public void accept(Forecast forecast) throws Exception {
                        // pass
                        recyclerView.setAdapter(new ForecastAdapter(forecast.getReports(),R.layout.row_forecast,getApplicationContext()));
                        Toast.makeText(getApplicationContext(), "CITY: " + forecast.getCity().getName(), Toast.LENGTH_SHORT).show();
                        Log.i(MyApp.TAG, "CITY: " + forecast.getCity().getName());
                        Log.i(MyApp.TAG, "RESULT SIZE: " + forecast.getReports().size());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // fail
                        Log.i(MyApp.TAG, throwable.getMessage());
                    }
                });
    }
}
