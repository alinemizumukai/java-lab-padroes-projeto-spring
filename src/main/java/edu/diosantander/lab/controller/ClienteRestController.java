package edu.diosantander.lab.controller;

import edu.diosantander.lab.model.Cliente;
import edu.diosantander.lab.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> retornarTodos(){
        return ResponseEntity.ok(clienteService.retornarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.retornarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        clienteService.remover(id);
        return ResponseEntity.ok().build();
    }
}
