package task8;


import org.testng.Assert;
import org.testng.annotations.*;

public class Task2Test {

    @Test(dataProvider = "nameProvider")
    public void testFormatName(String name, String expected) {
        UpdatedTask2 task = new UpdatedTask2();
        Assert.assertEquals(task.formatName(name), expected);
    }

    @Test(dataProvider = "salaryProvider")
    public void testFormatSalary(float salary, String expected) {
        UpdatedTask2 task = new UpdatedTask2();
        Assert.assertEquals(task.formatSalary(salary), expected);
    }

    @Test(dataProvider = "nameAndSalaryProvider")
    @Parameters({"name", "salary"})
    public void testFormatNameAndSalary(String name, float salary, String expected) {
        UpdatedTask2 task = new UpdatedTask2();
        Assert.assertEquals(task.formatNameAndSalary(name, salary), expected);
    }

    @DataProvider(name = "nameProvider")
    public Object[][] provideNames() {
        return new Object[][]{
                {"Петро Іванович", "Name: Петро Іванович"},
                {"Іван Петрович", "Name: Іван Петрович"}
        };
    }

    @DataProvider(name = "salaryProvider")
    public Object[][] provideSalaries() {
        return new Object[][]{
                {10252.75f, "Salary: 10252.75"},
                {8500.50f, "Salary: 8500.50"}
        };
    }

    @DataProvider(name = "nameAndSalaryProvider")
    public Object[][] provideNameAndSalary() {
        return new Object[][]{
                {"Петро Іванович", 10252.75f, "Name: Петро Іванович, Salary: 10252.75"},
                {"Іван Петрович", 8500.50f, "Name: Іван Петрович, Salary: 8500.50"}
        };
    }
}
