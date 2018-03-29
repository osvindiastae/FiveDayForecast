package com.os.fivedayforecast.data_model.network;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.data_model.network.services.IRequestInterface;
import com.os.fivedayforecast.data_model.network.services.ServiceConnection;

import io.reactivex.Observable;

/**
 * Created by Os on 28/03/2018.
 */

public class APIHelper implements IAPIHelper {
    private IRequestInterface iRequestInterface;

    public APIHelper() {
        this.iRequestInterface = ServiceConnection.getConnection();
    }

    @Override
    public Observable<Forecast> getForecast() {
        return iRequestInterface.getForecast();
    }
}
