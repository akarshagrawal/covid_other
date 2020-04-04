package com.aryaman.covid.ui.planets.view;

import com.aryaman.covid.data.models.Planet;

import java.util.List;

public interface IPlanetsView {
    void onPlanetsLoadedSuccess(List<Planet> planets);
    void onPlanetsLoadedError();
}
