package com.lianggzone.netty.processor;

import io.netty.channel.ChannelHandlerContext;

import com.lianggzone.netty.entity.ProtocolModule;

/**
 * <h3>概要:</h3><p>ITask</p>
 * <h3>功能:</h3><p>任务接口</p>
 * <h3>履历:</h3>
 * <li>2017年1月18日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
public interface IProcessor {

    /**
     * 执行处理任务	  
     * @param ctx
     * @param msg
     * @throws Exception
     */
    public void excute(ChannelHandlerContext ctx, ProtocolModule.CommonProtocol msg) throws Exception;
}
