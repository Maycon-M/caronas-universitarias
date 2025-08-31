package br.edu.iff.ccc.caronas.services;

import br.edu.iff.ccc.caronas.entities.UserSystem;
import br.edu.iff.ccc.caronas.repository.UserSystemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSystemService {
    private final UserSystemRepository repo;

    public UserSystemService(UserSystemRepository repo) {
        this.repo = repo;
    }

    public List<UserSystem> listarTodos() {
        return repo.findAll();
    }

    public UserSystem salvar(UserSystem u) {
        return repo.save(u);
    }
}
