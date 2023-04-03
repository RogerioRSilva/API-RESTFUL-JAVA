package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Informamos para a classe que ela é uma controller.
@RequestMapping("/hello") // Nome da chamada realizada.
public class HelloController {

    @GetMapping  // Sempre que for feita a requisição será chamado esse metodo
    public String olaMundo(){
        return "Hello World Spring! ";
    }
}
