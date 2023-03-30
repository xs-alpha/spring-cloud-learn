package com.atguigu.spring.impl;

import com.atguigu.spring.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.UUID;

/**
 * @author: lpy
 * @Date: 2023/03/27
 */

/**
 *
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel messageChannel;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(s).build();
        messageChannel.send(build);
        return null;
    }
}
