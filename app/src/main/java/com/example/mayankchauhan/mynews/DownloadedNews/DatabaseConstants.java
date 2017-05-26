package com.example.mayankchauhan.mynews.DownloadedNews;

/**
 * Created by mayankchauhan on 18/04/17.
 */

public class DatabaseConstants {

    public static final String DATABASE_NAME = "database";
    public static final String TABLE_NAME = "ImgAndText";
    public static final int DATABASE_VERSION = 1;

    public static final String ID = "id";
    public static final String IMG = "img";
    public static final String DESCRIPTION = "description";

    public static final String CREATE_TABLE ="CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DESCRIPTION + " TEXT NOT NULL,"
            + IMG + " TEXT NOT NULL" + ")";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
}
