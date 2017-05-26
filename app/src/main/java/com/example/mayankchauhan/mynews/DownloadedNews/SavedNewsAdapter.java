package com.example.mayankchauhan.mynews.DownloadedNews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayankchauhan.mynews.R;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayankchauhan on 19/04/17.
 */

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {

    private Context context;
    List<NewsBeans> list = new ArrayList<>();
    LayoutInflater inflater;

    public SavedNewsAdapter(Context context,List<NewsBeans> list) {
        inflater = LayoutInflater.from(context);
        this.list =list;
        this.context = context;
    }

    @Override
    public SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.navigated_single_row,parent,false);
        return new SavedNewsViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(SavedNewsViewHolder holder, int position) {

        NewsBeans beans = list.get(position);
        holder.savedDesc.setText(beans.getDescription());

        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        String img = beans.getImagePath();
        File output = new File(dir,img);

        Uri fileUri = Uri.fromFile(output);

        Picasso.with(context).load(fileUri).error(R.mipmap.ic_news_web).into(holder.savedImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        ImageView savedImage;
        TextView savedDesc;
        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            savedImage = (ImageView) itemView.findViewById(R.id.imgview);
            savedDesc = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
