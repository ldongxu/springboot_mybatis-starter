package com.example.demo.sse.event;

import com.example.demo.sse.entity.MessageBody;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author Dax
 * @since 13:50  2019/8/22
 */
public class NewOrderNotifyEvent extends ApplicationEvent {
    private MessageBody messageBody;
    private SseEmitter sseEmitter;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private NewOrderNotifyEvent(Object source) {
        super(source);
    }

    public NewOrderNotifyEvent(Object source, MessageBody messageBody, SseEmitter sseEmitter) {
        this(source);
        this.messageBody = messageBody;
        this.sseEmitter = sseEmitter;
    }

    public SseEmitter getSseEmitter() {
        return sseEmitter;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }
}
