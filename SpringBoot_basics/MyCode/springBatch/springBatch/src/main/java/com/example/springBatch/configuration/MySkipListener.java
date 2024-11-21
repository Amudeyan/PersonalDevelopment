package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import org.springframework.batch.core.SkipListener;

public class MySkipListener implements SkipListener<Users,Users> {
    @Override
    public void onSkipInRead(Throwable t) {
        SkipListener.super.onSkipInRead(t);
    }

    @Override
    public void onSkipInWrite(Users item, Throwable t) {
        SkipListener.super.onSkipInWrite(item, t);
    }

    @Override
    public void onSkipInProcess(Users item, Throwable t) {
        SkipListener.super.onSkipInProcess(item, t);
    }
}
