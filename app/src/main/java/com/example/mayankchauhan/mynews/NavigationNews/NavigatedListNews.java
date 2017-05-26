package com.example.mayankchauhan.mynews.NavigationNews;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mayankchauhan on 16/04/17.
 */

public class NavigatedListNews implements Parcelable {

    private String img;
    private String desc;

    public NavigatedListNews() {
    }

    public NavigatedListNews(String img, String desc) {
        this.img = img;
        this.desc = desc;
    }

    protected NavigatedListNews(Parcel in) {
        img = in.readString();
        desc = in.readString();
    }

    public static final Creator<NavigatedListNews> CREATOR = new Creator<NavigatedListNews>() {
        @Override
        public NavigatedListNews createFromParcel(Parcel in) {
            return new NavigatedListNews(in);
        }

        @Override
        public NavigatedListNews[] newArray(int size) {
            return new NavigatedListNews[size];
        }
    };

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img);
        dest.writeString(desc);
    }
}
