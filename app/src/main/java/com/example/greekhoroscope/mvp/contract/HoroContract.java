package com.example.greekhoroscope.mvp.contract;

import com.example.greekhoroscope.db.entity.HoroEntity;

import java.util.List;

public interface HoroContract {
    interface View {
        void showEntities();
    }

    interface Presenter {
        void likeOrDislikeElement(String key);

        List<HoroEntity> getEntitiesList();
    }

    interface Repository {
        List<HoroEntity> loadEntities();

        List<HoroEntity> loadFavouriteEntities();

        void updateEntity(HoroEntity entity);
    }
}
