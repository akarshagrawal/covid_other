package com.aryaman.covid.ui.grocery.view;

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
import com.aryaman.covid.data.models.Starship;
import com.aryaman.covid.ui.grocery.presenter.groceryPresenter;
import com.aryaman.covid.ui.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class groceryFragment extends Fragment implements IgroceryView {

    @BindView(R.id.rv_grocery)
    RecyclerView recycler;

    @BindView(R.id.progress_grocery)
    ProgressBar progressBar;

    private String TAG = groceryFragment.class.getName();
    private groceryPresenter groceryPresenter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public groceryFragment() {
        groceryPresenter = new groceryPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grocery, container, false);
        ButterKnife.bind(this, view);

        groceryPresenter.loadgrocery();

        return view;
    }

    private void setRecyclerAdapter(List<Starship> grocery) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        groceryAdapter groceryAdapter = new groceryAdapter(getContext(), grocery);
        recycler.setAdapter(groceryAdapter);
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
    public void ongroceryLoadedSuccess(List<Starship> grocery) {
        Log.d(TAG, "Received grocery: " + grocery.size());
        setRecyclerAdapter(grocery);
    }

    @Override
    public void ongroceryLoadedError() {

    }
}
