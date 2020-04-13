package fel.core.service;

import fel.core.model.Client;
import fel.core.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    public static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients(){
        log.trace("getAllClients --- method entered");

        List<Client> results = clientRepository.findAll();

        log.trace("getAllClients: results={}", results);

        return results;
    }

    @Override
    public Client saveClient(Client client){
        log.trace("saveClient --- method entered");
        log.trace("saving Client={}", client);

        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client){
        log.trace("updateClient --- method entered");

        Client update = clientRepository.findById(id).orElseThrow();
        update.setName(client.getName());
        update.setEmail(client.getEmail());


        log.trace("updating Client={}", update);

        return update;
    }

    @Override
    public void deleteClient(Long id){
        log.trace("deleteClient --- method entered");
        log.trace("deleting Client with id={}", id);
        clientRepository.deleteById(id);
    }
}
