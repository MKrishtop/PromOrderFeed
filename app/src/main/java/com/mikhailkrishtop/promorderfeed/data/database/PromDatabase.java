package com.mikhailkrishtop.promorderfeed.data.database;

import android.database.Cursor;

import com.mikhailkrishtop.promorderfeed.data.entity.Order;

import java.util.List;

import rx.Observable;

/**
 * Created by mykhailo on 4/11/15.
 */
public interface PromDatabase {

    Observable<Cursor> readOrders(String query);
    Observable<Void> createOrders(List<Order> orders);
    Observable<Void> deleteOrders();

}
