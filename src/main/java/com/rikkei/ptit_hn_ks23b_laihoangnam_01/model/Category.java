package com.rikkei.ptit_hn_ks23b_laihoangnam_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    private int category_id;
    private String category_name;
    private String description;
    private boolean status;
}
