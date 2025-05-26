package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controladoraPersistencia;

    public ControladoraLogica() {
        controladoraPersistencia = new ControladoraPersistencia();
    }

    public String validarUsuario(String usuario, String contrasenia) {
        String mensaje = "";
        List<Usuario> listaUsuarios = traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)){
                if (usu.getContrasenia().equals(contrasenia)){
                    mensaje = "Usuario y contraseña correctos.";
                    return mensaje;
                } else{
                    mensaje = "Contraseña incorrecta.";
                    return mensaje;
                }
            } else{
                mensaje = "Usuario no encontrado.";
            }

        }
        return mensaje;
    }

    private List<Usuario> traerUsuarios() {
        return controladoraPersistencia.traerUsuarios();
    }

}
