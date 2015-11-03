package com.wirawansanusi.storytelling.model;

/**
 * Created by wirawansanusi on 11/3/15.
 */
public class Page {
    private int mPageImageId;
    private String mPageText;
    private Choice mPageChoice1;
    private Choice mPageChoice2;
    public Boolean isFinal = false;

    public Page(int pageImageId, String pageText, Choice pageChoice1, Choice pageChoice2) {
        mPageImageId = pageImageId;
        mPageText = pageText;
        mPageChoice1 = pageChoice1;
        mPageChoice2 = pageChoice2;
    }

    public Page(int pageImageId, String pageText) {
        mPageImageId = pageImageId;
        mPageText = pageText;
        mPageChoice1 = null;
        mPageChoice2 = null;
        isFinal = true;
    }

    public int getPageImageId() {
        return mPageImageId;
    }

    public void setPageImageId(int pageImageId) {
        mPageImageId = pageImageId;
    }

    public String getPageText() {
        return mPageText;
    }

    public void setPageText(String pageText) {
        mPageText = pageText;
    }

    public Choice getPageChoice1() {
        return mPageChoice1;
    }

    public void setPageChoice1(Choice pageChoice1) {
        mPageChoice1 = pageChoice1;
    }

    public Choice getPageChoice2() {
        return mPageChoice2;
    }

    public void setPageChoice2(Choice pageChoice2) {
        mPageChoice2 = pageChoice2;
    }

    public Boolean getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Boolean isFinal) {
        this.isFinal = isFinal;
    }
}
