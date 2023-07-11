package br.ufrn.dimap.collaborativecanvas.gatewayservice.model.gameservice;

public class GameServicePlayDTO {

    private Long pixelId;
    private Long playerId;
    private Long canvasId;
    private String color;

    public GameServicePlayDTO() {
    }

    public GameServicePlayDTO(Long pixelId, Long playerId, Long canvasId, String color) {
        this.pixelId = pixelId;
        this.playerId = playerId;
        this.canvasId = canvasId;
        this.color = color;
    }

    public Long getPixelId() {
        return pixelId;
    }

    public void setPixelId(Long pixelId) {
        this.pixelId = pixelId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public void setCanvasId(Long canvasId) {
        this.canvasId = canvasId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
