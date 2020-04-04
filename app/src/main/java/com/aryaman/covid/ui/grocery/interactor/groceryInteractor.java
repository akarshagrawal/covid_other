package com.aryaman.covid.ui.grocery.interactor;

import com.aryaman.covid.data.models.Starship;
import com.aryaman.covid.data.models.responses.groceryResponse;
import com.aryaman.covid.data.network.StarWarsClient;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class groceryInteractor implements Callback<groceryResponse> {

    private IgroceryInteractor listener;
    private StarWarsClient starWarsClient;

    public groceryInteractor(IgroceryInteractor listener) {
        this.listener = listener;
        starWarsClient = new StarWarsClient();
    }

    public void getgroceryFromServer() {
        starWarsClient.createStarWarsService().getgrocery().enqueue(this);
    }

    @Override
    public void onResponse(Call<groceryResponse> call, Response<groceryResponse> response) {
        if(response.body().getResults() != null) {
            List<Starship> grocery = response.body().getResults();
            Collections.sort(grocery, new Comparator<Starship>() {
                @Override
                public int compare(Starship o1, Starship o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            listener.onNetworkSuccess(grocery);
        } else {
            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<groceryResponse> call, Throwable t) {
        listener.onNetworkFailure();
    }
}

