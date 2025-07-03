package org.sudhir;

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
        System.out.println( "Hello World!" );
        //Dev obj = new Dev();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // this is going to create the container.
        //Dev obj = (Dev) context.getBean("dev");
        Dev obj = context.getBean(Dev.class);
        obj.Build();
        Laptop lap = (Laptop) context.getBean("laptop");
        lap.compile();
    }
}
