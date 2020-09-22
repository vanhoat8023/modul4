package model;

import java.util.HashMap;
import java.util.Map;

public class Mailbox {
    private String language;
    private String pageSize;
    private String spamsFilter;
    private String[] strings;

    public Mailbox() {
    }

    public Mailbox(String language, String pageSize, String spamsFilter, String[] strings) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.strings = strings;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}


