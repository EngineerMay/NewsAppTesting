package com.example.mayankchauhan.mynews;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.OnScreen.ListNews;

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
public class TestEight {

    public static final String title = "This is a test title";
    public static final String desc = "This is a test description";
    public static final String date = "25/MAY/2017";
    public static final String imgid = "www.google.com";
    public static final String fulldesc = "This is a test for full description";
    private ListNews mListnews;

    @Before
    public void createNews()
    {
        mListnews = new ListNews(title,desc,date,imgid,fulldesc);
    }

    @Test
    public void createListNews()
    {
        Parcel parcel = Parcel.obtain();
        mListnews.writeToParcel(parcel,mListnews.describeContents());
        parcel.setDataPosition(0);

        ListNews createParcel = ListNews.CREATOR.createFromParcel(parcel);
        String t = createParcel.getTitle();
        String de = createParcel.getDescription();
        String da = createParcel.getDate();
        String id = createParcel.getImageid();
        String fd = createParcel.getFdescription();

        assertThat(t,is(title));
        assertThat(de,is(desc));
        assertThat(da,is(date));
        assertThat(id,is(imgid));
        assertThat(fd , is(fulldesc));
    }
}
