package dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper;

import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product entityToDomain(ProductEntity productEntity);

    ProductEntity domainToEntity(Product domain);


}
