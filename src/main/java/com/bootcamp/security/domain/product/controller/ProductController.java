package com.bootcamp.security.domain.product.controller;

import com.bootcamp.security.domain.product.dto.ProductCreateRequest;
import com.bootcamp.security.domain.product.entity.Product;
import com.bootcamp.security.domain.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/add")
    public String productAddForm(@ModelAttribute("request") ProductCreateRequest request) {
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("request") ProductCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/add";
        }
        productService.addProduct(request);
        return "redirect:/product/list";
    }
}
