package es.uva.sockets;

public class ClienteJuego {
    // La clase cliente tiene las siguientes responsabilidades
    // Unirse al juego conectandose al servidor
    // Mantener un estado de juego actualizado interpretando los
    // mensajes del servidor (y mostrar el estado)
    // Convertir input del jugador en un mensaje que enviar al servidor
    // NOTA: para simplificar el manejo de input podemos considerar
    // que el usario manda cada comando en una linea distinta
    // (aunque sea muy incomodo)

    public final Estado estado;
    // TODO: Faltarán atributos ...

    public ClienteJuego(int size) {
        // [OPCIONAL] TODO: Extiende el protocolo de comunicacion para
        // que el servidor envie el tamaño del mapa tras la conexion
        // de manera que el estado no se instancie hasta entonces
        // y conocer este parametro a priori no sea necesario.
        estado = new Estado(size);
    }

    public void iniciar(String host, int puerto) {
        // Metodo que reune todo y mantiene lo necesario en un bucle
        conectar(host, puerto);
        Thread procesadorMensajesServidor = new Thread(() -> {
            while (!estado.estaTerminado()) {
                procesarMensajeServidor();
            }
        });
        Thread procesadorInput = new Thread(() -> {
            while (!estado.estaTerminado()) {
                procesarInput();
            }
        });
        procesadorMensajesServidor.start();
        procesadorInput.start();
        procesadorInput.join();
        procesadorMensajesServidor.join();
        // Si acaban los hilos es que el juego terminó
        cerrarConexion();
    }

    public void cerrarConexion() {
        // TODO: cierra todos los recursos asociados a la conexion con el servidor
    }

    public void conectar(String host, int puerto) {
        // TODO: iniciar la conexion con el servidor
        // (Debe guardar la conexion en un atributo)
    }

    public void procesarInput() {
        // TODO: Comprueba la entrada estandar y
        // se procesa mediante intrepretar input,
        // Se genera un mensaje que se envia al servidor
    }

    public void procesarMensajeServidor() {
        // TODO: Comprueba la conexion y obtiene un mensaje
        // que se procesa con interpretarMensaje
        // Al recibir la actualizacion del servidor podeis
        // Usar el metodo mostrar del estado
        // Para enseñarlo
    }

    public String interpretarInput(char tecla) {
        // TODO: WASD para moverse, Q para buscar
        // Este metodo debe devolver el comando necesario
        // Que enviar al servidor
        return "";
    }

    public void interpretarMensaje(String mensaje) {
        // TODO: interpretar los mensajes del servidor actualizando el estado
    }
}
