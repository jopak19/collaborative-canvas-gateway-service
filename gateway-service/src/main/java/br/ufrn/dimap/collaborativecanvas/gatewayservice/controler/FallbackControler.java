package br.ufrn.dimap.collaborativecanvas.gatewayservice.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackControler {

    @GetMapping("/playerServiceFallBack")
    public ResponseEntity<String> playerServiceFallBack(){
        return ResponseEntity.status(503).body("Serviço player indisponível");
    }

    @GetMapping("/canvaServiceFallBack")
    public ResponseEntity<String> canvaServiceFallBack(){
    	return ResponseEntity.status(503).body("Serviço canva indisponível");
    }

    @PostMapping("/gameServiceFallBack")
    public ResponseEntity<String> gameServiceFallBack(){
    	return ResponseEntity.status(503).body("Serviço game indisponível");
    }
}
