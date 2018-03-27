package com.os.fivedayforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.data_model.network.services.IRequestInterface;
import com.os.fivedayforecast.data_model.network.services.ServiceConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    private IRequestInterface requestInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // get service connection
        requestInterface = ServiceConnection.getConnection();

        LoadWeatherForecast();
    }

    private void LoadWeatherForecast() {
        requestInterface.getForecast()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Forecast>() {
                    @Override
                    public void accept(Forecast forecast) throws Exception {
                        // pass
                        Toast.makeText(TestActivity.this, "CITY: " + forecast.getCity().getName(), Toast.LENGTH_SHORT).show();
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
