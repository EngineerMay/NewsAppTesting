package com.example.mayankchauhan.mynews;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.mayankchauhan.mynews.NavigationNews.NavigatedListNews;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mayankchauhan on 26/05/17.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class TestSeven {

    public static final String Test_D = "This is a test String for Description";
    public static final String Test_I = "This is a test String for Images";

    private NavigatedListNews mListNews;

    @Before
    public void createObj()
    {
        mListNews = new NavigatedListNews(Test_I,Test_D);
    }

    @Test
    public void check_ParcelableImp()
    {
        Parcel parcel = Parcel.obtain();
        mListNews.writeToParcel(parcel,mListNews.describeContents());
        parcel.setDataPosition(0);

        NavigatedListNews createFrom = NavigatedListNews.CREATOR.createFromParcel(parcel);
        String d = createFrom.getDesc();
        String i = createFrom.getImg();

        assertThat(d,is(Test_D));
        assertThat(i,is(Test_I));

    }
}
