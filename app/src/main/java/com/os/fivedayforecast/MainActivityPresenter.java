package com.os.fivedayforecast;

import com.os.fivedayforecast.data_model.DataManager;
import com.os.fivedayforecast.ui.base.BasePresenter;
import com.os.fivedayforecast.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Os on 28/03/2018.
 */

public class MainActivityPresenter<V extends IMainActivityMVPView>
        extends BasePresenter<V>
        implements IMainActivityMVPPresenter<V> {

    public MainActivityPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadForecast() {

    }
}
