package com.aryaman.covid.data.network;

import com.aryaman.covid.data.models.responses.PeopleResponse;
import com.aryaman.covid.data.models.responses.PlanetsResponse;
import com.aryaman.covid.data.models.responses.groceryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWarsService {

    /**
     * Retrieve a list of planets
     */
    @GET("planets/")
    Call<PlanetsResponse> getPlanets();

    /**
     * Retrieve a list of people
     */
    @GET("people/")
    Call<PeopleResponse> getPeople();

    /**
     * Retrieve a list of grocery
     */
    @GET("starships/")
    Call<groceryResponse> getgrocery();
}
