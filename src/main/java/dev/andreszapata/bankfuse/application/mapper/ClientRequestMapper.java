package dev.andreszapata.bankfuse.application.mapper;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientRequestMapper {

    ClientRequestMapper INSTANCE = Mappers.getMapper(ClientRequestMapper.class);

    Client requestToDomain(ClienteRequest request);

    ClienteRequest domainToRequest(Client domain);
}
