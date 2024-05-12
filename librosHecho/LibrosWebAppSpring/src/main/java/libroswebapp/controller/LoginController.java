package libroswebapp.controller;

import jakarta.servlet.http.HttpSession;
import libroswebapp.dao.AdministradorRepository;
import libroswebapp.entity.AdministradorEntity;
import libroswebapp.entity.LibroEntity;
import libroswebapp.ui.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController extends BaseController {


    @Autowired
    protected AdministradorRepository administradorRepository;

    @GetMapping("/")
    public String doLogin (Model model, HttpSession session) {
        String strTo = "login";
        if (estaAutenticado(session)) {
            strTo = "redirect:/libros/";
        } else {
            model.addAttribute("usuario", new Usuario());
        }
        return strTo;
    }

    @PostMapping("/autenticar")
    public String doAutentica (@ModelAttribute("usuario") Usuario usuario,
                               Model model, HttpSession session) {
        String strTo = "redirect:/libros/";
        AdministradorEntity admin = this.administradorRepository.autentica(usuario.getUser(), usuario.getPassword());
        if (admin == null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            strTo = this.doLogin(model, session);
        } else {
            session.setAttribute("usuario", admin);
        }
        return strTo;
    }


    @GetMapping("/salir")
    public String doSalir (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}
