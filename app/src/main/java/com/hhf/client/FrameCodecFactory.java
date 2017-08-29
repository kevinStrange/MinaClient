package com.hhf.client;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created by huanghongfa on 2017/7/28.
 */

public class FrameCodecFactory implements ProtocolCodecFactory{
    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return new FrameEncoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return new FrameDecoder();
    }
}
