package com.example.mayankchauhan.mynews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mayankchauhan.mynews.Application.MyNews;
import com.example.mayankchauhan.mynews.DownloadedNews.DatabaseConstants;
import com.example.mayankchauhan.mynews.DownloadedNews.DatabaseHandler;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by mayankchauhan on 25/05/17.
 */

public class DatabaseTest extends TestCase {

    @Test
    public void testCeateDB() throws Throwable
    {
        Context mcontext =  MyNews.getInstance();
        mcontext.deleteDatabase(DatabaseConstants.DATABASE_NAME);
        SQLiteDatabase db = new DatabaseHandler(mcontext).getWritableDatabase();
        assertEquals(true,db.isOpen());
        db.close();
    }
}
