package com.os.fivedayforecast.forecast;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.ui.base.MvpView;

/**
 * Created by Os on 28/03/2018.
 */

public interface IForecastMVPView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(Forecast forecast);
    void onFetchDataError(String error);
}
