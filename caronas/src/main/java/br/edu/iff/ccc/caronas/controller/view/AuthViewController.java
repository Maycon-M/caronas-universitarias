package br.edu.iff.ccc.caronas.controller.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/login")
    public String doLoginStub(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session) {
        // TODO: validar usuário no banco (depois)
        session.setAttribute("authUserEmail", email);
        session.setAttribute("authUserName", email.split("@")[0]); // só pra exibir algo
        return "redirect:/home";
    }

    @PostMapping("/register")
    public String doRegisterStub(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String confirmPassword,
                                 @RequestParam String role,
                                 HttpSession session) {
        // TODO: persistir User no banco e hashear senha
        session.setAttribute("authUserEmail", email);
        session.setAttribute("authUserName", name);
        session.setAttribute("authUserRole", role);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "perfil"; 
    }
}
