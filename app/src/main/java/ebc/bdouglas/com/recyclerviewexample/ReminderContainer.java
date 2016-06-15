package ebc.bdouglas.com.recyclerviewexample;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bdouglas on 6/15/16.
 */
public class ReminderContainer {

    private static ReminderContainer sReminderContainer;

    private List<Reminder> mReminders;

    public static ReminderContainer get(Context context) {
        if (sReminderContainer == null) {
            sReminderContainer = new ReminderContainer(context);
        }
        return sReminderContainer;
    }

    private ReminderContainer(Context context) {
        mReminders = new ArrayList<>();
        for (int i = 0; i<15; i++) {
            Reminder reminder = new Reminder();
            reminder.setTitle("Reminder " + i);
            mReminders.add(reminder);
        }
    }

    public List<Reminder> getReminders(){
        return mReminders;
    }

    public Reminder getReminder(UUID id) {
        for (Reminder reminder : mReminders) {
            if (reminder.getId().equals(id)) {
                return reminder;
            }
        }
        return null;
    }
}
