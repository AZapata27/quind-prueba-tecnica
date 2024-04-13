package dev.andreszapata.bankfuse.application.mapper;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRequestMapper {

    ProductRequestMapper INSTANCE = Mappers.getMapper(ProductRequestMapper.class);

    Product requestToDomain(ProductoRequest productoRequest);

    ProductoRequest domainToRequest(Product domain);


}
