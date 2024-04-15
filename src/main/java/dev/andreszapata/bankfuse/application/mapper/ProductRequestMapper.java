package dev.andreszapata.bankfuse.application.mapper;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        uses = {ProductRequestMapper.class})
public interface ProductRequestMapper {

    Product requestToDomain(ProductoRequest productoRequest);

    ProductoRequest domainToRequest(Product domain);


}
