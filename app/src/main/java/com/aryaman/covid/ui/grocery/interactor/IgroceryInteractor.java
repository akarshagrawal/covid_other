package com.aryaman.covid.ui.grocery.interactor;

import com.aryaman.covid.data.models.Starship;

import java.util.List;

public interface IgroceryInteractor {
    void onNetworkSuccess(List<Starship> grocery);
    void onNetworkFailure();
}
