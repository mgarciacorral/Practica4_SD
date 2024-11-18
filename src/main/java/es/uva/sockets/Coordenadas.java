package es.uva.sockets;

public class Coordenadas {
    private final int x;
    private final int y;

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordenadas mover(Direccion dir){
        //TODO: Devolver unas coordenadas movidas según direccion
        return this;
    }

    public boolean equals(Coordenadas otras) {
        return (this.x == otras.x) && (this.y == otras.y);
    }
}
