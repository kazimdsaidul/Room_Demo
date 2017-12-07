package com.example.hp.roomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hp.roomdemo.database.UsersDatabase;
import com.example.hp.roomdemo.model.User;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersDatabase.getAppDatabase(this).myDao().insertUsers(new User("Kazi md.", "saidul", "saidul@gmail.com"));
        User[] users = UsersDatabase.getAppDatabase(getApplicationContext()).myDao().loadAllUsers();

        for (User user:users) {
            Log.e(TAG, "onCreate: "+user.toString());
        }

    }
}
