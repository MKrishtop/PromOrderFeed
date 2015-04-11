package com.mikhailkrishtop.promorderfeed.data.api;

import android.database.Cursor;

import rx.Observable;

/**
 * Created by mykhailo on 4/11/15.
 */
public interface PromApi {

    Observable<Cursor> requestOrders();
    Observable<Cursor> getAllOrders();
    Observable<Cursor> getOrdersWithFilter(String query);

}
