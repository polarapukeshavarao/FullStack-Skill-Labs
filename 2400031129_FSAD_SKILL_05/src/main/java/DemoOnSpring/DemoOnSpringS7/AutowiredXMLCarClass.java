package DemoOnSpring.DemoOnSpringS7;

public class AutowiredXMLCarClass {
	AutowiredXMLEngineClass engine;
	public void setEngine(AutowiredXMLEngineClass engine)
	{
		this.engine=engine;
	}
	void drive()
	{
		engine.start();
		System.out.println("Car is running");
	}

}
