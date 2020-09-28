package com.example.greekhoroscope.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greekhoroscope.R;
import com.example.greekhoroscope.adapter.HoroAdapter;
import com.example.greekhoroscope.adapter.ListElementClickListener;
import com.example.greekhoroscope.db.entity.HoroEntity;
import com.example.greekhoroscope.mvp.contract.HoroContract;
import com.example.greekhoroscope.mvp.presenter.FavouritePresenter;
import com.example.greekhoroscope.mvp.presenter.HoroPresenter;

import java.util.List;

public class FavouriteFragment extends HoroFragment{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate root view
        View root = inflater.inflate(R.layout.fragment_horo, container, false);

        // Init presenter
        mPresenter = new FavouritePresenter(getContext(), this);

        return root;
    }
}