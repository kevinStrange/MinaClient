package com.hhf.manager;

import android.util.Log;

import org.apache.mina.core.session.IoSession;

/**
 * Created by huanghongfa on 2017/7/28.
 */

public class SessionManager {

    private static SessionManager instance;

    private IoSession mSession;

    private volatile static Object bytes = new Object();

    public static SessionManager getInstance() {
        if (null == instance) {
            instance = new SessionManager();
        }
        return instance;
    }

    private SessionManager() {
    }

    public void setSeesion(IoSession session) {
        this.mSession = session;
    }

    public void writeToServer(Object msg) {
        if (mSession != null) {
            Log.e("tag", "客户端准备发送消息");
            mSession.write(msg);
        }
    }

    public void closeSession() {
        if (mSession != null) {
            mSession.closeOnFlush();
        }
    }

    public void removeSession() {
        this.mSession = null;
    }
}
