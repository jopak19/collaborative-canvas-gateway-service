package br.ufrn.dimap.collaborativecanvas.gatewayservice.model.playerservice;

public class PlayerDTO {

    private Long id;
    private String name;
    private String password;
    private int paintedPixels;


    public PlayerDTO(Long id) {
        this.id = id;
    }

    public PlayerDTO(Long id, String name, String password, int paintedPixels) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.paintedPixels = paintedPixels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPaintedPixels() {
        return paintedPixels;
    }

    public void setPaintedPixels(int paintedPixels) {
        this.paintedPixels = paintedPixels;
    }
}
