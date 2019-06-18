package men.ahasan.spring_mysql_thymeleaf_jpa_crud.controller;

import men.ahasan.spring_mysql_thymeleaf_jpa_crud.model.Product;
import men.ahasan.spring_mysql_thymeleaf_jpa_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        return "index";
    }


    @GetMapping("/viewproduct")
    public String viewAllProduct(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "view_product";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute(product);

        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/viewproduct";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/viewproduct";
    }
}
