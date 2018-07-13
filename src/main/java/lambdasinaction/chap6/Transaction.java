package lambdasinaction.chap6;

public class Transaction {
    private String currency;
    private Integer money;

    public Transaction(String currency, Integer money) {
        this.currency = currency;
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency='" + currency + '\'' +
                ", money=" + money +
                '}';
    }
}
