import java.util.*;










public class AccountManager {
    private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
    private int retirementFund;

    public int getBalance(String accountName) {
        Integer total = accountTotals.get(accountName);
        if (total == null)
            total = 0;
        return total;
    }
    public void setBalance(String accountName, int amount) {
        accountTotals.put(accountName, amount);
    }
}