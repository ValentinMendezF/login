package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controladoraPersistencia;

    public ControladoraLogica() {
        controladoraPersistencia = new ControladoraPersistencia();
    }

    public boolean validarUsuario(String usuario, String contrasenia) {
        //String mensaje = "";
        boolean ok = false;
        List<Usuario> listaUsuarios = traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)){
                if (usu.getContrasenia().equals(contrasenia)){
                    //mensaje = "Usuario y contraseña correctos.";
                    ok = true;
                    return ok;
                } else{
                    //mensaje = "Contraseña incorrecta.";
                    ok = false;
                    return ok;
                }
            } else{
                //mensaje = "Usuario no encontrado.";
                ok = false;
            }

        }
        return ok;
    }

    private List<Usuario> traerUsuarios() {
        return controladoraPersistencia.traerUsuarios();
    }

    public String validarRol(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
