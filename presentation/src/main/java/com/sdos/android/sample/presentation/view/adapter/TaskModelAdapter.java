package com.sdos.android.sample.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.model.TaskModel;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link TaskModel}.
 */
public class TaskModelAdapter extends RecyclerSwipeAdapter<TaskModelAdapter.BaseViewHolder> {

    private List<TaskModel> privateModels;
    private final LayoutInflater layoutInflater;
    private Context context;


    /**
     * Interface for listening events.
     */
    public interface TasAdapterInterface {
        void onTaskClick(TaskModel model);
    }

    private TasAdapterInterface anInterface;


    @Inject
    TaskModelAdapter(Context context) {
        this.context=context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.privateModels = Collections.emptyList();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_task;
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
        final TaskModel model = this.privateModels.get(position);

        //SingleMode config fuction
        mItemManger.bindView(holder.itemView, position);

        holder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        holder.taskName.setText(model.getName());

        if(model.isEnd()){
            holder.img.setImageResource(R.drawable.ic_check_black_24dp);
            holder.swipeLayout.setRightSwipeEnabled(false);
        }else{
            holder.img.setImageResource(R.drawable.ic_clear_black_24dp);
        }

        holder.relativeLayout.setOnClickListener(v -> {
            holder.swipeLayout.close();
            holder.swipeLayout.setRightSwipeEnabled(false);

            model.setEnd(true);
            holder.img.setImageResource(R.drawable.ic_check_black_24dp);
            anInterface.onTaskClick(model);

        });

    }

    public void setCollection(List<TaskModel> collection) {
        this.privateModels =  collection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (TasAdapterInterface onItemClickListener) {
        this.anInterface = onItemClickListener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * thsi fuction is necessary for singlemode swiper adapter
     * @param position
     * @return id from swiperLayout in row
     */
    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.row_task_swiper;
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_task_swiper)
        SwipeLayout swipeLayout;

        @BindView(R.id.bottom_wrapper)
        RelativeLayout relativeLayout;

        @BindView(R.id.row_task_check)
        ImageView img;

        @BindView(R.id.task_name)
        TextView taskName;

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
