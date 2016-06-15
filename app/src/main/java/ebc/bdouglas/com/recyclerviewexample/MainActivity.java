package ebc.bdouglas.com.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private class ReminderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // A ViewHolder describes an item view and
        // metadata about its place within the RecyclerView.
        // ** It also responds to click events **

        // In our item views, we only have a text view
        public TextView mTitleTextView;

        public ReminderHolder(View itemView) {
            super(itemView);

            // note that this class implements the clickable interface,
            // so instead of using an anonymous inner class like we did
            // in other places, we are just pointing to the class' own
            // implementation of onClick
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView;
        }

        @Override
        public void onClick(View v) {
            // respond to click events here, e.g. starting intent for other
            // Activity. If clicking changes the underlying data set, remember
            // to call mAdapter.notifyDataSetChanged() so the adapter can
            // re-draw the views
        }
    }

    private class ReminderAdapter extends RecyclerView.Adapter<ReminderHolder> {
        // Adapter should have a reference to its underlying data set
        private List<Reminder> mReminders;

        public ReminderAdapter(List<Reminder> reminders) {
            mReminders = reminders;
        }

        // Every time a view holder for an item is created, we're drawing
        // the layout according to simple_list_item_1. You can replace that
        // with a custom layout
        @Override
        public ReminderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ReminderHolder(view);
        }

        // Next, we're binding the model data from the Reminder class to the
        // TextView in the item layout
        @Override
        public void onBindViewHolder(ReminderHolder holder, int position) {
            Reminder reminder = mReminders.get(position);
            holder.mTitleTextView.setText(reminder.getTitle());
        }

        // All RecyclerView.Adapter subclasses need to implement getItemCount.
        // Our adapter is holding as many reminders as are in the reminder list,
        // which pulls from the static ReminderContainer
        @Override
        public int getItemCount(){
            return mReminders.size();
        }
    }

    private RecyclerView reminderRecyclerView;
    private ReminderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reminderRecyclerView = (RecyclerView) findViewById(R.id.reminder_recycler_view);

        // the LayoutManager takes care of things like knowing how to draw
        // scrolling behavior, like we talked about in class
        reminderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateUI();
    }

    // This method is going to instantiate our ReminderAdapter, feeding it
    // the data from our static ReminderContainer set, then attach the
    // ReminderAdapter to our RecyclerView
    private void updateUI() {
        ReminderContainer reminderContainer = ReminderContainer.get(this);
        List<Reminder> reminders = reminderContainer.getReminders();
        mAdapter = new ReminderAdapter(reminders);
        reminderRecyclerView.setAdapter(mAdapter);
    }
}
