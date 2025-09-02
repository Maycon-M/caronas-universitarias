package br.edu.iff.ccc.caronas.controller.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.ccc.caronas.entities.UserSystem;
import br.edu.iff.ccc.caronas.services.UserSystemService;

@Controller
public class AuthViewController {

    private final UserSystemService users;

    public AuthViewController(UserSystemService users) {
        this.users = users;
    }

    @GetMapping("/login")    public String loginPage()    { return "login"; }
    @GetMapping("/register") public String registerPage() { return "register"; }

    @PostMapping("/register")
    public String doRegister(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String confirmPassword,
                             @RequestParam String role,
                             HttpSession session) {
        if (!password.equals(confirmPassword)) {
            // ideal: redirecionar com erro (querystring/flash). Por agora:
            throw new IllegalArgumentException("Senha e confirmação não conferem");
        }
        UserSystem u = users.register(name, email, password, role);

        // auto-login
        session.setAttribute("authUserEmail", u.getEmail());
        session.setAttribute("authUserName",  u.getName());
        session.setAttribute("authUserRole",  u.getRole());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email,
                          @RequestParam String password,
                          HttpSession session) {
        UserSystem u = users.authenticate(email, password);
        session.setAttribute("authUserEmail", u.getEmail());
        session.setAttribute("authUserName",  u.getName());
        session.setAttribute("authUserRole",  u.getRole());
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/perfil")
    public String perfil() { return "perfil"; }
}

