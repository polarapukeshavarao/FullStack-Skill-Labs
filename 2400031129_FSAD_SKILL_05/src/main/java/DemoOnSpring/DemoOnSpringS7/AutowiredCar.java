package DemoOnSpring.DemoOnSpringS7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredCar {
	@Autowired
	AutowiredEngine engine;
	public void drive()
	{
		engine.start();
		System.out.println("Car is moving");
	}
	public void displayEngineType(String type)
	{
		engine.enginetype(type);
		System.out.println("Type of Engine is "+engine.engineType);
	}

}
