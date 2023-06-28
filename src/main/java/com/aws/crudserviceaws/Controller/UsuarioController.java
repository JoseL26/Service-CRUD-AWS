package com.aws.crudserviceaws.Controller;

import com.aws.crudserviceaws.Model.Usuario;
import com.aws.crudserviceaws.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<Usuario> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    }

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "{id}")
    public Optional<Usuario> obtenerPorID(@PathVariable("id") Integer id){
        return usuarioService.obtenerUsuarioPorID(id);
    }

    @PutMapping(path = "/{id}")
    public Usuario actualizarUsuarioPorID(@RequestBody Usuario request, @PathVariable("id") Integer id){
        return usuarioService.actualizarUsuarioPorID(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id " + id + " con éxito";
        }else {
            return "No se puede eliminar el usuario con id " + id;
        }
    }
}
