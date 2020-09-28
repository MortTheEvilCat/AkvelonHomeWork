package com.example.greekhoroscope.mvp.presenter;

import android.content.Context;

import com.example.greekhoroscope.db.entity.HoroEntity;
import com.example.greekhoroscope.mvp.contract.HoroContract;

import java.util.List;

public class FavouritePresenter extends HoroPresenter {
    public FavouritePresenter(Context context, HoroContract.View view) {
        super(context, view);
    }

    @Override
    public List<HoroEntity> getEntitiesList() {
        return mRepository.loadFavouriteEntities();
    }
}
