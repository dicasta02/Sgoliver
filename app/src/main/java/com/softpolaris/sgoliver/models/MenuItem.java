package com.softpolaris.sgoliver.models;

/**
 * @author dacastano
 * @version 1.0
 * @since 07, November, 2018
 */
public class MenuItem {
    private byte index;
    private int imgIcon;
    private String txtName;

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }
}
