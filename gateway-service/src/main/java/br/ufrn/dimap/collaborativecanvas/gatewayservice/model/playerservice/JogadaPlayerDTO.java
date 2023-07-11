package br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice;

public class JogadaPlayerDTO {
    private Long id;

    public JogadaPlayerDTO(Long id) {
        this.id = id;
    }

    public JogadaPlayerDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}