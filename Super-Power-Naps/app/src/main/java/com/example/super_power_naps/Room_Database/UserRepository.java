package com.example.super_power_naps.Room_Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private UserDAO userDAO;
    private UserDatabase userDatabase;
    private LiveData<List<String>> allAlarms;
    private String uid;

    public UserRepository(Context context, String uid) {
        userDatabase = UserDatabase.getUserDatabaseInstance(context);
        userDAO = userDatabase.userDAO();
        allAlarms = userDAO.getAllAlarms(uid);
        this.uid = uid;
    }

    public void update(String alarm) {
        new UpdateAsyncTask(userDAO, uid).execute(alarm);
    }


    private class UpdateAsyncTask extends AsyncTask<String, Void, Void> {
        private UserDAO localUserDAO;
        private String uid;
        private boolean updated;
        String alarm;

        public UpdateAsyncTask(UserDAO userDAO, String uid) {
            this.localUserDAO = userDAO;
            this.uid = uid;
            updated = false;
        }

        @Override
        protected Void doInBackground(String... strings) {
            User user = userDAO.getUser(this.uid);
            if (user != null) {
                user.addAlarm(strings[0]);
                updated = true;
            }
            else {
                alarm = strings[0];
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (!updated) {
                User user1 = new User(this.uid);
                user1.addAlarm(alarm);
                new InsertAsyncTask(this.localUserDAO).execute(user1);
            }
        }
    }

    private class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO localUserDAO;

        public InsertAsyncTask(UserDAO userDAO) {
            this.localUserDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            localUserDAO.insert(users[0]);
            return null;
        }
    }

    LiveData<List<String>> getAllAlarms() {
        return allAlarms;
    }
}
