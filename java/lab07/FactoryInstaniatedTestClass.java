package lab07;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryInstaniatedTestClass implements ITest {
	private String param;
	
    public FactoryInstaniatedTestClass(String param) {
        this.param = param;
    }
    public String getTestName () {
        return getClass().getSimpleName () +"-"+ param;
    }
   @Factory
    public static Object[] create() {
        return new Object[]{new FactoryInstaniatedTestClass("TestNG"),
                new FactoryInstaniatedTestClass("Reports")
                };
   }
   @Test
    public void f() {
        if (param.equals("Reports")) {
            Assert.assertTrue(false);
        }
    }
   }
    
