package io.github.yusukeiwaki.clicktalehideviewbug.static_array_list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class StaticArrayListAdapter<T, VH extends StaticArrayListViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private final ArrayList<T> data = new ArrayList<>();

    public void updateData(List<T> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public final int getItemViewType(int position) {
        return getItemViewTypeOf(data.get(position));
    }

    protected abstract int getItemViewTypeOf(T model);

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public final void onBindViewHolder(VH holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
