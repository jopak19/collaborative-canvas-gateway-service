package br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice;

public class UpdatePlayerDTO {

    private long id;

    private PlayerDTO player;

    public UpdatePlayerDTO() {
    }

    public UpdatePlayerDTO(long id, PlayerDTO player) {
        this.id = id;
        this.player = player;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
