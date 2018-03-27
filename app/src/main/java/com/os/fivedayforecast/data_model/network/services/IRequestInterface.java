package com.os.fivedayforecast.data_model.network.services;

import com.os.fivedayforecast.data_model.network.model.Forecast;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Os on 27/03/2018.
 */

public interface IRequestInterface {

//    @GET(APIConstants.FORECAST)
//    Observable<Forecast> getForecast(@Query("appid") String appID);

    @GET(APIConstants.FORECAST_W_KEY)
    Observable<Forecast> getForecast();
}
