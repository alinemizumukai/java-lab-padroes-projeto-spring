package edu.diosantander.lab.service.impl;

import edu.diosantander.lab.model.Cliente;
import edu.diosantander.lab.model.ClienteRepository;
import edu.diosantander.lab.model.Endereco;
import edu.diosantander.lab.model.EnderecoRepository;
import edu.diosantander.lab.service.ClienteService;
import edu.diosantander.lab.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> retornarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente retornarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvar(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvar(cliente);
        }
    }

    @Override
    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    //Private Methods
    private void salvar(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
