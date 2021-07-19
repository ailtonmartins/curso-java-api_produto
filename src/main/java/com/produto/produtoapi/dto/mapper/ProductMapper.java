package com.produto.produtoapi.dto.mapper;

import com.produto.produtoapi.dto.request.ProductDTO;
import com.produto.produtoapi.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "expirationDate",  target= "expirationDate", dateFormat = "dd/MM/yyyy")
    @Mapping(source="images",  target="productImages")
    Product toModel(ProductDTO productDto);

    @Mapping(target = "expirationDate", source = "expirationDate", dateFormat = "dd/MM/yyyy")
    @Mapping(source="productImages",  target="images")
    ProductDTO toDTO(Product product);
}
