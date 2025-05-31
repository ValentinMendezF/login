package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controladoraPersistencia;

    public ControladoraLogica() {
        controladoraPersistencia = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        //String mensaje = "";
        Usuario user = null;
        List<Usuario> listaUsuarios = traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    //mensaje = "Usuario y contraseña correctos.";
                    user = usu;
                    return user;
                } else {
                    //mensaje = "Contraseña incorrecta.";
                    user = null;
                    return user;
                }
            } else {
                //mensaje = "Usuario no encontrado.";
                user = null;
            }

        }
        return user;
    }

    public List<Usuario> traerUsuarios() {
        return controladoraPersistencia.traerUsuarios();
    }

    public List<Rol> traerRoles() {
       return controladoraPersistencia.traerRoles();
    }

    public void crearUsuario(String nombreUsuario, String contrasenia, String rolRecibido) {
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = traerRol(rolRecibido);
        if(rolEncontrado != null){
            usuario.setRol(rolEncontrado);
        }
        
        int id = buscarUltimaId();
        
        usuario.setId(id+1);
        
        controladoraPersistencia.crearUsuario(usuario);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controladoraPersistencia.traerRoles();
        
        for(Rol rol : listaRoles){
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaId() {
        List<Usuario> listaUsuarios = traerUsuarios();
        
        Usuario usuario = listaUsuarios.get(listaUsuarios.size()-1);
        return usuario.getId();
    }

    public void eliminarUsuario(int idUsuario) {
        controladoraPersistencia.eliminarUsuario(idUsuario);
    }

    public Usuario traerUsuario(int id_usuario) {
        return controladoraPersistencia.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usuario, String nombreUsuario, String contrasenia, String rolRecibido) {
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = traerRol(rolRecibido);
        if(rolEncontrado != null){
            usuario.setRol(rolEncontrado);
        }
        
        controladoraPersistencia.editarUsuario(usuario);
    }
}
