package kz.anna.endterm.service;

import kz.anna.endterm.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    void createClient(Client client);
    void updateClient(Long id, Client client);
    void deleteClient(Long id);

}
