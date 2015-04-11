package com.mikhailkrishtop.promorderfeed.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhailkrishtop.promorderfeed.R;
import com.mikhailkrishtop.promorderfeed.data.database.mapper.CursorToOderMapper;
import com.mikhailkrishtop.promorderfeed.data.entity.Order;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mykhailo on 4/11/15.
 */
public class OrdersAdapter extends CursorAdapter {

    CursorToOderMapper mapper;

    public OrdersAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mapper = new CursorToOderMapper();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, null, false);
        view.setTag(new ViewHolder(view));
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = ((ViewHolder) view.getTag());

        Order order = mapper.call(cursor);

        holder.nameTv.setText(order.name);
    }

    static class ViewHolder {
        @InjectView(R.id.name_tv) TextView nameTv;

        public ViewHolder(View rootView) {
            ButterKnife.inject(this, rootView);
        }
    }
}
