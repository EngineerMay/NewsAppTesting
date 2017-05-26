package com.example.mayankchauhan.mynews;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.example.mayankchauhan.mynews.OnScreen.OnScreenActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by mayankchauhan on 26/05/17.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class TestNavigationView {

    @Rule
    public ActivityTestRule<OnScreenActivity> rule = new ActivityTestRule<>(OnScreenActivity.class);

    @Test
    public void testNavigationView() throws Exception
    {
        OnScreenActivity activity = rule.getActivity();
        View view = activity.findViewById(R.id.navigation_view);
        assertThat(view,notNullValue());


    }
}
