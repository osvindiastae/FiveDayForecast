package com.os.fivedayforecast.data_model.network;

import com.os.fivedayforecast.data_model.network.model.Forecast;

import io.reactivex.Observable;

/**
 * Created by Os on 28/03/2018.
 */

public interface IAPIHelper {
    Observable<Forecast> getForecast();
}
