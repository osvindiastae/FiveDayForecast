package com.os.fivedayforecast;

import com.os.fivedayforecast.ui.base.MvpPresenter;

/**
 * Created by Os on 28/03/2018.
 */

public interface IMainActivityMVPPresenter<V extends IMainActivityMVPView>
        extends MvpPresenter<V> {
    void loadForecast();
}
