package com.example.mayankchauhan.mynews.DownloadedNews;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class SavedNews extends AppCompatActivity {

    private RecyclerView recycler;
    ArrayList<NewsBeans> list = new ArrayList<>();
    SavedNewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news);
        recycler = (RecyclerView) findViewById(R.id.saved_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        toolbarColor();

        Bundle bundle = getIntent().getExtras();
        if(null != bundle)
        {
            String url = bundle.getString(Constants.IMG_URL);
            String desc = bundle.getString(Constants.IMG_FDESC);

            getImage(url,desc);

        }
        readAll();
        adapter = new SavedNewsAdapter(SavedNews.this,list);
        recycler.setAdapter(adapter);
    }
    protected void toolbarColor()
    {
        getSupportActionBar().setTitle(Constants.SavedNews);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Orange)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.Orange));
        }
    }
    public void getImage(final String url, final String desc){

        final DatabaseHandler db = new DatabaseHandler(SavedNews.this);
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                OutputStream outputStream;

                String img_name = String.format("%s%d.jpeg","name",System.currentTimeMillis());

                db.addNews(new NewsBeans(desc,img_name));

                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                File output = new File(dir,img_name);


                try {
                    outputStream = new FileOutputStream(output);
                    response.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                    outputStream.flush();
                    outputStream.close();

                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        MySingleton.getInstance(SavedNews.this).addToRequestQueue(imageRequest);
    }
    private void readAll()
    {
        DatabaseHandler db = new DatabaseHandler(SavedNews.this);
        List<NewsBeans> newsBeansList = db.getAllNews();

        for (NewsBeans news: newsBeansList)
        {
            list.add(news);

        }
    }
}
