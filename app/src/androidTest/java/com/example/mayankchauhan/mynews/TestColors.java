package com.example.mayankchauhan.mynews;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.ColorChoser.ColorPicker;

import org.junit.Before;
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
public class TestColors {

    public static final String textt = "Blue";
    public static final String textn = "Entertainment News";

    private ColorPicker colorPicker;

    @Before
    public void createPicker()
    {
        colorPicker = new ColorPicker();
    }

    @Test
    public void checkNAmeAndText()
    {
        String newsName = colorPicker.getName(3);
        String colorName = colorPicker.getColor(3);

        assertThat(textn,is(newsName));
        assertThat(textt,is(colorName));


    }
}
