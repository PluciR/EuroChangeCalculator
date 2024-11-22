public class EuroChangeCalculator {
    public static void main(String[] args) {
        EuroChangeCalculator main = new EuroChangeCalculator();
        System.out.println(main.changeCalculatorIterative(81));
        System.out.println(main.changeCalculatorIterativeSingleArray(81));
        System.out.println(main.changeCalculatorRecursive(81, 0, true));
    }

    private final int twoHundred = 200;
    private final int oneHundred = 100;
    private final int fifty = 50;
    private final int twenty = 20;
    private final int ten = 10;
    private final int five = 5;
    private final int two = 2;
    private final int one = 1;

    private final int[] euroNotes = {200, 100, 50, 20, 10, 5, 2, 1};
    private int changeCount = 0;

    public int changeCalculatorRecursive(int change, int index, boolean reset) {
        if (change < 0) {
            System.out.println("ERROR: € Betrag muss positiv sein.");
            return 0;
        }
        if (change == 0) {
            return this.changeCount;
        }
        if (reset) {
            this.changeCount = 0;
        }
        if (change >= this.euroNotes[index]) {
            this.changeCount++;
            return changeCalculatorRecursive(change - this.euroNotes[index], index, false);
        }
        return changeCalculatorRecursive(change, index + 1, false);
    }

    public int changeCalculatorIterativeSingleArray(int change) {
        if (change < 0) {
            System.out.println("ERROR: € Betrag muss positiv sein.");
            return 0;
        }
        this.changeCount = 0;

        for (int denomination : this.euroNotes) {
            while (change >= denomination) {
                this.changeCount++;
                change -= denomination;
            }
        }
        return this.changeCount;
    }
    public int changeCalculatorIterative(int change) {
        if (change < 0) {
            System.out.println("ERROR: € Betrag muss positiv sein.");
            return 0;
        }
        this.changeCount = 0;
        while (change != 0) {
            if (change >= this.twoHundred) {
                this.changeCount++;
                change -= 200;
            } else if (change >= this.oneHundred) {
                this.changeCount++;
                change -= 100;
            } else if (change >= this.fifty) {
                this.changeCount++;
                change -= 50;
            } else if (change >= this.twenty) {
                this.changeCount++;
                change -= 20;
            } else if (change >= this.ten) {
                this.changeCount++;
                change -= 10;
            } else if (change >= this.five) {
                this.changeCount++;
                change -= 5;
            } else if (change >= this.two) {
                this.changeCount++;
                change -= 2;
            } else {
                this.changeCount++;
                change -= 1;
            }
        }
        return changeCount;
    }
}
