package com.rikkei.ptit_hn_ks23b_laihoangnam_01.controller;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.dto.CategoryDTO;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.dto.ProductDTO;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Category;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Product;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String findAll(Model model) {
        List<Category> categories = categoryService.findAll();
        if(categories == null){
            return "listnull";
        }else{
            model.addAttribute("categories", categories);
            return "listCategory";
        }
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("CategoryDTO", new Category());
        return "addCategory";
    }

    @PostMapping("/add")
    public String add(@Valid CategoryDTO categoryDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addCategory";
        }
        Category category = new Category();
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setDescription(categoryDTO.getDescription());
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/category";
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        category.setCategory_id(categoryDTO.getCategory_id());
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.isStatus());
        categoryService.save(category);
        model.addAttribute("CategoryDTO", categoryDTO);
        return "editCategory";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "editCategory";
        }
        Category category = new Category();
        category.setCategory_id(categoryDTO.getCategory_id());
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.isStatus());
        categoryService.save(category);

        return "editCategory";

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
}
