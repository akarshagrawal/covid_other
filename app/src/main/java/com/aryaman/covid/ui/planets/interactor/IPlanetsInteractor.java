package com.aryaman.covid.ui.planets.interactor;

import com.aryaman.covid.data.models.Planet;

import java.util.List;

public interface IPlanetsInteractor {
    void onNetworkSuccess(List<Planet> planets);
    void onNetworkFailure();
}
