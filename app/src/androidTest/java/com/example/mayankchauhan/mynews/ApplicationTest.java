package com.example.mayankchauhan.mynews;

import android.content.pm.PackageInfo;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.MoreAsserts;

import com.example.mayankchauhan.mynews.Application.MyNews;

import org.junit.runner.RunWith;

/**
 * Created by mayankchauhan on 25/05/17.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)

public class ApplicationTest extends ApplicationTestCase<MyNews> {

    private  MyNews myNews;
    public ApplicationTest(Class<MyNews> applicationClass) {
        super(applicationClass);
    }
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        myNews = getApplication();
    }
    public void testCorrectVersion() throws Exception {
        PackageInfo info = myNews.getPackageManager().getPackageInfo(myNews.getPackageName(), 0);
        assertNotNull(info);
        MoreAsserts.assertMatchesRegex("\\d\\.\\d", info.versionName);

    }

}
