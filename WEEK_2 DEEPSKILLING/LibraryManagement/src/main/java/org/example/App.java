package org.example;

import org.example.repository.BookRepository;
import org.example.services.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
       BookService service=context.getBean(BookService.class);
        System.out.println(service.getRepo());
    }
}
