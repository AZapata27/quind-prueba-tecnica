package dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper;

import dev.andreszapata.bankfuse.application.mapper.TransaccionRequestMapper;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ClientEntity;
import dev.andreszapata.bankfuse.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        uses = {ClientMapper.class})
public interface ClientMapper {

    Client entityToDomain(ClientEntity entity);

    ClientEntity domainToEntity(Client domain);
}
