package com.os.fivedayforecast.forecast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.os.fivedayforecast.R;
import com.os.fivedayforecast.data_model.network.model.Report;

import java.util.List;

/**
 * Created by Os on 28/03/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {

    private List<Report> reports;
    private int row_forecast;
    private Context applicationContext;

    public ForecastAdapter(List<Report> reports, int row_forecast, Context applicationContext) {
        this.reports = reports;
        this.row_forecast = row_forecast;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_forecast, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvCurrentTemperature.setText(reports.get(position).getMainBody().getTemp().toString() + "°C");
        holder.tvMaximumTemperature.setText(reports.get(position).getMainBody().getTempMax().toString() + "°C");
        holder.tvMinimumTemperature.setText(reports.get(position).getMainBody().getTempMin().toString() + "°C");
        holder.tvTime.setText(reports.get(position).getDateTimeText());
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCurrentTemperature;
        private TextView tvMinimumTemperature;
        private TextView tvMaximumTemperature;
        private TextView tvTime;


        public MyViewHolder(View itemView) {
            super(itemView);

            tvCurrentTemperature = (TextView) itemView.findViewById(R.id.tvCurrentTemperature);
            tvMinimumTemperature = (TextView) itemView.findViewById(R.id.tvMinimumTemperature);
            tvMaximumTemperature = (TextView) itemView.findViewById(R.id.tvMaximumTemperature);
            tvTime = (TextView) itemView.findViewById(R.id.tvForecastTime);

        }
    }
}
