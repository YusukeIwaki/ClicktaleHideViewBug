package io.github.yusukeiwaki.clicktalehideviewbug.static_array_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class StaticArrayListViewHolder<T> extends RecyclerView.ViewHolder {
    public StaticArrayListViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T model);
}
