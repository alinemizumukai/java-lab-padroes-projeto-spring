package edu.diosantander.lab.service;

import edu.diosantander.lab.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> retornarTodos();
    Cliente retornarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void remover(Long id);
}
