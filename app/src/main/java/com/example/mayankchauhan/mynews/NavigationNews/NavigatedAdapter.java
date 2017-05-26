package com.example.mayankchauhan.mynews.NavigationNews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayankchauhan.mynews.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by mayankchauhan on 16/04/17.
 */

public class NavigatedAdapter extends FirebaseRecyclerAdapter<NavigatedListNews,NavigatedAdapter.NavigatedViewHolder> {

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

    private final Context context;
    public NavigatedAdapter(Class<NavigatedListNews> modelClass, int modelLayout, Class<NavigatedViewHolder> viewHolderClass, Query ref,Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(NavigatedViewHolder viewHolder, NavigatedListNews model, int position) {

        viewHolder.description.setText(model.getDesc());
        String url = model.getImg();
        PicassoLoader.Loader(context,viewHolder.imgview,url);
    }

    public static class NavigatedViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView description;
        public NavigatedViewHolder(View itemView) {
            super(itemView);

            imgview = (ImageView) itemView.findViewById(R.id.imgview);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }
}
