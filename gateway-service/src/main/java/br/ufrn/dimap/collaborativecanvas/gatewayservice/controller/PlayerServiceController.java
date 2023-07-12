package br.ufrn.dimap.collaborativecanvas.gatewayservice.controller;

import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice.LoginDTO;
import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/player")
public class PlayerServiceController {

    private final StreamBridge streamBridge;
    public PlayerServiceController(@Autowired StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE,value="/{id}")
    public Mono<String> getPlayerById(@PathVariable Long id) {
        streamBridge.send("player-getById-in", id);
        return Mono.just("request received");
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getAllPlayers() {
        streamBridge.send("player-getAll-in", "");
        return Mono.just("request received");
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> addPlayer(@RequestBody PlayerDTO player) {
        streamBridge.send("player-create-in", player);
        return Mono.just("request received");

    }

    @PutMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE,value="/{id}")
    public Mono<String> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO player) {
        streamBridge.send("player-update-in", player);
        return Mono.just("request received");
    }

    @DeleteMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/{id}")
    public Mono<String> deletePlayer(@PathVariable Long id) {
        streamBridge.send("player-delete-in", id);
        return Mono.just("request received");
    }


    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE,value="/play")
    public Mono<String> updatePlayerMove(@RequestBody JogadaPlayerDTO jogada) {
        streamBridge.send("player-play-in", jogada);
        return Mono.just("request received");
    }


    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE,value="/login")
    public Mono<String> login(@RequestBody LoginDTO login) {
        System.out.println("login");
        streamBridge.send("player-login-in", login);
        return Mono.just("request received");
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE,value="/ranking")
    public Mono<String> getAllPlayersByRanking() {
        streamBridge.send("player-getAllByRanking-in", "");
        return Mono.just("request received");
    }

}
