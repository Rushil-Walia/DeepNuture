package com.library;
import com.library.service.BookService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService service = context.getBean(BookService.class);
        service.addBook("Design Patterns in Java");
        context.close();
    }
}