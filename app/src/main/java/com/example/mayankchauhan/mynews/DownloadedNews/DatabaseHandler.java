package com.example.mayankchauhan.mynews.DownloadedNews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayankchauhan on 19/04/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context,DatabaseConstants.DATABASE_NAME,null,DatabaseConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseConstants.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseConstants.DELETE_TABLE);
        onCreate(db);
    }
    public void addNews(NewsBeans news)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseConstants.DESCRIPTION,news.description);
        contentValues.put(DatabaseConstants.IMG,news.imagePath);

        db.insert(DatabaseConstants.TABLE_NAME,null,contentValues);
        db.close();
    }
    public List<NewsBeans> getAllNews()
    {
        List<NewsBeans> news = new ArrayList<>();

        String SELECT_QUERY = "SELECT * FROM "+DatabaseConstants.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(SELECT_QUERY,null);

        if (cursor.moveToFirst())
        {
            do {
                NewsBeans beans = new NewsBeans();
                beans.setId(Integer.parseInt(cursor.getString(0)));
                beans.setDescription(cursor.getString(1));
                beans.setImagePath(cursor.getString(2));

                news.add(beans);
            }while (cursor.moveToNext());
        }
        db.close();
        return news;
    }
    public int getNewsCount()
    {
        String countQuery = "SELECT * FROM "+ DatabaseConstants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();

        return  cursor.getCount();
    }
}

