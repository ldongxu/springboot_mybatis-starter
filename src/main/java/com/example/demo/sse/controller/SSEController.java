package com.example.demo.sse.controller;

import com.example.demo.sse.entity.MessageBody;
import com.example.demo.sse.event.NewOrderNotifyEvent;
import com.example.demo.sse.event.NewOrderNotifyEventPublisherAware;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class SSEController {
    private final Map<String, SseEmitter> sseEmitters = new HashMap<>();

    @RequestMapping(path = "/events/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public SseEmitter push(@PathVariable String id){
        SseEmitter sseEmitter = new SseEmitter(5*60*1000L);
        this.sseEmitters.put(id, sseEmitter);
        sseEmitter.onTimeout(() -> {
            System.out.println(id+" timeout");
            sseEmitters.remove(id);
        });
        sseEmitter.onCompletion(()->{
            System.out.println(id+" completion");
        });
        return sseEmitter;
    }

    @GetMapping("/send/{id}")
    @ResponseBody
    public void send(@PathVariable String id){
        Map<String, String> map = new HashMap<>(1);

        map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        MessageBody<Map<String, String>> body = new MessageBody<>();

        body.setFrom("SERVER");
        body.setTo(id);
        body.setPayload(map);

        Optional.ofNullable(sseEmitters.get(id)).ifPresent(sseEmitter -> {
            try {
                sseEmitter.send("sse req success");
                sseEmitter.send(SseEmitter.event().name("test"+id).id(id).data(body));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @RequestMapping("/send/all")
    @ResponseBody
    public void sendAll(){
        System.out.println("sseEmitters size:"+this.sseEmitters.size());
        this.sseEmitters.forEach((s, sseEmitter) -> {
            Map<String, String> map = new HashMap<>(1);

            map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

            MessageBody<Map<String, String>> body = new MessageBody<>();
            body.setTo(s);
            body.setFrom("SERVER");
            body.setPayload(map);
            try {
                sseEmitter.send(SseEmitter.event().name("test"+s).id(s).data(body, MediaType.APPLICATION_JSON));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }


}
