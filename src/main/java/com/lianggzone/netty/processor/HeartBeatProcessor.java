package com.lianggzone.netty.processor;

import io.netty.channel.ChannelHandlerContext;

import org.springframework.stereotype.Component;

import com.lianggzone.netty.entity.ProtocolModule.CommonProtocol;

/**
 * <h3>概要:</h3><p>HeartBeatProcessor</p>
 * <h3>功能:</h3><p>心跳包</p>
 * <h3>履历:</h3>
 * <li>2017年1月18日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@Component
public class HeartBeatProcessor implements IProcessor {

    @Override
    public void excute(ChannelHandlerContext ctx, CommonProtocol msg) throws Exception {
        System.out.println("返回心跳包给客户端");
        
    }
}
