package br.edu.iff.ccc.caronas.services;

import br.edu.iff.ccc.caronas.entities.UserSystem;
import br.edu.iff.ccc.caronas.repository.UserSystemRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSystemService {
    private final UserSystemRepository repo;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserSystemService(UserSystemRepository repo) {
        this.repo = repo;
    }

    public List<UserSystem> listarTodos() {
        return repo.findAll();
    }

    public UserSystem salvar(UserSystem u) {
        return repo.save(u);
    }

    public UserSystem register(String name, String email, String rawPassword, String role) {
        if (repo.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        UserSystem u = new UserSystem();
        u.setName(name);
        u.setEmail(email);
        u.setPasswordHash(encoder.encode(rawPassword));
        u.setRole(role);
        u.setStatus("ATIVO");
        return repo.save(u);
    }

    public UserSystem authenticate(String email, String rawPassword) {
        UserSystem u = repo.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        if (!encoder.matches(rawPassword, u.getPasswordHash())) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }
        return u;
    }
}
