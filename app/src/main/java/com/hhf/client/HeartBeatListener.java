package com.hhf.client;

import android.util.Log;

import com.hhf.manager.ClientConnectManager;

import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * Created by huanghongfa on 2017/7/28.
 * 监听服务器断线原因
 */

public class HeartBeatListener implements IoServiceListener {

    public NioSocketConnector connector;

    public HeartBeatListener(NioSocketConnector connector) {
        this.connector = connector;
    }

    @Override
    public void serviceActivated(IoService arg0) throws Exception {
    }

    @Override
    public void serviceDeactivated(IoService arg0) throws Exception {
    }

    @Override
    public void serviceIdle(IoService arg0, IdleStatus arg1) throws Exception {
    }

    @Override
    public void sessionClosed(IoSession arg0) throws Exception {
        Log.d("", "hahahaha");
    }

    @Override
    public void sessionCreated(IoSession arg0) throws Exception {
    }

    @Override
    public void sessionDestroyed(IoSession arg0) {
        ClientConnectManager.getInstance().rePeatConnect();
    }

    /*
     * 断线重连操作
     * @param content
     */
//    public void repeatConnect(String content) {
//        // 执行到这里表示Session会话关闭了，需要进行重连,我们设置每隔3s重连一次,如果尝试重连5次都没成功的话,就认为服务器端出现问题,不再进行重连操作
//        int count = 0;// 记录尝试重连的次数
//        boolean isRepeat = false;
//        while (!isRepeat && count <= 10) {
//            try {
//                count++;// 重连次数加1
//                ConnectFuture future = connector.connect(new InetSocketAddress(
//                        ConnectUtils.HOST, ConnectUtils.PORT));
//                future.awaitUninterruptibly();// 一直阻塞住等待连接成功
//                IoSession session = future.getSession();// 获取Session对象
//                if (session.isConnected()) {
//                    isRepeat = true;
//                    // 表示重连成功
//                    System.out.println(content + ConnectUtils.stringNowTime() + " : 断线重连" + count
//                            + "次之后成功.....");
//                    SessionManager.getInstance().setSeesion(session);
//                    SessionManager.getInstance().writeToServer("重新连接的");
//                    break;
//                }
//            } catch (Exception e) {
//                if (count == ConnectUtils.REPEAT_TIME) {
//                    System.out.println(content + ConnectUtils.stringNowTime() + " : 断线重连"
//                            + ConnectUtils.REPEAT_TIME + "次之后仍然未成功,结束重连.....");
//                    break;
//                } else {
//                    System.out.println(content + ConnectUtils.stringNowTime() + " : 本次断线重连失败,3s后进行第" + (count + 1) + "次重连.....");
//                    try {
//                        Thread.sleep(3000);
//                        System.out.println(content + ConnectUtils.stringNowTime() + " : 开始第" + (count + 1) + "次重连.....");
//                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
}
