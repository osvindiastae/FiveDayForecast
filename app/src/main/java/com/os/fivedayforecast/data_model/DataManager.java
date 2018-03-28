package com.os.fivedayforecast.data_model;

import com.os.fivedayforecast.data_model.network.IAPIHelper;
import com.os.fivedayforecast.data_model.network.model.Forecast;

import io.reactivex.Observable;

/**
 * Created by Os on 28/03/2018.
 */

public class DataManager implements IDataManager {
    private IAPIHelper iapiHelper;

    public DataManager(IAPIHelper iapiHelper) {
        this.iapiHelper = iapiHelper;
    }

    @Override
    public Observable<Forecast> getForecast() {
        return null;
    }
}
