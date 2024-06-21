package taw.webdeentrenamiento.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taw.webdeentrenamiento.dao.RolRepository;
import taw.webdeentrenamiento.dao.UsuarioRepository;
import taw.webdeentrenamiento.entity.Rol;
import taw.webdeentrenamiento.entity.Usuario;

import java.util.Optional;

@Controller
public class MainControler {

    @Autowired
    protected UsuarioRepository usuarioRepository;
    @Autowired
    protected RolRepository rolRepository;

    @GetMapping("/")
    public String doLogin(Model model, HttpSession session) {
        if (estaAutenticado(session))
            return whichView((Integer) session.getAttribute("rol"));
        return "login";
    }


    @PostMapping("/login")
    public String doAutenticar(HttpSession session, @RequestParam("usuario") String nombreUsuario, @RequestParam("contrasena") String password, Model model) {
        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioRepository.findUsuarioByNombreAndContrasena(nombreUsuario, password));
        if (!optionalUsuario.isPresent()) {
            model.addAttribute("error", true);
            return "login";
        }
        session.setAttribute("usuario", optionalUsuario.get());
        session.setAttribute("rol", optionalUsuario.get().getRol().getId());
        return whichView(optionalUsuario.get().getRol().getId());
    }


    private String whichView(int rol) {
        switch (rol) {
            case 1:
                return "redirect:/administrador/";
            case 2, 3:
                return "redirect:/entrenador/";
            case 4:
                return "redirect:/dietista/";
            case 5:
                return "redirect:/cliente/";
            default:
                throw new IllegalArgumentException("Rol no válido: " + rol);
        }
    }

    private boolean estaAutenticado(HttpSession session) {
        return session.getAttribute("usuario") != null;
    }

}



