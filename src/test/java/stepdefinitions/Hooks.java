package stepdefinitions;

import io.cucumber.java.Before;

public class Hooks{
	
	@Before("@add")
	public void runbefore()
	{
		StepDefinitions s = new StepDefinitions();
		
		System.out.println("==========================before get method=================");
	}

}
