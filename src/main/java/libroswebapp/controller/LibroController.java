package libroswebapp.controller;

import libroswebapp.dao.LibroRepository;
import libroswebapp.entity.LibroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibroController {


    @Autowired
    protected LibroRepository libroRepository;

    @GetMapping("/")
    public String doListar (Model model) {
        List< LibroEntity> lista = this.libroRepository.findAll();
        model.addAttribute("lista", lista);
        return "listado";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id) {

        // Faltaría todavía añadir la lógica correspondiente a esta parte!!!!

        return "";
    }

}
