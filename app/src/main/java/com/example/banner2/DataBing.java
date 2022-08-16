package com.example.banner2;

import java.util.ArrayList;
import java.util.List;

public class DataBing {
    private static String[] url;
    public int viewType;
    public String imageUrl;
    public String title;

    public DataBing(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBing(String[] url) {
        this.url=url;
    }

    public static List<DataBing> getTestData3() {
        List<DataBing> list = new ArrayList<>();

        list.add(new DataBing(url[0], null, 1));
        list.add(new DataBing(url[1], null, 1));
        list.add(new DataBing(url[2], null, 1));
        list.add(new DataBing(url[3], null, 1));
        list.add(new DataBing(url[4], null, 1));
        return list;
    }
}
