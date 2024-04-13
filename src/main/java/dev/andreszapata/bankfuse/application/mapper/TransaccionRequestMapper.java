package dev.andreszapata.bankfuse.application.mapper;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransaccionRequestMapper {

    TransaccionRequestMapper INSTANCE = Mappers.getMapper(TransaccionRequestMapper.class);

    @Mapping(target = "tipoTransaction", source = "")
    @Mapping(target = "monto", source = "")
    @Mapping(target = "idTransaccion", source = "")
    @Mapping(target = "idProduct", source = "")
    @Mapping(target = "idClient", source = "")
    @Mapping(target = "fechaTransaccion", source = "")
    Transaction requestToEntity(TransaccionRequest transaccionRequest);
}
