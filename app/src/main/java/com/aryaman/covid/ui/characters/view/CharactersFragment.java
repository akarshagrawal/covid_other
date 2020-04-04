package com.aryaman.covid.ui.characters.view;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.aryaman.covid.R;
import com.aryaman.covid.data.models.Character;
import com.aryaman.covid.ui.characters.Presenter.CharactersPresenter;
import com.aryaman.covid.ui.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CharactersFragment extends Fragment implements ICharactersView {

    @BindView(R.id.rv_characters)
    RecyclerView recycler;

    @BindView(R.id.progress_characters)
    ProgressBar progressBar;

    private String TAG = CharactersFragment.class.getName();
    private CharactersPresenter charactersPresenter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public CharactersFragment() {
        charactersPresenter = new CharactersPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);

        charactersPresenter.loadCharacters();

        return view;
    }

    private void setRecyclerAdapter(List<Character> characters) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        CharactersAdapter charactersAdapter = new CharactersAdapter(getContext(), characters);
        recycler.setAdapter(charactersAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(linearLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d(TAG, "onLoadMore...");
            }
        };
        recycler.addOnScrollListener(scrollListener);
    }

    @Override
    public void onCharactersLoadedSuccess(List<Character> characters) {
        Log.d(TAG, "Received characters: " + characters.size());
        setRecyclerAdapter(characters);
    }

    @Override
    public void onCharactersLoadedError() {

    }
}
