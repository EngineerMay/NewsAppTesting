package com.example.mayankchauhan.mynews.OnScreen;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.DownloadedNews.SavedNews;
import com.example.mayankchauhan.mynews.R;
import com.example.mayankchauhan.mynews.SharedPreferences.PreferenceManager;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayankchauhan on 15/04/17.
 */

public class OnScreenAdapter extends FirebaseRecyclerAdapter<ListNews,OnScreenAdapter.ListViewHolder>{


    /**
     * @param modelClass      Firebase will marshall the data at a location into
     *                        an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list.
     *                        You will be responsible for populating an instance of the corresponding
     *                        view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location,
     *                        using some combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    private Context context;

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public OnScreenAdapter(Class<ListNews> modelClass, int modelLayout, Class<ListViewHolder> viewHolderClass, Query ref,Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context = context;
    }
    @Override
    protected void populateViewHolder(final ListViewHolder viewHolder, final ListNews model, final int position) {

        viewHolder.date.setText(model.getDate());
        viewHolder.desc.setText(model.getDescription());
        viewHolder.title.setText(model.getTitle());

        viewHolder.date.setTextSize(Constants.FONT_SIZE);
        viewHolder.desc.setTextSize(Constants.FONT_SIZE);
        viewHolder.title.setTextSize(Constants.FONT_SIZE);


        viewHolder.mview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(null!= onRecyclerViewItemClickListener)
                {
                    viewHolder.imgview.setImageResource(R.drawable.ic_read_web);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.IMG_URL,model.getImageid());
                    bundle.putString(Constants.IMG_FDESC,model.getFdescription());
                    bundle.putBoolean("CLICKED",true);

                    onRecyclerViewItemClickListener.onItemClicked(bundle);
                }
            }
        });
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgview;
        TextView title,desc,date;
        View mview;
        public ListViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            imgview = (ImageView) itemView.findViewById(R.id.imageview);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            date = (TextView) itemView.findViewById(R.id.date);
        }

    }
}
