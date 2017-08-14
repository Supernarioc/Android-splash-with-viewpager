package com.example.nario.viewpagertest;

public enum ModelObject {

    RED(R.string.red, R.layout.view_red),
    GREEN(R.string.green, R.layout.view_green),
    BLUE(R.string.blue, R.layout.view_blue);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
