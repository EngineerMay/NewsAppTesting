package com.example.mayankchauhan.mynews;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mayankchauhan.mynews.DownloadedNews.SavedNews;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by mayankchauhan on 25/05/17.
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class TestTwo {

    @Rule
    public ActivityTestRule<SavedNews> rule = new ActivityTestRule<>(SavedNews.class);

    //Testing Recycler View
    @Test
    public void testViewSaved() throws Exception
    {
        SavedNews activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.saved_recycler_view);
        assertThat(viewById,notNullValue());
    }
}
