package com.anakinmrq.scheduleandgradesiutb.objects;

import java.io.Serializable;

public class Settings implements Serializable {

    private String EDT_URL;

    public Settings(String EDT_URL) {
        this.EDT_URL = EDT_URL;
    }

    public String getEDT_URL() {
        return EDT_URL;
    }

    public void setEDT_URL(String EDT_URL) {
        this.EDT_URL = EDT_URL;
    }
}
