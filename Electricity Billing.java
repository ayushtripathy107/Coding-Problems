import java.util.Scanner;

class ElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        int consumerNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        String consumerName = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        ElectricityBill e = new ElectricityBill(
            consumerNumber, consumerName, units
        );

        e.calculateBill();
    }

    int consumerNumber;
    String consumerName;
    int units;

    ElectricityBill(int consumerNumber, String consumerName, int units) {
        this.consumerNumber = consumerNumber;
        this.consumerName = consumerName;
        this.units = units;
    }

    void calculateBill() {

        double bill;

        if (units <= 100) {
            bill = units * 2;
        }
        else if (units <= 200) {
            bill = (100 * 2) + ((units - 100) * 3);
        }
        else {
            bill = (100 * 2) + (100 * 3) + ((units - 200) * 5);
        }

        System.out.println("\nConsumer Number: " + consumerNumber);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Electricity Bill: ₹" + bill);
    }
}
