package com.example.mayankchauhan.mynews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.Application.MyNews;
import com.example.mayankchauhan.mynews.DownloadedNews.DatabaseConstants;
import com.example.mayankchauhan.mynews.DownloadedNews.DatabaseHandler;
import com.example.mayankchauhan.mynews.DownloadedNews.NewsBeans;
import com.example.mayankchauhan.mynews.DownloadedNews.SavedNews;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mayankchauhan on 26/05/17.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TestFifteen {

    @Test
    public void testCountEntries() throws Throwable
    {
        Context mcontext =  MyNews.getInstance();
        mcontext.deleteDatabase(DatabaseConstants.DATABASE_NAME);

        DatabaseHandler databaseHandler = new DatabaseHandler(mcontext);

        NewsBeans one = new NewsBeans("Test Description","Test Path");
        NewsBeans two = new NewsBeans("Test two Description","Test path two");

        databaseHandler.addNews(one);
        databaseHandler.addNews(two);

        List<NewsBeans> test = databaseHandler.getAllNews();

        assertEquals(2,test.size());



    }
}
