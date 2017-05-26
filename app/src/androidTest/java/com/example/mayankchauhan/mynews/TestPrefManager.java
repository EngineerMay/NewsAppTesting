package com.example.mayankchauhan.mynews;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.Application.MyNews;
import com.example.mayankchauhan.mynews.SharedPreferences.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mayankchauhan on 26/05/17.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TestPrefManager {

    private PreferenceManager manager;
    private Context mctx;

    @Before
    public void createPref()
    {
        mctx = MyNews.getInstance();
        manager = new PreferenceManager(mctx);
    }

    @Test
    public void addAndCheck()
    {
        manager.addValue("Yes",true);
        manager.addValue("No",false);

        boolean result = manager.getValue("Yes");

        assertThat(true,is(result));

        boolean r = manager.getValue("No");

        assertThat(false,is(r));

    }
}
