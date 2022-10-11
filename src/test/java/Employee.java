import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee() {
    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        setName(name);
        setSalary(salary);
        setWorkHours(workHours);
        setHireYear(hireYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        Scanner sc = new Scanner(System.in);
        if (salary > 0)
            this.salary = salary;
        else {
            while (salary <= 0) {
                System.out.println("\u001b[33;3m" + "Salary should not be negative or '0' " + "\u001b[0m");
                System.out.print("\u001b[33;1m" + "Please enter valid salary : " + "\u001b[0m");
                salary = sc.nextInt();
                this.salary = salary;
            }
        }
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        if (workHours > 40 && workHours < 100)
            this.workHours = workHours;
        else {
            while (workHours < 40 || workHours > 100) {
                Scanner sc = new Scanner(System.in);
                System.out.println("\u001b[33;3m" + "WorkHours should not be smaller than 40 and more than 100 hours " + "\u001b[0m");
                System.out.print("\u001b[33;1m" + "Please enter valid workHours parameter   : " + "\u001b[0m");
                workHours = sc.nextInt();
            }
            this.workHours = workHours;
        }
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        if (hireYear <= 2021 && hireYear>2000)
            this.hireYear = hireYear;
        else {
            while (hireYear > 2021 || hireYear<2000) {
                Scanner sc = new Scanner(System.in);
                System.out.print("\u001b[33;1m" + "Please enter valid year : " + "\u001b[0m");
                hireYear = sc.nextInt();
            }
            this.hireYear = hireYear;
        }
    }


    public static double tax(double salary) {
        if (salary < 1000)
            return 0;
        else
            return salary * 0.03;
    }

    public static double bonus(int workHours) {
        int bonus = 0;
        if (workHours > 40)
            bonus = (workHours - 40) * 30*4;
        return bonus;
    }

    public static double raiseSalary(int hireYear, double salary, int workHours) {
        double raiseAmount = 0;
        if (2021 - hireYear < 10) {
            raiseAmount = ((salary - tax(salary)) + bonus(workHours)) * 0.05;
        } else if (2021 - hireYear > 9 && 2021 - hireYear < 20) {
            raiseAmount = ((salary - tax(salary)) + bonus(workHours)) * 0.1;
        } else if (2021 - hireYear > 19) {
            raiseAmount = ((salary - tax(salary)) + bonus(workHours)) * 0.15;
        }
        return raiseAmount;
    }

    public static double currentSalary(double salary, int workHours) {
        return salary-tax(salary)+bonus(workHours);
    }
    public static double newSalary(double salary, int workHours, int hireYear) {
        return salary + raiseSalary(hireYear, salary, workHours)+bonus(workHours);
    }


    public static void createEmployee(ArrayList<Employee> employees) {

        Scanner sc = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Enter your full name                      : ");
        employee.setName(scStr.nextLine());

        System.out.print("Enter your current salary                 : ");
        employee.setSalary(sc.nextDouble());

        System.out.print("Enter your work hours in week             : ");
        employee.setWorkHours(sc.nextInt());

        System.out.print("Enter your year of entry into the company : ");
        employee.setHireYear(sc.nextInt());

        System.out.println();
        employees.add(employee);
    }

    public static void searchEmployeeWithName(ArrayList<Employee> employees) {
        Scanner scStr = new Scanner(System.in);

        System.out.print("Enter the employee Name                    :");
        String name = scStr.nextLine();
        int count = 0;
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                System.out.println(e);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("\u001b[36;1m" + "No information with this name ! " + "\u001b[0m");
        }
    }
    public static void progressBarr() {
        System.out.println("\u001b[32;1m \u001b[0m");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int j = i / 10; j > 0; j--) {
                System.out.print("\u001b[42m" + "   " + "\u001b[0m");
            }
            System.out.print(" " + (i + 1) + "%\r");
        }
    }
    @Override
    public String toString() {
        progressBarr();
        return
                "\u001b[32;1m" + "Employee Information" + "\u001b[0m" + '\n' +
                        "Full Name         = " + name + '\n' +
                        "Salary            = " + salary + "TL" + '\n' +
                        "Work Hours        = " + workHours + '\n' +
                        "Hire Year         = " + hireYear + '\n' +
                        "Tax               = " + tax(salary) + "TL" + '\n' +
                        "Bonus             = " + bonus(workHours) + "TL" + '\n' +
                        "Current Salary    = " + currentSalary(salary,workHours)+'\n'+
                        "Salary Increase   = " + raiseSalary(hireYear, salary, workHours) + "TL" + '\n' +
                        "New Salary        = " + newSalary(salary, workHours, hireYear) + "TL" + '\n'
                ;
    }
}
