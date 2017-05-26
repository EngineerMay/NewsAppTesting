package com.example.mayankchauhan.mynews.OnScreen;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mayankchauhan on 15/04/17.
 */

public class ListNews implements Parcelable {
    private String title;
    private String description;
    private String date;
    private String imageid;
    private String fdescription;

    public ListNews() {
    }

    public ListNews(String title, String description, String date, String imageid, String fdescription) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.imageid = imageid;
        this.fdescription = fdescription;
    }
    protected ListNews(Parcel in) {
        title = in.readString();
        description = in.readString();
        date = in.readString();
        imageid = in.readString();
        fdescription = in.readString();
    }
    public static final Creator<ListNews> CREATOR = new Creator<ListNews>() {
        @Override
        public ListNews createFromParcel(Parcel in) {
            return new ListNews(in);
        }

        @Override
        public ListNews[] newArray(int size) {
            return new ListNews[size];
        }
    };

    public String getTitle() {return title;}

    public void setTitle(String title){this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getImageid() {return imageid;}

    public void setImageid(String imageid) {this.imageid = imageid;}

    public String getFdescription() {return fdescription;}

    public void setFdescription(String fdescription) {this.fdescription = fdescription;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(date);
        dest.writeString(imageid);
        dest.writeString(fdescription);
    }

    @Override
    public String toString() {
        return "ListNews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                "imageid='" + imageid + '\'' +
                ", fdescription='" + fdescription + '\'' +
                '}';
    }
}
