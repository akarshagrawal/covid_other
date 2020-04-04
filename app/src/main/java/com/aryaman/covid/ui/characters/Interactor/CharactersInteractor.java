package com.aryaman.covid.ui.characters.Interactor;

import com.aryaman.covid.data.models.Character;
import com.aryaman.covid.data.models.responses.PeopleResponse;
import com.aryaman.covid.data.network.StarWarsClient;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersInteractor implements Callback<PeopleResponse> {

    private ICharactersInteractor listener;
    private StarWarsClient starWarsClient;

    public CharactersInteractor(ICharactersInteractor listener) {
        this.listener = listener;
        starWarsClient = new StarWarsClient();
    }

    public void getCharactersFromServer() {
        starWarsClient.createStarWarsService().getPeople().enqueue(this);
    }

    @Override
    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
        if(response.body().getResults() != null) {
            List<Character> characters = response.body().getResults();
            Collections.sort(characters, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            listener.onNetworkSuccess(characters);
        } else {
            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<PeopleResponse> call, Throwable t) {
        listener.onNetworkFailure();
    }
}

