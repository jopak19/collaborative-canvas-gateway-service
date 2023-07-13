package br.ufrn.dimap.collaborativecanvas.gatewayservice.controller;

import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.canvasservice.CreateCanvasDTO;
import br.ufrn.dimap.collaborativecanvas.gatewayservice.model.canvasservice.GetLastHistoriesDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/canvas")
public class CanvasServiceController {

    private final StreamBridge streamBridge;

    public CanvasServiceController(@Autowired StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getCanvasByLink(@RequestParam("link") @NotNull String link) {
        System.out.println("getCanvasByLink");
        streamBridge.send("canvas-getByLink-in", link);
        return Mono.just("request received");
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getCanvasById(@PathVariable @NotNull Long id) {
        System.out.println("getCanvasById");
        streamBridge.send("canvas-getById-in", id);
        return Mono.just("request received");
    }

    @GetMapping(value="/last-histories", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getLastNHistories(@RequestParam @NotNull Long canvasId, @RequestParam @NotNull Integer n){
        System.out.println("getLastNHistories");
        streamBridge.send("canvas-getLastNHistories-in", new GetLastHistoriesDTO(canvasId, n));
        return Mono.just("request received");
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Mono<String> createCanvas(@RequestBody @NotNull CreateCanvasDTO createCanvasDTO) {
        System.out.println("createCanvas");
        if (createCanvasDTO.name() == null || createCanvasDTO.creatorId() == null) {
            return Mono.empty();
        }
        streamBridge.send("canvas-create-in", createCanvasDTO);
        return Mono.just("request received");
    }

    /*
    @GetMapping(value="/last-histories/update", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> getLastNHistoriesWithUpdates(
            @RequestParam @NotNull Long canvasId, @RequestParam @NotNull Integer n){
        return historyService.getTopNHistoriesFromCanvasWithUpdates(canvasId, n);
    }

     */

    @GetMapping(value="/top",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Mono<String> getTop(@RequestParam @NotNull Integer n){
        System.out.println("getTop");
        streamBridge.send("canvas-top-in", n);
        return Mono.just("request received");
    }

}
