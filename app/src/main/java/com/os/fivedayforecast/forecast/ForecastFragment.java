package com.os.fivedayforecast.forecast;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.os.fivedayforecast.R;
import com.os.fivedayforecast.data_model.DataManager;
import com.os.fivedayforecast.data_model.network.model.Forecast;
import com.os.fivedayforecast.forecast.adapter.ForecastAdapter;
import com.os.fivedayforecast.ui.base.BaseFragment;
import com.os.fivedayforecast.ui.base.BasePresenter;
import com.os.fivedayforecast.ui.utils.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment
        extends BaseFragment
        implements IForecastMVPView {

    IForecastMVPPresenter<ForecastFragment> iForecastMVPPresenter;

    RecyclerView recyclerView;

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate iForecastMVPPresenter
        iForecastMVPPresenter = new ForecastPresenter<>(
                new DataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable()
        );

        iForecastMVPPresenter.onAttach(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvForecast);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        iForecastMVPPresenter.loadForecast();


    }

    @Override
    public void onFetchDataProgress() {
        showLoading();

    }

    @Override
    public void onFetchDataSuccess(Forecast forecast) {
        recyclerView.setAdapter(new ForecastAdapter(forecast.getReports(), R.layout.row_forecast ,getActivity()));
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {

    }
}
