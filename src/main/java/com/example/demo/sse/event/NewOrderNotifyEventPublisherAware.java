package com.example.demo.sse.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * The type New order notify event publisher aware.
 *
 * @author Dax
 * @since 13 :53  2019/8/22
 */
@Component
public class NewOrderNotifyEventPublisherAware implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 推送通知事件.
     *
     * @param newOrderNotifyEvent the new order notify event
     */
    public void publish(NewOrderNotifyEvent newOrderNotifyEvent) {
        applicationEventPublisher.publishEvent(newOrderNotifyEvent);
    }

}
