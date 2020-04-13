package client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fel.web.dto.ClientDto;
import fel.web.dto.ClientsDto;

@Service
public class ClientServiceClient {
    private static final String url = "http://localhost:8080/api/clients";

    @Autowired
    private RestTemplate restTemplate;

    public ClientsDto getAllClients() {
        return restTemplate.getForObject(url, ClientsDto.class);
    }

    public ClientDto saveClient(ClientDto clientDto) {
        return restTemplate.postForObject(
                url,
                clientDto,
                ClientDto.class);
    }

    public void updateClient(Long id, ClientDto clientDto) {
        restTemplate.put(url + "/{id}", clientDto, id);
    }

    public void deleteById(Long id) {
        restTemplate.delete(url + "/{id}", id);
    }
}
