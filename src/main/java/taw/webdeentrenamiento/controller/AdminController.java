package taw.webdeentrenamiento.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taw.webdeentrenamiento.dao.RolRepository;
import taw.webdeentrenamiento.dao.UsuarioRepository;
import taw.webdeentrenamiento.entity.Rol;
import taw.webdeentrenamiento.entity.Usuario;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
    protected UsuarioRepository usuarioRepository;
    @Autowired
    protected RolRepository rolRepository;

	@GetMapping("/")
    public String index(Model model){
        return "admin/index";
    }

	@GetMapping("usuarios")
    public String showTablaUsuarios(Model model, HttpSession session) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "admin/tablaUsuarios";
    }
	@GetMapping("user")
    public String showUser(@RequestParam("id") int id ,Model model, HttpSession session) {
        Usuario user = usuarioRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
		model.addAttribute("roles", (List<Rol>) rolRepository.findAll());
        return "admin/user";
    }

	@GetMapping("nuevoUsuario")
    public String nuevoUsuario(Model model, HttpSession session) {
        Usuario user = new Usuario();
        model.addAttribute("user", user);
		List<Rol> roles = rolRepository.findAll();
		model.addAttribute("roles",roles);
        return "admin/crearUsuario";
    }

	@PostMapping("guardarUsuario")
    public String guardarUsuario(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("peso") Integer peso,
            @RequestParam("altura") Integer altura,
            @RequestParam("edad") Integer edad,
			@RequestParam("rol") Rol rol){
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPeso(peso);
        usuario.setAltura(altura);
        usuario.setEdad(edad);
		usuario.setContrasena("123");
		usuario.setRol(rol);
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuarios";
    }

    @PostMapping("actualizarUsuario")
public String actualizarUsuario(
        @RequestParam("id") Integer id,
        @RequestParam("nombre") String nombre,
        @RequestParam("email") String email,
        @RequestParam("peso") Integer peso,
        @RequestParam("altura") Integer altura,
        @RequestParam("edad") Integer edad,
        @RequestParam("rol") Integer rolId,
        Model model) {
    Usuario usuario = usuarioRepository.findById(id).orElse(null);
    assert usuario != null;
    usuario.setNombre(nombre);
    usuario.setEmail(email);
    usuario.setPeso(peso);
    usuario.setAltura(altura);
    usuario.setEdad(edad);

    Rol rol = rolRepository.findById(rolId).orElse(null);
    usuario.setRol(rol);

    usuarioRepository.save(usuario);

    model.addAttribute("user", usuario);
    return "redirect:/admin/user?id=" + id;
}

	@GetMapping("asignar")
    public String asignar(Model model, HttpSession session) {
        List<Usuario> clientes = usuarioRepository.findUsuariosByRolId(5);
        List<Usuario> entrenadores = new ArrayList<>();
		entrenadores.addAll(usuarioRepository.findUsuariosByRolId(2));
		entrenadores.addAll(usuarioRepository.findUsuariosByRolId(3));
		List<Usuario> dietista = usuarioRepository.findUsuariosByRolId(4);


        model.addAttribute("clientes", clientes);
        model.addAttribute("entrenadores", entrenadores);
        model.addAttribute("dietista", dietista);

        return "admin/asignar";
    }


	@PostMapping("/asignarCliente")
	public String asignarCliente(
        @RequestParam("clienteId") Integer clienteId,
        @RequestParam("entrenadorId") Integer entrenadorId,
        @RequestParam("dietistaId") Integer dietistaId,
        Model model) {

	    Usuario cliente = usuarioRepository.findById(clienteId).orElse(null);
		Usuario entrenador = usuarioRepository.findById(entrenadorId).orElse(null);
		Usuario dietista = usuarioRepository.findById(dietistaId).orElse(null);




    return "redirect:/asignar";
}

	@GetMapping("deleteUser")
	public String deleteUser(@RequestParam("id") Integer id, Model model) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		assert usuario != null;
		usuarioRepository.delete(usuario);
		return "redirect:/admin/usuarios";
	}

}
