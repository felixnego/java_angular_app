package fel.web.converter;

import fel.core.model.Client;
import org.springframework.stereotype.Component;
import fel.web.dto.ClientDto;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        client.setId(dto.getId());
        return client;
    }

    @Override
    public ClientDto convertModelToDto(Client client){
        ClientDto dto = ClientDto.builder()
                .name(client.getName())
                .email(client.getEmail())
                .build();
        dto.setId(client.getId());
        return dto;
    }
}
