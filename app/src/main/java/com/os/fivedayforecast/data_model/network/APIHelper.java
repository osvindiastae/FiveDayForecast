package com.os.fivedayforecast.data_model.network;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.data_model.network.services.IRequestInterface;

import io.reactivex.Observable;

/**
 * Created by Os on 28/03/2018.
 */

public class APIHelper implements IAPIHelper {
    private IRequestInterface iRequestInterface;

    public APIHelper(IRequestInterface iRequestInterface) {
        this.iRequestInterface = iRequestInterface;
    }

    @Override
    public Observable<Forecast> getForecast() {
        return iRequestInterface.getForecast();
    }
}
