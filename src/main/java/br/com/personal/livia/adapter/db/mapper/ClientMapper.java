package br.com.personal.livia.adapter.db.mapper;

import br.com.personal.livia.adapter.db.model.ClientModel;
import br.com.personal.livia.adapter.dto.ClientDto;
import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.vo.Gender;

import java.time.LocalDate;

public interface ClientMapper {

     static ClientModel toEntity(Client client) {
        var clientModel = new ClientModel();
        clientModel.setId(client.getId());
        clientModel.setName(client.getName());
        clientModel.setGender(client.getGender().getDescription());
        clientModel.setBirthday(client.getBirthday());
        clientModel.setCelPhone(client.getCelPhone());
        clientModel.setCpf(client.getCpf());
        clientModel.setEmail(client.getEmail());
        clientModel.setCreateDate(client.getCreateDate());
        clientModel.setUpdateDate(client.getUpdateDate());
        return clientModel;
    }

    static Client toClient(ClientDto clientDto) {
        return new Client.ClientBuilder()
                .setName(clientDto.getName())
                .setGender(Gender.getGender(clientDto.getGender()))
                .setBirthday(LocalDate.parse(clientDto.getBirthday()))
                .setCelPhone(clientDto.getCelPhone())
                .setCpf(clientDto.getCpf())
                .setEmail(clientDto.getEmail())
                .build();
    }

    static Client toClient(ClientModel clientModel) {
         return new Client.ClientBuilder()
                 .setId(clientModel.getId())
                 .setName(clientModel.getName())
                 .setGender(Gender.getGender(clientModel.getGender()))
                 .setBirthday(clientModel.getBirthday())
                 .setCelPhone(clientModel.getCelPhone())
                 .setCpf(clientModel.getCpf())
                 .setEmail(clientModel.getEmail())
                 .setCreateDate(clientModel.getCreateDate())
                 .setUpdateDate(clientModel.getUpdateDate())
                 .build();

    }
}
