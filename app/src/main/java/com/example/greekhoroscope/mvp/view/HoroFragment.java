package com.example.greekhoroscope.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greekhoroscope.R;
import com.example.greekhoroscope.adapter.HoroAdapter;
import com.example.greekhoroscope.adapter.ListElementClickListener;
import com.example.greekhoroscope.db.entity.HoroEntity;
import com.example.greekhoroscope.mvp.contract.HoroContract;
import com.example.greekhoroscope.mvp.presenter.HoroPresenter;

import java.util.List;

public class HoroFragment extends Fragment implements HoroContract.View {

    protected HoroContract.Presenter mPresenter;
    private HoroAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate root view
        View root = inflater.inflate(R.layout.fragment_horo, container, false);

        // Init presenter
        mPresenter = new HoroPresenter(getContext(), this);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init Adapter and Recycler
        initAdapter(view);

        // Fill recycler
        showEntities();
    }

    private void initAdapter(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.horo_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ListElementClickListener listener = new ListElementClickListener() {
            @Override
            public void onItemClick(String primaryKey) {
                mPresenter.likeOrDislikeElement(primaryKey);
            }
        };

        mAdapter = new HoroAdapter(listener);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showEntities() {
        List<HoroEntity> entities = mPresenter.getEntitiesList();
        mAdapter.setItemsAndRefresh(entities);
    }
}