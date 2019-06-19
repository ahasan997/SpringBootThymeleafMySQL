package men.ahasan.spring_mysql_thymeleaf_jpa_crud.controller;

import men.ahasan.spring_mysql_thymeleaf_jpa_crud.model.Product;
import men.ahasan.spring_mysql_thymeleaf_jpa_crud.model.ProductDTO;
import men.ahasan.spring_mysql_thymeleaf_jpa_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute(productDTO);

        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid ProductDTO productDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            System.out.println("has errors");
            return "new_product";
        }

        service.save(productDTO.getProduct());

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
