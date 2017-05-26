package com.example.mayankchauhan.mynews;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import com.example.mayankchauhan.mynews.DownloadedNews.NewsBeans;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

/**
 * Created by mayankchauhan on 26/05/17.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TestSix {

    public static final String Desc_Test = "This is a test String";
    public static final String Image_Path = "This is a test Image path";

    private NewsBeans mnewsBeans;

    @Before
    public void createBean()
    {
        mnewsBeans = new NewsBeans(Desc_Test,Image_Path);
    }

    @Test
    public void check_Parceleable()
    {
        Parcel parcel = Parcel.obtain();
        mnewsBeans.writeToParcel(parcel,mnewsBeans.describeContents());
        parcel.setDataPosition(0);

        NewsBeans createFromParcel = NewsBeans.CREATOR.createFromParcel(parcel);
        String desc =  createFromParcel.getDescription();
        String imgp = createFromParcel.getImagePath();

        assertThat(desc,is(Desc_Test));
        assertThat(imgp,is(Image_Path));
    }


}
