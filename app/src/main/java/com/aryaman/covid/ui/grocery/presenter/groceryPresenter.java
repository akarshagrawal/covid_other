package com.aryaman.covid.ui.grocery.presenter;

import com.aryaman.covid.data.models.Starship;
import com.aryaman.covid.ui.grocery.interactor.IgroceryInteractor;
import com.aryaman.covid.ui.grocery.interactor.groceryInteractor;
import com.aryaman.covid.ui.grocery.view.IgroceryView;

import java.util.List;

public class groceryPresenter implements IgroceryPresenter, IgroceryInteractor {

    private IgroceryView view;
    private groceryInteractor interactor;

    public groceryPresenter(IgroceryView view) {
        this.view = view;
        this.interactor = new groceryInteractor(this);
    }

    @Override
    public void loadgrocery() {
        interactor.getgroceryFromServer();
    }

    @Override
    public void onNetworkSuccess(List<Starship> grocery) {
        view.ongroceryLoadedSuccess(grocery);
    }

    @Override
    public void onNetworkFailure() {
        view.ongroceryLoadedError();
    }
}
