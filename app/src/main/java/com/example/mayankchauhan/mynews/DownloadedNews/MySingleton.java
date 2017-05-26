package com.example.mayankchauhan.mynews.DownloadedNews;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mayankchauhan on 19/04/17.
 */

public class MySingleton {

    private static MySingleton singleton;
    private RequestQueue requestQueue;
    private static Context mctx;

    public MySingleton(Context context) {
        mctx = context;
        requestQueue = getRequestQueue();
    }
    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getInstance(Context context)
    {
        if (singleton == null)
        {
            singleton = new MySingleton(context);

        }
        return singleton;
    }
    public <T> void addToRequestQueue(Request<T> request)
    {
        requestQueue.add(request);

    }

}
