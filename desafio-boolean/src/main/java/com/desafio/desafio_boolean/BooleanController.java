
package com.desafio.desafio_boolean;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BooleanController {

    private final ConfiguracaoRepository repository;

    public BooleanController(ConfiguracaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/boolean")
    public boolean consultarBoolean() {
        return repository.findById(1)
                .map(Configuracao::getAtivo)
                .orElse(false);
    }
}
