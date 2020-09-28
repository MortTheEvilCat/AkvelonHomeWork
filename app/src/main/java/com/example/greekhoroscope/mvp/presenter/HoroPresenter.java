package com.example.greekhoroscope.mvp.presenter;

import android.content.Context;

import com.example.greekhoroscope.db.entity.HoroEntity;
import com.example.greekhoroscope.mvp.repository.HoroRepository;
import com.example.greekhoroscope.mvp.contract.HoroContract;

import java.util.List;

public class HoroPresenter implements HoroContract.Presenter {

    private HoroContract.View mView;
    protected HoroContract.Repository mRepository;

    public HoroPresenter(Context context, HoroContract.View view) {
        mRepository = HoroRepository.getInstance(context);
        mView = view;
    }

    @Override
    public void likeOrDislikeElement(String key) {
        List<HoroEntity> entities = mRepository.loadEntities();
        for(HoroEntity entity: entities) {
            if (entity.name.equals(key)) {
                entity.isFavourite = !entity.isFavourite;
                mRepository.updateEntity(entity);
                break;
            }
        }
        mView.showEntities();
    }

    @Override
    public List<HoroEntity> getEntitiesList() {
        return mRepository.loadEntities();
    }
}
