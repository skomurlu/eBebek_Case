import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choose;
        do {
            System.out.print("1-Add employer\n2-Show the employees information" +
                    "\n3-Search employee info, enter the full name" +
                    "\n4-Exit"+
                    "\nEnter your choose\t\t\t\t          : ");
            choose = sc.nextInt();
            switch (choose)
            {
                case 1: Employee.createEmployee(employees);break;
                case 2: System.out.println(employees);break;
                case 3: Employee.searchEmployeeWithName(employees);break;
                case 4: System.out.println("Exiting..");break;
            }
        } while (choose<4 && 0<choose);

    }
}
