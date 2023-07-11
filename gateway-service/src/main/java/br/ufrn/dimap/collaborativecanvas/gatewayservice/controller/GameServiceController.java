package br.ufrn.dimap.collaborativecanvas.gatewayservice.controller;

import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.gameservice.GameServicePlayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/play")
public class GameServiceController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> play(@RequestBody GameServicePlayDTO data) {
        streamBridge.send("game-in", data);
        return Mono.just("request sent");
    }
}
