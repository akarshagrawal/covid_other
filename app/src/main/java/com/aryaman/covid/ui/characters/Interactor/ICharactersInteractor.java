package com.aryaman.covid.ui.characters.Interactor;

import com.aryaman.covid.data.models.Character;

import java.util.List;

public interface ICharactersInteractor {
    void onNetworkSuccess(List<Character> characters);
    void onNetworkFailure();
}
