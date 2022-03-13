package kz.anna.endterm.service.impl;

import kz.anna.endterm.entity.Client;
import kz.anna.endterm.repository.ClientRepository;
import kz.anna.endterm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void createClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.saveAndFlush(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        Client userDb = clientRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(client.getUsername());
            userDb.setPassword(passwordEncoder.encode(client.getPassword())); // plaintext password
            clientRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).get();
        clientRepository.delete(client);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);

        if (client == null) {
            throw new UsernameNotFoundException("Client: " + username + " not found!");
        }
        return client;
    }
}
