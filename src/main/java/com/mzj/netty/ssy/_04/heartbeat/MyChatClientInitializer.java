package com.mzj.netty.ssy._04.heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * 客户端Channel初始化器
 *
 * @Auther: mazhongjia
 * @Date: 2019/8/14 17:29
 * @Description:
 */
public class MyChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipline = ch.pipeline();

        pipline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));//分隔符解码器
        pipline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipline.addLast(new MyChatClientHandler());

    }
}
