package com.wirawansanusi.storytelling.model;

/**
 * Created by wirawansanusi on 11/3/15.
 */
public class Choice {
    private String mChoiceText;
    private int mPageNumber;

    public Choice(String choiceText, int pageNumber) {
        mChoiceText = choiceText;
        mPageNumber = pageNumber;
    }

    public String getChoiceText() {
        return mChoiceText;
    }

    public void setChoiceText(String choiceText) {
        mChoiceText = choiceText;
    }

    public int getPageNumber() {
        return mPageNumber;
    }

    public void setPageNumber(int pageNumber) {
        mPageNumber = pageNumber;
    }
}
