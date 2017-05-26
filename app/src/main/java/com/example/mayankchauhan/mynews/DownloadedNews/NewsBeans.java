package com.example.mayankchauhan.mynews.DownloadedNews;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mayankchauhan on 19/04/17.
 */

public class NewsBeans implements Parcelable{

    int id;
    String description;
    String imagePath;

    public NewsBeans() {
    }

    public NewsBeans(String description, String imagePath) {
        this.description = description;
        this.imagePath = imagePath;
    }

    protected NewsBeans(Parcel in) {
        id = in.readInt();
        description = in.readString();
        imagePath = in.readString();
    }

    public static final Creator<NewsBeans> CREATOR = new Creator<NewsBeans>() {
        @Override
        public NewsBeans createFromParcel(Parcel in) {
            return new NewsBeans(in);
        }

        @Override
        public NewsBeans[] newArray(int size) {
            return new NewsBeans[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeString(imagePath);
    }
}
