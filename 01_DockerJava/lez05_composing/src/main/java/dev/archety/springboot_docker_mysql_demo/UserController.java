package dev.archety.springboot_docker_mysql_demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<UserEntity> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody @Valid UserCreateRequest body) {
        if (repo.existsByEmail(body.email)) {
            throw new RuntimeException("Email already exists: " + body.email);
        }

        UserEntity u = new UserEntity();
        u.setFirstName(body.firstName);
        u.setLastName(body.lastName);
        u.setEmail(body.email);

        return repo.save(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}