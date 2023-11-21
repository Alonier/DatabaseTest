package src;

import java.sql.Date;

public class Festival {
    private String Fest_Name,content,homepage,place;
    private long Fest_ID;
    private Date open_date,close_date;


    public long getFest_ID() {
        return Fest_ID;
    }
    public String getFest_Name() {
        return Fest_Name;
    }
    public Date getClose_date() {
        return close_date;
    }
    public Date getOpen_date() {
        return open_date;
    }

    public String getContent() {
        return content;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getPlace() {
        return place;
    }

    public void setFest_ID(long fest_ID) {
        Fest_ID = fest_ID;
    }

    public void setFest_Name(String fest_Name) {
        Fest_Name = fest_Name;
    }

    public void setClose_date(Date close_date) {
        this.close_date = close_date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
