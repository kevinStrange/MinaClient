package com.hhf.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 * Created by huanghongfa on 2017/7/28.
 */

public class FrameDecoder extends CumulativeProtocolDecoder {


    private final static Charset charset = Charset.forName("UTF-8");
    // 可变的IoBuffer数据缓冲区
    private IoBuffer buff = IoBuffer.allocate(100).setAutoExpand(true);

    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        // 如果有消息
        while (ioBuffer.hasRemaining()) {
            // 判断消息是否是结束符，不同平台的结束符也不一样；
            // windows换行符（\r\n）就认为是一个完整消息的结束符了； UNIX 是\n；MAC 是\r
            byte b = ioBuffer.get();
            if (b == '\n') {
                buff.flip();
                byte[] bytes = new byte[buff.limit()];
                buff.get(bytes);
                String message = new String(bytes, charset);
                buff = IoBuffer.allocate(100).setAutoExpand(true);
                // 如果结束了，就写入转码后的数据
                protocolDecoderOutput.write(message);
            } else {
                buff.put(b);
            }
        }
        return false;
    }
}
