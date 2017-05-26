package com.example.mayankchauhan.mynews.ColorChoser;

/**
 * Created by mayankchauhan on 16/04/17.
 */

public class ColorPicker {

    private String toolbar;
    private String toolbarColor;

    public ColorPicker() {
    }

    public String getColor(int choice)
    {
        switch (choice)
        {
            case 1:
                toolbarColor = "Violet";
                break;
            case 2:
                toolbarColor = "Indigo";
                break;
            case 3:
                toolbarColor = "Blue";
                break;
            case 4:
                toolbarColor = "Grey";
                break;
            case 5:
                toolbarColor = "Yellow";
                break;
            case 6:
                toolbarColor = "Orange";
                break;
            default:
                    break;
        }

        return toolbarColor ;
    }
    public String getName(int choice)
    {
        switch (choice)
        {
            case 1:
                toolbar = "Top News";
                break;
            case 2:
                toolbar = "Sports News";
                break;
            case 3:
                toolbar = "Entertainment News";
                break;
            case 4:
                toolbar = "Politics News";
                break;
            case 5:
                toolbar =  "Popular News";
                break;
            case 6:
                toolbar = "Downloaded News";
                break;
            default:
                break;
        }

        return toolbar;
    }
}
