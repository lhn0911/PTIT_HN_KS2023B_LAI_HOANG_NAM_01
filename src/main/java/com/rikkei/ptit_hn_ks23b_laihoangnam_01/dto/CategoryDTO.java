package com.rikkei.ptit_hn_ks23b_laihoangnam_01.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class CategoryDTO {
    private int category_id;
    @NotBlank(message = "Ten danh muc khong duoc de trong")
    private String category_name;
    private String description;
    private boolean status;
}
