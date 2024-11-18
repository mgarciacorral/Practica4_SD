package es.uva.sockets;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ServidorJuego {
    // El juego consiste en encontrar un tesoro
    // en un mapa cuadriculado, cuando un jugador
    // se conecta aparece en un cuadrado aleatorio
    // no ocupado.
    // El _PROTOCOLO_ del cliente, la manera en que
    // se comunica con el servidor es el siguiente
    // MOVE UP|DOWN|LEFT|RIGHT
    // DIG
    // EL Servidor Verifica la validez de los movimientos
    // Los aplica sobre su estado y envía la actualización
    // A todos los jugadores.
    // EL _PROTOCOLO_ con el que el servidor comunica las
    // actualizaciones a los clientes es el siguiente
    // PLAYER JOIN <PLAYER-ID> <X> <Y>
    // MOVE UP|DOWN|LEFT|RIGHT <PLAYER-ID>
    // DIG <PLAYER-ID> <SUCCESS>
    // El delimitador de lo que constituye un mensaje es
    // un caracter de salto de linea

    public final Estado estado;
    public final ServerSocket serverSocket;
    private final List<ManagerCliente> clientes;

    public ServidorJuego(int size, int puerto) throws IOException {
        estado = new Estado(size);
        clientes = new ArrayList<>();
        // Crear un serverSocket que acepte
        // conexiones de VARIOS clientes
        serverSocket = new ServerSocket(puerto);
    }

    public void iniciar() throws IOException {
        while (!estado.estaTerminado()) {
            ManagerCliente nuevo = aceptarConexion();
            clientes.add(nuevo);
            nuevo.start();
        }

    }

    public ManagerCliente aceptarConexion() throws IOException{
        // TODO: Usando el serverSocket
        // Al añadir un nuevo jugador se le deben enviar
        // la posicion de los jugadores existentes, aunque no
        // sabe donde han estado buscando.
    }

    public synchronized void broadcast(String message) {
        // TODO: Enviar un mensaje a todos los clientes
    }

}
