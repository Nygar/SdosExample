package com.sdos.android.sample.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.model.ProductModel;
import com.sdos.android.sample.presentation.model.TaskModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link TaskModel}.
 */
public class ItemModelAdapter extends RecyclerView.Adapter<ItemModelAdapter.BaseViewHolder> {

    private List<ProductModel> privateModels;
    private final LayoutInflater layoutInflater;
    private Context context;


    @Inject
    ItemModelAdapter(Context context) {
        this.context=context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.privateModels = Collections.emptyList();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_item;
    }

    @Override
    public int getItemCount() {
        return privateModels.size();
    }

    @Override
    public  BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(viewType, parent, false);
        return new BaseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        final ProductModel model = this.privateModels.get(position);

    }

    public void setCollection(List<ProductModel> collection) {
        this.privateModels =  collection;
        this.notifyDataSetChanged();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_cardView)
        CardView cardView;

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
