package com.example.greekhoroscope.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greekhoroscope.R;
import com.example.greekhoroscope.adapter.viewholder.HoroViewHolder;
import com.example.greekhoroscope.db.entity.HoroEntity;

import java.util.ArrayList;
import java.util.List;

public class HoroAdapter extends RecyclerView.Adapter<HoroViewHolder> {

    private List<HoroEntity> mModelsList = new ArrayList<>();

    private ListElementClickListener mListener;

    public HoroAdapter(ListElementClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public HoroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horo_list_element, parent,false);
        return new HoroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoroViewHolder holder, int position) {
        HoroEntity model = mModelsList.get(position);
        holder.onBind(model, model.name, mListener);
    }

    @Override
    public int getItemCount() {
        return mModelsList.size();
    }

    public boolean getItemFavourite(int position) {
        return mModelsList.get(position).isFavourite;
    }

    public void setItemsAndRefresh(List<HoroEntity> modelsList) {
        if (modelsList != null) {
            mModelsList = modelsList;
            notifyDataSetChanged();
        }
    }
}
