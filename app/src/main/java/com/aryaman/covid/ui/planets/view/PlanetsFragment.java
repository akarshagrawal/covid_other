package com.aryaman.covid.ui.planets.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aryaman.covid.R;
import com.aryaman.covid.data.models.Planet;
import com.aryaman.covid.ui.planets.presenter.PlanetsPresenter;
import com.aryaman.covid.ui.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsFragment extends Fragment implements IPlanetsView {

    @BindView(R.id.rv_planets)
    RecyclerView recycler;

    @BindView(R.id.progress_planets)
    ProgressBar progressBar;

    private String TAG = PlanetsFragment.class.getName();
    private PlanetsPresenter planetsPresenter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public PlanetsFragment() {
        planetsPresenter = new PlanetsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planets, container, false);
        ButterKnife.bind(this, view);

        planetsPresenter.loadPlanets();

        return view;
    }

    private void setRecyclerAdapter(List<Planet> planets) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        PlanetsAdapter planetsAdapter = new PlanetsAdapter(getContext(), planets);
        recycler.setAdapter(planetsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(linearLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d(TAG, "onLoadMore...");
            }
        };
        recycler.addOnScrollListener(scrollListener);
    }

    @Override
    public void onPlanetsLoadedSuccess(List<Planet> planets) {
        Log.d(TAG, "Received planets: " + planets.size());
        setRecyclerAdapter(planets);
    }

    @Override
    public void onPlanetsLoadedError() {
        Log.d(TAG, "Error receiving planets");
    }
}
