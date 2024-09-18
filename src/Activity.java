import java.util.Scanner;

public class Activity {
    public static int Employees(){
        Scanner num = new Scanner(System.in);

        System.out.println("Enter number of employees: ");
        int employees = num.nextInt();

        return employees;
    }

    public static void StoreDetails(){
        int employees = Employees();
        String[][] GlobalDetails = new String[employees+1][];

        for (int i = 0; i < employees; i++) {
            int serial = (i+1);
            System.out.println("Enter Name, Base Salary and Complement for Employee "+serial+": ");

            String[] LocalDetails = new String[4];
            Scanner sc = new Scanner(System.in);

            double tax = 0;   //Tax percentage is here, set to 0
            String Name = sc.nextLine();
            LocalDetails[0] = Name;
            float salary = sc.nextFloat();
            LocalDetails[1] = String.valueOf(salary);
            float complement = sc.nextFloat();
            LocalDetails[2] = String.valueOf(complement);
            float total = salary + complement;
            double finalSalary = total-(total*tax/100);
            LocalDetails[3] = String.valueOf(finalSalary);

            GlobalDetails[i] = LocalDetails;
            //System.out.println(Arrays.toString(GlobalDetails[i]));

        }
        for (int i = 0; i < employees; i++) {
            System.out.println("Name: "+GlobalDetails[i][0]+" Salary: "+ GlobalDetails[i][1]+" Complement "+ GlobalDetails[i][2]+ " Total Salary: "+ GlobalDetails[i][3]);

        }
    }


    public static void main(String[] args){


        StoreDetails();
    }
}
