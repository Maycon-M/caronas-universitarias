package br.edu.iff.ccc.caronas.controller.view;

import br.edu.iff.ccc.caronas.entities.UserSystem;
import br.edu.iff.ccc.caronas.services.UserSystemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UserViewController {

    private final UserSystemService service;

    public UserViewController(UserSystemService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        model.addAttribute("form", new UserSystem());
        return "usuarios";
    }

    @PostMapping
    public String criar(@Valid @ModelAttribute("form") UserSystem form,
                        BindingResult br,
                        Model model) {
        if (br.hasErrors()) {
            model.addAttribute("usuarios", service.listarTodos());
            return "usuarios";
        }
        if (form.getStatus() == null || form.getStatus().isBlank()) form.setStatus("ATIVO");
        if (form.getRole() == null || form.getRole().isBlank())     form.setRole("USER");

        service.salvar(form);
        return "redirect:/usuarios";
    }
}
