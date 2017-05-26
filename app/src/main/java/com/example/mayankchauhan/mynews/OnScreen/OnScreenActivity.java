package com.example.mayankchauhan.mynews.OnScreen;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mayankchauhan.mynews.Constant.Constants;
import com.example.mayankchauhan.mynews.DownloadedNews.SavedNews;
import com.example.mayankchauhan.mynews.NavigationNews.NavigatedNewsActivity;
import com.example.mayankchauhan.mynews.R;
import com.example.mayankchauhan.mynews.SharedPreferences.PreferenceManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OnScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        ,OnRecyclerViewItemClickListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    private static final int REQUEST_READ_STORAGE = 1;
    private static final int REQUEST_WRITE_STORAGE = 2;
    private static final int ALL_PERMISSION_RESULT = 107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_screen);
        createDrawer();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(OnScreenActivity.this));

        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.OnScreen);
        databaseReference.keepSynced(true);

        OnScreenAdapter onScreenAdapter = new OnScreenAdapter(ListNews.class,R.layout.single_row,
                OnScreenAdapter.ListViewHolder.class,databaseReference,OnScreenActivity.this);
        onScreenAdapter.setOnRecyclerViewItemClickListener(OnScreenActivity.this);

        recyclerView.setAdapter(onScreenAdapter);

        mayRequestPermission();

    }
    protected void createDrawer()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(OnScreenActivity.this,drawerLayout,R.string.OPEN,R.string.CLOSE);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(OnScreenActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(OnScreenActivity.this,NavigatedNewsActivity.class);

        switch (item.getItemId()) {
            case R.id.topnews:
                intent.putExtra(Constants.NEWS_ID, 1);
                startActivity(intent);
                break;
            case R.id.sportsnews:
                intent.putExtra(Constants.NEWS_ID, 2);
                startActivity(intent);
                break;
            case R.id.entertainmentnews:
                intent.putExtra(Constants.NEWS_ID, 3);
                startActivity(intent);
                break;
            case R.id.politicsnews:
                intent.putExtra(Constants.NEWS_ID, 4);
                startActivity(intent);
                break;
            case R.id.popularnews:
                intent.putExtra(Constants.NEWS_ID, 5);
                startActivity(intent);
                break;
            case R.id.savednews:
                Intent intent1 = new Intent(OnScreenActivity.this,SavedNews.class);
                startActivity(intent1);
                break;
            case R.id.hideImage:
                if(Constants.SHOW_IMAGE)
                {
                    Constants.SHOW_IMAGE = false;
                }
                else
                {
                    Constants.SHOW_IMAGE = true;
                }
                startActivity(getIntent());
                break;
            case R.id.incfont:
                Constants.FONT_SIZE = Constants.FONT_SIZE + 5 ;
                startActivity(getIntent());
                break;
            case R.id.decfont:
                Constants.FONT_SIZE = Constants.FONT_SIZE - 5;
                startActivity(getIntent());
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public void onItemClicked(Bundle bundle) {

        String url = bundle.getString(Constants.IMG_URL);
        String fdesc = bundle.getString(Constants.IMG_FDESC);


        Intent intent = new Intent(OnScreenActivity.this,SavedNews.class);
        intent.putExtra(Constants.IMG_URL,url);
        intent.putExtra(Constants.IMG_FDESC,fdesc);
        startActivity(intent);

    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean mayRequestPermission()
    {
        if (hasPermissions(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                && hasPermissions(this,Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            return true;
        }
        if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            AlertDialog dialog = new AlertDialog.Builder(OnScreenActivity.this).create();
            dialog.setTitle("Alert");
            dialog.setMessage("App needs to Write to external Storage");
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dont Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                            ,REQUEST_WRITE_STORAGE);
                }
            });

        }
        else if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE))
        {

            AlertDialog dialog = new AlertDialog.Builder(OnScreenActivity.this).create();
            dialog.setTitle("Alert");
            dialog.setMessage("App needs to Read  external Storage");
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dont Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                            ,REQUEST_READ_STORAGE);
                }
            });
        }
        else {
            requestPermissions(new String[]
                            {Manifest.permission.WRITE_EXTERNAL_STORAGE
                                    ,Manifest.permission.READ_EXTERNAL_STORAGE}
                    ,ALL_PERMISSION_RESULT);
        }
        return false;
    }
    private boolean hasPermissions(Context context,String permission)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED);
        }
        return true;
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if (requestCode == REQUEST_WRITE_STORAGE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Write Permissions Granted", Toast.LENGTH_SHORT).show();
            }
            else if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                AlertDialog dialog = new AlertDialog.Builder(OnScreenActivity.this).create();
                dialog.setTitle("Alert");
                dialog.setMessage("App needs to Write to external Storage for full functionality");
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dont Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                                ,REQUEST_WRITE_STORAGE);
                    }
                });
            }
        }
        else if (requestCode == REQUEST_READ_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Permissions Granted", Toast.LENGTH_SHORT).show();
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                AlertDialog dialog = new AlertDialog.Builder(OnScreenActivity.this).create();
                dialog.setTitle("Alert");
                dialog.setMessage("App needs to Read external Storage for full functionality");
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dont Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                                , REQUEST_READ_STORAGE);
                    }
                });
            }
        }
        else {

            AlertDialog dialog = new AlertDialog.Builder(this).create();
            dialog.setTitle("Alert");
            dialog.setMessage("App needs to read and write external storage");
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dont allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ,Manifest.permission.READ_EXTERNAL_STORAGE},ALL_PERMISSION_RESULT);
                }
            });
        }
    }
}
