package com.example.greekhoroscope;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.greekhoroscope.adapter.HoroAdapter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class RedImageMatcher implements Matcher<View> {
    private int position;

    public RedImageMatcher(int position) {
        this.position = position;
    }

    @Override
    public boolean matches(Object item) {
        RecyclerView recyclerView = (RecyclerView) item;
        HoroAdapter adapter = (HoroAdapter) recyclerView.getAdapter();
        return adapter.getItemFavourite(position);
    }

    @Override
    public void describeMismatch(Object item, Description mismatchDescription) {
        //
    }

    @Override
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
        //
    }

    @Override
    public void describeTo(Description description) {
        //
    }
}
