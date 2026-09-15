class ElectricityBill {

    public static void main(String[] args) {

        ElectricityBill e = new ElectricityBill(101, "Ayush", 250);

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

        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Electricity Bill: ₹" + bill);
    }
}
