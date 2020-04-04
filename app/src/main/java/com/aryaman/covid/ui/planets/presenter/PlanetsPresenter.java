package com.aryaman.covid.ui.planets.presenter;

import com.aryaman.covid.data.models.Planet;
import com.aryaman.covid.ui.planets.interactor.IPlanetsInteractor;
import com.aryaman.covid.ui.planets.interactor.PlanetsInteractor;
import com.aryaman.covid.ui.planets.view.IPlanetsView;

import java.util.List;

public class PlanetsPresenter implements IPlanetsPresenter, IPlanetsInteractor {

    private IPlanetsView view;
    private PlanetsInteractor interactor;

    public PlanetsPresenter(IPlanetsView view) {
        this.view = view;
        this.interactor = new PlanetsInteractor(this);
    }

    @Override
    public void loadPlanets() {
        interactor.getPlanetsFromServer();
    }

    @Override
    public void onNetworkSuccess(List<Planet> planets) {
        view.onPlanetsLoadedSuccess(planets);
    }

    @Override
    public void onNetworkFailure() {
        view.onPlanetsLoadedError();
    }
}
