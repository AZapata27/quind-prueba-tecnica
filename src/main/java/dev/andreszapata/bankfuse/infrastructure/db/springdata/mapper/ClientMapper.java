package dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ClientEntity;
import dev.andreszapata.bankfuse.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client entityToDomain(ClientEntity entity);

    ClientEntity domainToEntity(Client domain);
}
