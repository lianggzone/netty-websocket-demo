package com.lianggzone.netty.processor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lianggzone.netty.common.constrants.ProtocolConstants;

/**
 * <h3>概要:</h3><p>TaskManager</p>
 * <h3>功能:</h3><p>任务管理</p>
 * <h3>履历:</h3>
 * <li>2017年1月18日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@Component
public class TaskManager {

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
    
    private static TaskManager instance;

    public Map<Integer, IProcessor> taskMap = new HashMap<Integer, IProcessor>();

    public static TaskManager getInstance() {
        return instance;
    }

    public IProcessor getTask(int operation) {
        return taskMap.get(operation);
    }

    /**
     * 初始化处理过程
     */
    @PostConstruct
    private void init() {
        logger.info("init task manager");
        instance = new TaskManager();
        // 心跳任务
        instance.taskMap.put(ProtocolConstants.HEART_BEAT, new HeartBeatProcessor());
        
    }
}
