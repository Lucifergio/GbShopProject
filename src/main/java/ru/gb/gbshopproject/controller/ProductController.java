package ru.gb.gbshopproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbshopproject.entity.Product;
import ru.gb.gbshopproject.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Transactional
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('product.create', 'product.update ')")
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Product product;
        if (id != null) {
            product =  productService.findById(id);
        } else {
            product = new Product();
        }
        model.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasAnyAuthority('product.read')")
    public String showInfo (Model model, @PathVariable(name = "productId") Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
        } else {
            return "redirect:/product/all";
        }
        model.addAttribute("product", product);
        return "product-info";
    }

    @GetMapping("/login-prompt")
    public String loginPrompt () {
        return "login-prompt";
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('product.create', 'product.update ')")
    public String saveProduct(Product product) {
        product.setManufactureDate(LocalDate.now());
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('product.delete')")
    public String deleteById(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping("/cartList")
    @PreAuthorize("hasAnyAuthority('cart.add')")
    public String cart(Model model) {
        model.addAttribute("prodCart", productService.allProductInCart());
        return "cartList";
    }

    @GetMapping("/addProductInCart/{id}")
    @PreAuthorize("hasAnyAuthority('cart.add')")
    public String addProduct(@PathVariable(name = "id") Long id) {
        productService.addProductInCart(id);
        return "redirect:/product/all";
    }

    @GetMapping("/deleteProduct/{id}")
    @PreAuthorize("hasAnyAuthority('cart.delete')")
    public String deleteFromCart(@PathVariable(name = "id") Long id) {
        productService.deleteFromCartById(id);
        return "redirect:/product/cartList";
    }
}
