package com.os.fivedayforecast.forecast;

import com.os.fivedayforecast.data_model.DataManager;
import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.ui.base.BasePresenter;
import com.os.fivedayforecast.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Os on 28/03/2018.
 */

public class ForecastPresenter<V extends IForecastMVPView>
        extends BasePresenter<V>
        implements IForecastMVPPresenter<V> {

    public ForecastPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadForecast() {
        // show progress dialog
        getMvpView().showLoading();
        getCompositeDisposable().add(
            getDataManager().getForecast()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Forecast>() {
                    @Override
                    public void accept(Forecast forecast) throws Exception {
                        // on success
                        getMvpView().onFetchDataSuccess(forecast);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // on error
                        getMvpView().onFetchDataError(throwable.getMessage());
                    }
                })
        );
    }
}
