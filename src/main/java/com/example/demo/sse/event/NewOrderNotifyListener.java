package com.example.demo.sse.event;

import com.example.demo.sse.entity.MessageBody;
import org.springframework.context.ApplicationListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Dax
 * @since 13:58  2019/8/22
 */
@Component
public class NewOrderNotifyListener implements ApplicationListener<NewOrderNotifyEvent> {


    @Override
    public void onApplicationEvent(NewOrderNotifyEvent event) {
        MessageBody messageBody = event.getMessageBody();
        messageBody.setTimestamp(event.getTimestamp());
        SseEmitter.SseEventBuilder sseEvent = SseEmitter.event();
        sseEvent.data(messageBody, MediaType.APPLICATION_JSON_UTF8)
                .id("11111")
                .name("message")
                .comment("comment");

        Optional.of(event.getSseEmitter()).ifPresent(sseEmitter -> {
            try {
                sseEmitter.send(messageBody,MediaType.APPLICATION_JSON_UTF8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
