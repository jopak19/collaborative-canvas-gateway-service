package br.ufrn.dimap.collaborativecanvas.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CanvasServiceController {

    private final StreamBridge streamBridge;

    public CanvasServiceController(@Autowired StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

}
