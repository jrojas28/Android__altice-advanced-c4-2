package com.altice_crt_a.android__avanzado_4_2;

import android.app.Application;

import com.altice_crt_a.android__avanzado_4_2.classes.DaoMaster;
import com.altice_crt_a.android__avanzado_4_2.classes.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by jaime on 6/2/2018.
 */

public class CustomApplication extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "android__avanzado_4_2_db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }
}
