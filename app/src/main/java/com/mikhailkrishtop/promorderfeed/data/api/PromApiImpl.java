package com.mikhailkrishtop.promorderfeed.data.api;

import android.database.Cursor;

import com.mikhailkrishtop.promorderfeed.data.database.PromDatabase;
import com.mikhailkrishtop.promorderfeed.data.entity.Order;
import com.mikhailkrishtop.promorderfeed.data.network.PromNetwork;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by mykhailo on 4/11/15.
 */
@Singleton
public class PromApiImpl implements PromApi {

    private final PromNetwork network;
    private final PromDatabase database;

    @Inject public PromApiImpl(PromNetwork network, PromDatabase database) {
        this.network = network;
        this.database = database;
    }

    @Override
    public Observable<Cursor> requestOrders() {
        return network.getOrders()
                .flatMap(new Func1<Order.OrderList, Observable<Void>>() {
                    @Override
                    public Observable<Void> call(Order.OrderList orderList) {
                        return database.deleteOrders().concatWith(database.createOrders(orderList.orders));
                    }
                })
                .flatMap(new Func1<Void, Observable<? extends Cursor>>() {
                    @Override
                    public Observable<? extends Cursor> call(Void aVoid) {
                        return database.readOrders("");
                    }
                });
    }

    @Override
    public Observable<Cursor> getAllOrders() {
        return database.readOrders("").flatMap(new Func1<Cursor, Observable<? extends Cursor>>() {
            @Override
            public Observable<? extends Cursor> call(Cursor cursor) {
                return cursor.getCount() > 0 ? Observable.just(cursor) : requestOrders();
            }
        });
    }

    @Override
    public Observable<Cursor> getOrdersWithFilter(String query) {
        return database.readOrders(query);
    }

}
