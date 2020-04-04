package com.aryaman.covid.ui.characters.view;

import com.aryaman.covid.data.models.Character;

import java.util.List;

public interface ICharactersView {
    void onCharactersLoadedSuccess(List<Character> characters);
    void onCharactersLoadedError();
}
