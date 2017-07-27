public class CommonData {
    static int sum = 0;

    public static int getSum() {
        return sum;
    }

    public static void addToSum(int curElement) {
        sum = sum + curElement;
    }
}
