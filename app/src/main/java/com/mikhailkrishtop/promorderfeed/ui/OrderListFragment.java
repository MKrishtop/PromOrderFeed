package com.mikhailkrishtop.promorderfeed.ui;


import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mikhailkrishtop.promorderfeed.R;
import com.mikhailkrishtop.promorderfeed.data.api.PromApi;
import com.mikhailkrishtop.promorderfeed.data.internal.ObservableHelper;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment {

    @InjectView(R.id.refresh) SwipeRefreshLayout refresh;
    @InjectView(R.id.orders_lv) ListView ordersLv;

    @Inject PromApi api;

    OrdersAdapter adapter;

    public OrderListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        ButterKnife.inject(this, view);
        init();
        requestData();
        return view;
    }

    private void init() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshOrders();
            }
        });
    }

    private void requestData() {
        ObservableHelper.ui(api.getAllOrders())
                .subscribe(new Action1<Cursor>() {
                    @Override
                    public void call(Cursor cursor) {
                        updateOderViews(cursor);
                    }
                });
    }

    private void refreshOrders() {
        ObservableHelper.ui(api.requestOrders())
                .subscribe(new Action1<Cursor>() {
                    @Override
                    public void call(Cursor cursor) {
                        updateOderViews(cursor);
                    }
                });
    }

    private void updateOderViews(Cursor cursor) {
        if (adapter == null) {
            adapter = new OrdersAdapter(getActivity(), cursor, 0);
            ordersLv.setAdapter(adapter);
        } else {
            adapter.changeCursor(cursor);
        }
    }

}
