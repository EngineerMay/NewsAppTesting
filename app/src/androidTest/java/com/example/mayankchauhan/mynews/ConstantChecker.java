package com.example.mayankchauhan.mynews;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.Constant.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
/**
 * Created by mayankchauhan on 26/05/17.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ConstantChecker {

    public static final String saved_news = "Saved News";
    public static final String state = "ReadOrNot";
    public static final String onscreen = "https://mynews-ce1ca.firebaseio.com/OnScreenNews";

    @Test
    public void constantsCheck()
    {
        String sn = Constants.SavedNews;
        String st = Constants.STATE;
        String os = Constants.OnScreen;

        assertThat(sn,is(saved_news));
        assertThat(st,is(state));
        assertThat(os,is(onscreen));
    }
}
