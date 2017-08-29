package com.hhf.client;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

/**
 * Created by huanghongfa on 2017/7/28.
 */

public class HeartBeatMessageFactory  implements KeepAliveMessageFactory {

    @Override
    public boolean isRequest(IoSession ioSession, Object o) {
        //如果是客户端主动向服务器发起的心跳包, return true, 该框架会发送 getRequest() 方法返回的心跳包内容.
        return false;
    }

    @Override
    public boolean isResponse(IoSession ioSession, Object o) {
        //如果是服务器发送过来的心跳包, return true后会在 getResponse() 方法中处理心跳包.
        return false;
    }

    @Override
    public Object getRequest(IoSession ioSession) {
        //自定义向服务器发送的心跳包内容.
        return null;
    }

    @Override
    public Object getResponse(IoSession ioSession, Object o) {
        //自定义解析服务器发送过来的心跳包.
        return null;
    }
}
