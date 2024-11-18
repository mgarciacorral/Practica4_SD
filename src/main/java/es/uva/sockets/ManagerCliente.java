package es.uva.sockets;

public class ManagerCliente extends Thread {
    // Clase para que el encargado de cada cliente
    // Se ejecute en un hilo diferente

    private final Socket socket;
    private final ServidorJuego servidor;
    private final int idJugador;
    // Se pueden usar mas atributos ...

    public ManagerCliente(Socket socket, ServidorJuego servidor, int idJugador) {
        this.socket = socket;
        this.servidor = servidor;
        this.idJugador = idJugador;
        // Se pueden usar mas atributos ...
    }

    public void enviarMensaje(String message) {
        // TODO: enviar un mensaje. NOTA: a veces hace falta usar flush.
    }

    @Override
    public void run() {
        // Mantener todos los procesos necesarios hasta el final
        // de la partida (alguien encuentra el tesoro)
        while (!servidor.estado.estaTerminado() && !socket.isClosed()) {
            procesarMensajeCliente();
        }
    }

    public void procesarMensajeCliente() {
        // TODO: leer el mensaje del cliente
        // y procesarlo usando interpretarMensaje
        // Si detectamos el final del socket
        // gestionar desconexion ...
    }

    public void interpretarMensaje(String mensaje) {
        // TODO: Esta función debe realizar distintas
        // Acciones según el mensaje recibido
        // Manipulando el estado del servidor
        // Si el mensaje recibido no tiene el formato correcto
        // No ocurre nada
    }
}