package com.aryaman.covid.ui.grocery.view;

import com.aryaman.covid.data.models.Starship;

import java.util.List;

public interface IgroceryView {
    void ongroceryLoadedSuccess(List<Starship> grocery);
    void ongroceryLoadedError();
}
