package version2;

import java.util.ArrayList;

public class BankOperation {

    ArrayList<BankCustomer> customer = new ArrayList<>();

    public void newCustomer(String name, String birthday) {
        customer.add(new BankCustomer(name, birthday));
    }

    public void removeCustomer(String name) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                customer.remove(i);
            }
        }
    }

    public void addAccount(String name, String accName, double balance) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                i.getAcc().put(accName, new SavingAccount(accName, balance));

            }

        }
    }

    public void addAccount(String name, String accName, double balance, double interest) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                i.getAcc().put(accName, new SavingAccount(accName, balance, interest));

            }

        }
    }

    public void removeAccount(String name, String accName) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                if (i.getAcc().containsKey(accName)) {
                    i.getAcc().remove(accName);
                } else {
                    System.out.println();
                }
            }
        }
    }

    public void getCustomerAccountName(String name) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                i.getAcc().keySet().forEach(a -> System.out.println(a));
            }
        }
    }

    public void getEveyCustomerAccountCount() {
        if (customer.size() == 0) {
            return;
        }
        System.out.println("List");
        for (BankCustomer i : customer) {
            System.out.println("Customer " + i.getName() + " have " + i.getAccountCount() + " savingAccounts");
        }
    }

    public void getCustomerAccountList() {
        if (customer.size() == 0) {
            return;
        }
        System.out.println("List");
        for (BankCustomer i : customer) {
            System.out.println("Customer " + i.getName() + " have " + i.getAccountCount() + " savingAccounts: ");
            i.getAcc().keySet().forEach(a -> System.out.println(a));
        }
    }

    public void calculateInterest(String name, String accName, int year) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                if (i.getAcc().containsKey(accName)) {
                    for (int j = 0; j < year; j++) {
                        i.getAcc().get(accName).addInterest();
                    }
                } else {

                }
            }
        }
    }

    public void calculateInterestGlobal(String name, int year) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                for (int j = 0; j < year; j++) {
                    i.getAcc().forEach((k, v) -> v.addInterest());
                }
            }
        }
    }

    public void getCustomerAccountBalance(String name, String accName) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                if (i.getAcc().containsKey(accName)) {
                    i.getAcc().get(accName).getBalance();
                }
            }
        }
    }

    public void getCustomerAccountBalanceList(String name) {
        for (BankCustomer i : customer) {
            if (i.getName().equals(name)) {
                i.getAcc().forEach((k, v) -> System.out.println(k + v));
            }
        }
    }
    /*
     * public static void addAccount(BankCustomer customer) {
     * customer.getAcc().add(new SavingAccount(customer.getName()));
     * System.out.println("New savingAccount has been added in user " +
     * customer.getName()); System.out.println("The id of new account is " +
     * customer.getAcc().get(customer.getAcc().size() - 1).stringId()); //
     * customer.setAcc(customer.getAcc()); }
     * 
     * public static void addAccount(BankCustomer customer, double balance) {
     * customer.getAcc().add(new SavingAccount(customer.getName(), balance));
     * System.out.println("New savingAccount has been added in user " +
     * customer.getName()); System.out.println("The id of new account is " +
     * customer.getAcc().get(customer.getAcc().size() - 1).getId()); //
     * customer.setAcc(customer.getAcc()); }
     * 
     * public static void addAccount(BankCustomer customer, double balance, double
     * interest) { customer.getAcc().add(new SavingAccount(customer.getName(),
     * balance, interest));
     * System.out.println("New savingAccount has been added in user " +
     * customer.getName()); System.out.println("The id of new account is " +
     * customer.getAcc().get(customer.getAcc().size() - 1).getId()); //
     * customer.setAcc(customer.getAcc()); }
     * 
     * public static void removeAccount(BankCustomer customer, int id) { for
     * (SavingAccount i : customer.getAcc()) { if (i.getId() == id) {
     * customer.getAcc().remove(i); System.out.println( "The SavingAccount of user "
     * + customer.getName() + " with id " + id + " has been removed");
     * System.out.println("The id will forever be removed"); return; } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     * public static void addBalance(BankCustomer customer, int id, double balance)
     * { for (SavingAccount i : customer.getAcc()) { if (i.getId() == id) {
     * i.setBalance(i.getBalance() + balance); System.out.println("You  have add " +
     * balance + " yen to your account");
     * System.out.println("Your current balance is " + i.getBalance() + " yen");
     * return; } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     * public static void deductBalance(BankCustomer customer, int id, double
     * balance) { for (SavingAccount i : customer.getAcc()) { if (i.getId() == id) {
     * if (i.getBalance() - balance >= 0) { i.setBalance(i.getBalance() - balance);
     * System.out.println("You  have deduct " + balance + " yen from your account");
     * System.out.println("Your current balance is " + i.getBalance() + " yen");
     * return; } else {
     * System.out.println("Sorry, This bank do not allow you to take loans yet");
     * return; } } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     * public static void getBalance(BankCustomer customer, int id) {
     * System.out.println("The balance of user" + customer.getName() + " in id " +
     * id + " is " + customer.getAcc().get(id).getBalance() + " yen"); }
     * 
     * public static void getBalanceList(BankCustomer customer) { if
     * (customer.getAcc().size() == 0) {
     * System.out.println("No savingAccount in this user"); return; }
     * System.out.println("Showing balance of accounts of " + customer.getName());
     * for (SavingAccount i : customer.getAcc()) {
     * System.out.println("The balnace of savingAccount id " + i.getId() + " is " +
     * i.getBalance() + " yen"); } }
     * 
     * public static void getBalanceSum(BankCustomer customer) { if
     * (customer.getAcc().size() == 0) {
     * System.out.println("No savingAccount in this user"); return; } double temp =
     * 0; for (SavingAccount i : customer.getAcc()) { temp += i.getBalance(); }
     * System.out.println("The sum of balance of user" + customer.getName() + " is "
     * + temp + " yen"); }
     * 
     * public static void setGlobalInterest(BankCustomer customer, double interest)
     * { for (SavingAccount i : customer.getAcc()) { i.setInterest(interest); }
     * System.out.println("The interest of every savingAccount has been set to " +
     * interest + " percent"); }
     * 
     * public static void setInterest(BankCustomer customer, int id, double
     * interest) { for (SavingAccount i : customer.getAcc()) { if (i.getId() == id)
     * { i.setInterest(interest);
     * System.out.println("The interest of this savingAccount has been set to " +
     * interest + " percent"); return; } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     * public static void getInterest(BankCustomer customer, int id) { for
     * (SavingAccount i : customer.getAcc()) { if (id == i.getId()) {
     * System.out.println("The interest of savingAccount id " + id + " is " +
     * i.getInterest() + " percent"); return; } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     * public static void getInterestList(BankCustomer customer) { if
     * (customer.getAcc().size() == 0) {
     * System.out.println("No savingAccount in this user"); return; }
     * System.out.println("Showing interest of accounts of " + customer.getName());
     * for (SavingAccount i : customer.getAcc()) {
     * System.out.println("The interest of savingAccount id " + i.getId() + " is " +
     * i.getInterest() + " percent"); } }
     * 
     * public static void calculateInterestGlobal(BankCustomer customer, int year) {
     * if (customer.getAcc().size() == 0) {
     * System.out.println("No savingAccount in this user"); return; } for
     * (SavingAccount i : customer.getAcc()) { for (int j = 0; j < year; j++) {
     * i.addInterest(); } } System.out.
     * println("The interest is added on every account. Showing balance...");
     * BankOperation.getBalanceList(customer); //
     * customer.setAcc(customer.getAcc()); }
     * 
     * public static void calculateInterest(BankCustomer customer, int id, int year)
     * { for (SavingAccount i : customer.getAcc()) { if (id == i.getId()) { for (int
     * j = 0; j < year; j++) { i.addInterest(); } System.out.
     * println("The interest is added on every account. Showing balance...");
     * BankOperation.getBalance(customer, id); return; } }
     * System.out.println("This savingAccount id is not found in this user"); }
     * 
     */

}