package com.os.fivedayforecast;

import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.ui.base.MvpView;

/**
 * Created by Os on 28/03/2018.
 */

public interface IMainActivityMVPView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(Forecast forecast);
    void onFetchDataError(String error);
}
