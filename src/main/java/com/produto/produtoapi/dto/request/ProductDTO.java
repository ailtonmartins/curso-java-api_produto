package com.produto.produtoapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 255)
    private String code;

    @NotEmpty
    private Float price;

    @NotEmpty
    @Size(min = 5, max = 255)
    private String description;

    @NotEmpty
    private String expirationDate;

    @Valid
    @NotEmpty
    private List<ProductImagesDTO> images;
}
