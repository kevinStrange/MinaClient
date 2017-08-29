package com.hhf.client;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huanghongfa on 2017/7/28.
 */

public class ConnectUtils {

    public static final int REPEAT_TIME = 5;//表示重连次数
    public static final String HOST = "127.0.0.1";//表示IP地址
    public static final int PORT = 3344;//表示端口号
    public static final int IDLE_TIME = 10;//客户端10s内没有向服务端发送数据
    public static final int TIMEOUT = 5;//设置连接超时时间,超过5s还没连接上便抛出异常

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String stringNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

}
