package com.mikhailkrishtop.promorderfeed.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mikhailkrishtop.promorderfeed.App;
import com.mikhailkrishtop.promorderfeed.data.entity.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by mykhailo on 4/11/15.
 */
@Singleton
public class SqlitePromDatabase extends SQLiteAssetHelper implements PromDatabase {

    private static final String DATABASE_NAME = "prom.db";
    private static final int DATABASE_VERSION = 1;

    public SqlitePromDatabase() {
        super(App.inst, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    @Override
    public Observable<Cursor> readOrders(String query) {
        return null;
    }

    @Override
    public Observable<Void> createOrders(List<Order> orders) {
        return null;
    }

    @Override
    public Observable<Void> deleteOrders() {
        return null;
    }

}
