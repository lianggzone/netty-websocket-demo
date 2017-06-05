package com.lianggzone.netty.server.handle;

import com.lianggzone.netty.entity.ProtocolModule;
import com.lianggzone.netty.processor.IProcessor;
import com.lianggzone.netty.processor.TaskManager;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <h3>概要:</h3><p>TcpServerHandler</p>
 * <h3>功能:</h3><p>TcpServerHandler</p>
 * <h3>履历:</h3>
 * <li>2017年1月18日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@Component
@ChannelHandler.Sharable
public class TcpServerHandler extends SimpleChannelInboundHandler<ProtocolModule.CommonProtocol> {

    private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler.class);

    /**
     * 客户端与服务端会话连接成功
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("客户端与服务端会话连接成功");
    }

    /**
     * 服务端接收到客户端消息
     */
    @Override
	protected void channelRead0(ChannelHandlerContext ctx, ProtocolModule.CommonProtocol msg) throws Exception {
        System.out.println(msg);
        Integer commandId = msg.getCommHeader().getCommandId();
        if (commandId != null) {
            IProcessor task = TaskManager.getInstance().getTask(commandId);
            if (task != null) {
                task.excute(ctx, msg);
            } else {
                logger.error("not found command_id: " + msg.getCommHeader().getCommandId());
            }
        }else{
            logger.error("not found command_id");
        }
	}	

    /**
     * 服务端监听到客户端异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("服务端监听到客户端异常");
    }
   
    /**
     * 客户端与服务端会话连接断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    	super.channelInactive(ctx);
    	System.out.println("客户端与服务端会话连接断开");
    } 
}