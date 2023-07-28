public class Test {
    public static void main(String[] args) {

        Main main = new Main();
        main.run();

        System.out.println("Number of requested threads: " + main.countValue);
        System.out.println("Sum of bin values: " + main.sumValue);
        if (main.countValue == main.sumValue) {
            System.out.println("Great job! The count and sum are equal.");
        }
    }
}