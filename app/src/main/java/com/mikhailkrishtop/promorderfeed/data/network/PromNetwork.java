package com.mikhailkrishtop.promorderfeed.data.network;

import com.mikhailkrishtop.promorderfeed.data.entity.Order;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by mykhailo on 4/11/15.
 */
public interface PromNetwork {

    @GET("/cabinet/export_orders/xml/306906?hash_tag=e1177d00a4ec9b6388c57ce8e85df009")
    Observable<Order.OrderList> getOrders();

}
