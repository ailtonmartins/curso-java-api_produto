package com.produto.produtoapi.controller;

import com.produto.produtoapi.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import com.produto.produtoapi.dto.request.ProductDTO;
import com.produto.produtoapi.dto.response.MessageResponseDTO;
import com.produto.produtoapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> listAll() {
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ProductDTO personDTO) throws ProductNotFoundException {
        return productService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }

}
