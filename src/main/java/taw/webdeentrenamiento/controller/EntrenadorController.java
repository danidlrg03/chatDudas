package taw.webdeentrenamiento.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taw.webdeentrenamiento.dao.RolRepository;
import taw.webdeentrenamiento.dao.UsuarioRepository;
import taw.webdeentrenamiento.entity.Rol;
import taw.webdeentrenamiento.entity.Usuario;

import java.util.List;


@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {

    @Autowired
    protected UsuarioRepository usuarioRepository;
    @Autowired
    protected RolRepository rolRepository;

    @GetMapping("/")
    public String index(Model model){
        return "entrenador/index";
    }

    @GetMapping("clientesAsignados")
    public String doTablaClientes(Model model, HttpSession session) {
        List<Usuario> usuarios = usuarioRepository.findUsuariosByRolId(2); //(int) session.getAttribute("id")
        model.addAttribute("usuarios", usuarios);

        return "entrenador/gestion-clientes/clientesAsignados";
    }

    @GetMapping("/cliente")
    public String doCliente(@RequestParam("usuario_id") Integer usuario_id, Model model) {
        Usuario usuario = usuarioRepository.findById(usuario_id).get();
        model.addAttribute("usuario", usuario);
        return "entrenador/gestion-clientes/cliente";
    }
}

