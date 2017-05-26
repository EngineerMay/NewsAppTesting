package com.example.mayankchauhan.mynews.NavigationNews;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.mayankchauhan.mynews.ColorChoser.ColorPicker;
import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NavigatedNewsActivity extends AppCompatActivity {

    private int DEF_VALUE = 0;
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_news);

        recyclerView = (RecyclerView) findViewById(R.id.onclick_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(NavigatedNewsActivity.this));


        int choice = getIntent().getIntExtra(Constants.NEWS_ID,DEF_VALUE);
        changeColorActionBar(choice);

        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.NEWS_ARRAY[choice-1]);
        databaseReference.keepSynced(true);

        NavigatedAdapter navigatedAdapter = new NavigatedAdapter(NavigatedListNews.class,R.layout.navigated_single_row,
                NavigatedAdapter.NavigatedViewHolder.class,databaseReference,NavigatedNewsActivity.this);

        recyclerView.setAdapter(navigatedAdapter);

    }
    protected void changeColorActionBar(int choice)
    {
        ColorPicker colorPicker = new ColorPicker();
        String ColorName = colorPicker.getColor(choice);
        String ActionBarName = colorPicker.getName(choice);

        getSupportActionBar().setTitle(ActionBarName);
        switch (ColorName)
        {
            case "Violet" :
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Violet)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.Violet));
                }
                break;
            case "Indigo" :
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Indigo)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.Indigo));
                }
                break;
            case "Blue" :
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Blue)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.Blue));
                }
                break;
            case "Grey" :
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Grey)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.Grey));
                }
                break;
            case "Yellow" :
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Yellow)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.Yellow));
                }
                break;
            default:
                break;

        }
    }
}
