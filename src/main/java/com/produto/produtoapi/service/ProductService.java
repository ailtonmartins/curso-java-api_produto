package com.produto.produtoapi.service;

import com.produto.produtoapi.entity.ProductImage;
import lombok.AllArgsConstructor;

import com.produto.produtoapi.dto.request.ProductDTO;
import com.produto.produtoapi.dto.response.MessageResponseDTO;
import com.produto.produtoapi.entity.Product;
import com.produto.produtoapi.exception.ProductNotFoundException;

import com.produto.produtoapi.dto.mapper.ProductMapper;
import com.produto.produtoapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public MessageResponseDTO createProduct(ProductDTO productDTO) {
        Product productToSave = productMapper.toModel(productDTO);
        Product savedProduct = productRepository.save(productToSave);
        return createMessageResponse(savedProduct.getId(), "Created Product with ID ");
    }

    public List<ProductDTO> listAll() {
        List<Product> allProduct = productRepository.findAll();
        return allProduct.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        Product product = verifyIfExists(id);
        System.out.println( product.getProductImages().get(0).getUrl() );
        return productMapper.toDTO(product);
    }

    public void delete(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, ProductDTO productDTO) throws ProductNotFoundException {
        verifyIfExists(id);

        productDTO.setId(id);

        Product personToUpdate = productMapper.toModel(productDTO);

        Product updatedPerson = productRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated product with ID ");
    }

    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
