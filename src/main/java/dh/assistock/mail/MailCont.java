package dh.assistock.mail;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MailCont {
    public static void main(String[] args) {
        // Create a Calendar object to represent the current time
        Calendar now = Calendar.getInstance();

        // Set the Calendar object to the desired execution time: 9 a.m.
        now.set(Calendar.HOUR_OF_DAY, 9);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);

        // If the execution time has already passed today, schedule the task for tomorrow
        if (now.before(Calendar.getInstance())) {
            now.add(Calendar.DATE, 1);
        }

        // Create a Timer object
        Timer timer = new Timer();

        // Create a TimerTask to be executed at the desired execution time
        TimerTask task = new TimerTask() {
            public void run() {
                // This code will be executed every day at 9 a.m.
                System.out.println("Task executed!");
            }
        };

        // Schedule the task to be executed at the desired time
        timer.scheduleAtFixedRate(task, now.getTime(), 1000 * 60 * 60 * 24);
    }

} //end of MailCont class
