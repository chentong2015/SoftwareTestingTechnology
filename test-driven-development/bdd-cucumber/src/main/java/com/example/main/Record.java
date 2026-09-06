package com.example.main;

public class Record {

    private int bad;
    private String category;
    private boolean isEmbargo;
    private String type;
    private String gender;

    public Record() {
    }

    public Record(int bad, String category, boolean isEmbargo, String type) {
        this(bad, category, isEmbargo, type, "");
    }

    public Record(int bad, String category, boolean isEmbargo, String type, String gender) {
        this.bad = bad;
        this.category = category;
        this.isEmbargo = isEmbargo;
        this.type = type;
        this.gender = gender;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isEmbargo() {
        return isEmbargo;
    }

    public void setEmbargo(boolean embargo) {
        isEmbargo = embargo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
