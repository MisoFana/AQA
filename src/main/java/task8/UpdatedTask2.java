package task8;

public class UpdatedTask2 {
    public String formatName(String name) {
        return String.format("Name: %s", name);
    }

    public String formatSalary(float salary) {
        return String.format("Salary: %.2f", salary);
    }

    public String formatNameAndSalary(String name, float salary) {
        return String.format("Name: %s, Salary: %.2f", name, salary);
    }
}
