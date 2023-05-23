package homework26;

import homework26.annotation.*;

public class TestClass {

    @AfterSuite
    public void afterSuite1 () {
        System.out.println("All tests finished");
    };

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Start tests...");
    };

    @Test (priority = 6)
    public void test3 () {
        System.out.println("Test 3");
    };

    @Test (priority = 5)
    public void test1 () {
        System.out.println("Test 2");
    };

    @Test (priority = 2)
    public void test2 () {
        System.out.println("Test 1");
    };

}
