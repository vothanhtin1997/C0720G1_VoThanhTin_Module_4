package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.entity.ShoppingCart;
import com.codegym.entity.User;
import com.codegym.service.ProductService;
import com.codegym.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/", "/product"})
@SessionAttributes({"user","list"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }


    @ModelAttribute("list")
    public List<Product> setUpList() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public ModelAndView goHome() {
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @GetMapping("/list")
    public String showlist(Model model, @PageableDefault(size = 2) Pageable pageable,@ModelAttribute("user") User user,
                           @ModelAttribute("list") List<Product> list) {
            model.addAttribute("listproduct", productService.findAll(pageable));
            model.addAttribute("user",user);
            model.addAttribute("listproductcart",list);
            return "showlistproduct";
    }

    @GetMapping("/create")
    public String getProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Product product) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCart_id(1);
        product.setShoppingCart(shoppingCart);
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/view";
    }

}
