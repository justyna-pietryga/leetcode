public class MinimumPenaltyShop {
    public int bestClosingTime(String customers) {
        int customersAmount = customers.length();
        int counter = 0;
        for (int i = 0; i < customersAmount; i++) {
            if (customers.charAt(i) == 'Y') counter++;
        }

        int smallest = counter;
        int smallestIndex = 0;
        for (int i = 1; i < customersAmount + 1; i++) {
            if (customers.charAt(i - 1) == 'N') {
                counter++;
            } else {
                counter--;
            }
            if (smallest > counter) {
                smallest = counter;
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
