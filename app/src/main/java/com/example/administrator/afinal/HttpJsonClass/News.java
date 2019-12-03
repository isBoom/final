package com.example.administrator.afinal.HttpJsonClass;

import java.util.List;

/**
 * Created by skyti on 2019/12/3.
 */

public class News {
    private List<New> newsList;
    private int maxPage;

    @Override
    public String toString() {
        return "News{" +
                "newsList=" + newsList +
                ", maxPage=" + maxPage +
                '}';
    }

    public List<New> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<New> newsList) {
        this.newsList = newsList;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public News(List<New> newsList, int maxPage) {
        this.newsList = newsList;
        this.maxPage = maxPage;
    }
}
