package libroswebapp.controller;

import jakarta.servlet.http.HttpSession;
import libroswebapp.dao.*;
import libroswebapp.entity.*;
import libroswebapp.ui.Filtro;
import libroswebapp.ui.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController extends BaseController {

    @Autowired
    protected LibroRepository libroRepository;

    @Autowired
    protected EscritorRepository escritorRepository;

    @Autowired
    protected EditorialRepository editorialRepository;

    @Autowired
    protected GeneroRepository generoRepository;

    @GetMapping("/")
    public String doListar (Model model, HttpSession session) {
        String strTo = "listado";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else {
            List<LibroEntity> lista = this.libroRepository.findAll();
            model.addAttribute("lista", lista);
            model.addAttribute("filtro", new Filtro());
        }
        return strTo;
    }

    @PostMapping("/filtrar")
    public String doListar (@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session) {
        String strTo = "listado";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else if (filtro.estaVacio()) {
            strTo = "redirect:/libros/";
        } else {
            List<LibroEntity> lista = this.libroRepository.buscarPorPalabraEnTituloYAno(filtro.getTitulo(), filtro.getShortAnyo());
            model.addAttribute("lista", lista);
            model.addAttribute("filtro", filtro);
        }

        return strTo;
    }


    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {
        String strTo = "redirect:/libros/";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else {
            this.libroRepository.deleteById(id);
        }
        return strTo;
    }

    private void inicializarEscritoresEditorialesGeneros (Model model) {
        List<EscritorEntity> escritores = this.escritorRepository.findAll();
        model.addAttribute("escritores", escritores);

        List<EditorialEntity> editoriales = this.editorialRepository.findAll();
        model.addAttribute("editoriales", editoriales);

        List<GeneroEntity> generos = this.generoRepository.findAll();
        model.addAttribute("generos", generos);
    }


    @GetMapping("/crear")
    public String doNuevo (Model model, HttpSession session) {
        String strTo = "libro";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else {
            Libro libro = new Libro();
            libro.setLibroid(-1);
            model.addAttribute("libro", libro);

            this.inicializarEscritoresEditorialesGeneros(model);
        }

        return strTo;
    }

    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer id, Model model, HttpSession session) {
        String strTo = "libro";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else {

            LibroEntity libro = this.libroRepository.findById(id).orElse(null);

            Libro libroDTO = new Libro();
            libroDTO.setLibroid(libro.getLibroid());
            libroDTO.setLibroname(libro.getLibroname());
            libroDTO.setYearreleased(libro.getYearreleased());
            List<Integer> listaEscritores = new ArrayList<>();
            for (EscritorEntity escritorEntity: libro.getEscritorList()) {
                listaEscritores.add(escritorEntity.getEscritorid());
            }
            libroDTO.setIdescritores(listaEscritores);

            List<Integer> listaGeneros = new ArrayList<>();
            for (GeneroEntity generoEntity: libro.getGeneroList()) {
                listaGeneros.add(generoEntity.getGeneroid());
            }
            libroDTO.setIdgeneros(listaGeneros);

            libroDTO.setIdeditorial(libro.getEditorialid().getEditorialid());

            model.addAttribute("libro", libroDTO);

            this.inicializarEscritoresEditorialesGeneros(model);
        }

        return strTo;
    }


    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("libro") Libro elibro, HttpSession session) {

        String strTo = "redirect:/libros/";
        if (estaAutenticado(session) == false) {
            strTo = "redirect:/";
        } else {
            LibroEntity libro = this.libroRepository.findById(elibro.getLibroid()).orElse(new LibroEntity());
            libro.setLibroname(elibro.getLibroname());
            libro.setYearreleased(elibro.getYearreleased());
            libro.setEscritorList(this.escritorRepository.findAllById(elibro.getIdescritores()));
            libro.setGeneroList(this.generoRepository.findAllById(elibro.getIdgeneros()));
            libro.setEditorialid(this.editorialRepository.findById(elibro.getIdeditorial()).orElse(null));
            //libro.setEscritorList(escritores);
            //libro.setEditorialid(editorial);
            //libro.setGeneroList(generos);
            this.libroRepository.save(libro);
        }

        return strTo;
    }

}
