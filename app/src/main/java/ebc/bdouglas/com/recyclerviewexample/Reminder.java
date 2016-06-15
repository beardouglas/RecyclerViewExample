package ebc.bdouglas.com.recyclerviewexample;

import java.util.UUID;
import java.util.Date;

/**
 * Created by bdouglas on 6/15/16.
 */
public class Reminder {

    private UUID mId;
    private String mTitle;
    private Date mDate;

    public Reminder(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getmDate() {
        return mDate;
    }

    public void setDate(Date date){
        mDate = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }
}
