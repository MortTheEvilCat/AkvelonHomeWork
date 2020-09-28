package com.example.greekhoroscope.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greekhoroscope.R;
import com.example.greekhoroscope.adapter.ListElementClickListener;
import com.example.greekhoroscope.db.entity.HoroEntity;

import net.cachapa.expandablelayout.ExpandableLayout;

public class HoroViewHolder extends RecyclerView.ViewHolder {
    private TextView name, description;
    private ImageView image;
    private ConstraintLayout mainLayout;
    private ExpandableLayout expLayout;

    public HoroViewHolder(@NonNull View itemView) {
        super(itemView);
        mainLayout = itemView.findViewById(R.id.list_element_layout);
        expLayout = itemView.findViewById(R.id.exp_layout);
        name = itemView.findViewById(R.id.tv_name);
        description = itemView.findViewById(R.id.tv_description);
        image = itemView.findViewById(R.id.iv_icon);
    }

    public void onBind(HoroEntity model, final String modelKey, final ListElementClickListener listener) {
        name.setText(model.name);
        description.setText(model.description);
        if (model.isFavourite) {
            image.setImageResource(R.drawable.ic_baseline_thumb_up_red);
        }
        else
        {
            image.setImageResource(R.drawable.ic_baseline_thumb_up_white);
        }

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expLayout.setExpanded(!expLayout.isExpanded());
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(modelKey);
                }
            }
        });
    }
}
