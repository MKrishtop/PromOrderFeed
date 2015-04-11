package com.mikhailkrishtop.promorderfeed.data.database.mapper;

import android.database.Cursor;

import com.mikhailkrishtop.promorderfeed.data.entity.Order;

import rx.functions.Func1;

/**
 * Created by mykhailo on 4/11/15.
 */
public class CursorToOderMapper implements Func1<Cursor, Order> {

    @Override
    public Order call(Cursor cursor) {
        Order order = new Order();

        order.id = cursor.getInt(cursor.getColumnIndex("id"));

        return order;
    }

}
