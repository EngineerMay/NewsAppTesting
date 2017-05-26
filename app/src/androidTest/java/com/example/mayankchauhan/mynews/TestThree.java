package com.example.mayankchauhan.mynews;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mayankchauhan.mynews.NavigationNews.NavigatedNewsActivity;
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
public class TestThree {

    @Rule
    public ActivityTestRule<NavigatedNewsActivity> ruleNavigated = new ActivityTestRule<>(NavigatedNewsActivity.class);

    @Test
    public void testViewRec() throws Exception
    {
        NavigatedNewsActivity activity = ruleNavigated.getActivity();
        View viewById = activity.findViewById(R.id.onclick_recycler);
        assertThat(viewById,notNullValue());
    }
}
