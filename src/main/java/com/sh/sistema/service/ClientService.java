package com.sh.sistema.service;

import com.sh.sistema.entities.Client;
import com.sh.sistema.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Integer matricula){
        Optional<Client> obj = clientRepository.findById(matricula);
        return obj.orElseThrow(()-> new ResourceAccessException("Matricula não encontrada"));
    }

    public Client insert(Client obj){
        return clientRepository.save(obj);
    }

    public void delete(Integer matricula){
        clientRepository.deleteById(matricula);
    }

    public Client update(Integer matricula, Client obj){
        try{
            Client entity = clientRepository
                    .findById(matricula).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com matrícula: " + matricula));
            updateData(entity, obj);
            return clientRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    private void updateData(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setAdress(obj.getAdress());
        entity.setModality(obj.getModality());
    }


}
