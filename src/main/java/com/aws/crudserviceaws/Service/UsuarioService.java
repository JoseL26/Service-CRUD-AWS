package com.aws.crudserviceaws.Service;

import com.aws.crudserviceaws.Model.Usuario;
import com.aws.crudserviceaws.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    //en esta parte instanciamos el repositorio creado previamente.
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> obtenerUsuario(){
        //obtenemos todos los datos con .findAll()
        return(ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        //guardamos el usuario con .save(dentro los valores que contiene la variable de tipo usuario)
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorID(Integer id){
        //retornamos el usuario de acuerdo al parametro indicado, en este caso devolverá el usuario según el Id indicado
        return usuarioRepository.findById(id);
    }

    public Usuario actualizarUsuarioPorID(Usuario request, Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setCorreo(request.getCorreo());
        usuarioRepository.save(usuario);
        return usuario;
    }
    public boolean eliminarUsuario(Integer id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
