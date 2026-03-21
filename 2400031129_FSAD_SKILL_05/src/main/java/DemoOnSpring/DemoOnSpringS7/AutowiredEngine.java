package DemoOnSpring.DemoOnSpringS7;

import org.springframework.stereotype.Component;

@Component
public class AutowiredEngine {
	
	String engineType;
	public void start()
	{
		System.out.println("Engine Start");
	}
	public void enginetype(String type)
	{
		this.engineType=type;
	}
	


}
