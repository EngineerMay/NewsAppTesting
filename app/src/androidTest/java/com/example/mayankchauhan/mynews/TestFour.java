package com.example.mayankchauhan.mynews;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.example.mayankchauhan.mynews.NavigationNews.NavigatedNewsActivity;
import com.example.mayankchauhan.mynews.OnScreen.OnScreenActivity;
import com.example.mayankchauhan.mynews.Splash.SplashActivity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by mayankchauhan on 25/05/17.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class TestFour extends TestCase {

    @Rule
    public ActivityTestRule<OnScreenActivity> rule = new ActivityTestRule<>(OnScreenActivity.class);

    @Test
    public void testView() throws Exception
    {
        OnScreenActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.recycler_view);
        assertThat(viewById,notNullValue());
    }
}
