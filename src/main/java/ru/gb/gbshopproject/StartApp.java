package ru.gb.gbshopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.gbshopproject.service.ProductService;

@SpringBootApplication
public class StartApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(StartApp.class, args);
        ProductService productService = context.getBean(ProductService.class);
    }

}
