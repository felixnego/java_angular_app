package fel.web.controller;

import fel.core.model.Client;
import fel.core.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fel.web.converter.ClientConverter;
import fel.web.dto.ClientDto;
import fel.web.dto.ClientsDto;

import java.util.List;

@RestController
public class ClientController {
    public static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value="/clients", method= RequestMethod.GET)
    ClientsDto getClient(){
        log.trace("getClients --- method entered");

        List<Client> clients = clientService.getAllClients();
        ClientsDto results = new ClientsDto(clientConverter.convertModelsToDtos(clients));

        return results;
    }

    @RequestMapping(value="/clients", method=RequestMethod.POST)
    ClientDto saveClient(@RequestBody ClientDto clientDto){
        log.trace("saveClient --- method entered");

        Client savedClient = clientService.saveClient(
                clientConverter.convertDtoToModel(clientDto)
        );

        ClientDto result = clientConverter.convertModelToDto(savedClient);

        return result;
    }

    @RequestMapping(value="/clients/{id}", method = RequestMethod.PUT)
    ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto){
        log.trace("updateClient --- method entered");

        Client client = clientService.updateClient(id, clientConverter.convertDtoToModel(clientDto));

        return clientConverter.convertModelToDto(client);

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        log.trace("updateClient --- method entered");

        clientService.deleteClient(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
