package com.example.mayankchauhan.mynews.NavigationNews;

import android.content.Context;
import android.widget.ImageView;

import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.R;
import com.squareup.picasso.Picasso;

/**
 * Created by mayankchauhan on 16/04/17.
 */

public class PicassoLoader {

    public static void Loader(final Context context, final ImageView imageView,final String url)
    {
        if(url.length() >=0 && url != null)
        {
            Picasso.with(context).load(url).resize(Constants.SIZE,Constants.SIZE).centerCrop().into(imageView);
        }
        else
        {
            Picasso.with(context).load(url).error(R.drawable.ic_new_web).into(imageView);
        }
    }
}
