package com.rikkei.ptit_hn_ks23b_laihoangnam_01.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
public class ProductDTO {
    private int product_id;
    @NotBlank(message = "Ten san pham khong duoc de trong")
    private String product_name;
    private String description;
    @Min(value = 1,message = "Gia san pham phai lon hon 0")
    private Double price;
    private String image_url;
    private boolean status;
    private LocalDate created_at;
    private int category_id;
}
