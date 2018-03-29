package com.os.fivedayforecast.forecast;

import com.os.fivedayforecast.ui.base.MvpPresenter;

/**
 * Created by Os on 28/03/2018.
 */

public interface IForecastMVPPresenter<V extends IForecastMVPView>
        extends MvpPresenter<V> {
    void loadForecast();
}
