package DemoOnSpring.DemoOnSpringS7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    	ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Employee1 e1=(Employee1)context.getBean("emp1Bean");
    	Employee1 e2=(Employee1)context.getBean("emp2Bean");
        System.out.println(e1);
        System.out.println(e2);
    	
    }
}
