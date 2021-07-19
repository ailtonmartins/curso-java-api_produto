package com.produto.produtoapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesDTO {

    private Long id;

    @Size(min = 5 , max=100)
    private String description;

    @NotEmpty
    private String url;
}
