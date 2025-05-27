package com.rikkei.ptit_hn_ks23b_laihoangnam_01.controller;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.dto.ProductDTO;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Product;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProduct(Model model) {
        List<Product> products = productService.findAll();
        if(products == null){
            return "listnull";
        }else{
            model.addAttribute("products", products);
            return "listProduct";
        }
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "addProduct";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        Product product = new Product();
        product.setProduct_name(productDTO.getProduct_name());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage_url(productDTO.getImage_url());
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }

        ProductDTO productDTO = new ProductDTO();
        product.setProduct_id(productDTO.getProduct_id());
        product.setProduct_name(productDTO.getProduct_name());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage_url(productDTO.getImage_url());

        model.addAttribute("productDTO", productDTO);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        Product product = new Product();
        product.setProduct_id(productDTO.getProduct_id());
        product.setProduct_name(productDTO.getProduct_name());
        product.setPrice(productDTO.getPrice());
        product.setImage_url(productDTO.getImage_url());
        product.setStatus(productDTO.isStatus());
        product.setCreated_at(productDTO.getCreated_at());
        product.setCategory_id(productDTO.getCategory_id());
        productService.update(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
