package example.controller;


import example.models.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bank")
public class BankAPIController {


    @GetMapping("/savings/new")
    public String showSavingsAccountForm(Model model) {
        model.addAttribute("account", new AccountForm());
        return "savingsAccountForm";
    }

    @PostMapping("/savings")
    public String createSavingsAccount(@ModelAttribute("account") AccountForm accountForm) {
        String accountNumber = accountForm.getAccountNumber();
        String accountHolderName = accountForm.getAccountHolderName();

        Account account = new SavingsAccount(accountNumber, accountHolderName);
        accounts.put(accountNumber, account);

        return "redirect:/accounts/" + accountNumber;
    }

    @GetMapping("/current/new")
    public String showCurrentAccountForm(Model model) {
        model.addAttribute("account", new AccountForm());
        return "currentAccountForm";
    }

    @PostMapping("/current")
    public String createCurrentAccount(@ModelAttribute("account") AccountForm accountForm) {
        String accountNumber = accountForm.getAccountNumber();
        String accountHolderName = accountForm.getAccountHolderName();

        Account account = new CurrentAccount(accountNumber, accountHolderName);
        accounts.put(accountNumber, account);

        return "redirect:/accounts/" + accountNumber;
    }

    @GetMapping("/{accountNumber}")
    public String showAccountDetails(@PathVariable String accountNumber, Model model) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            model.addAttribute("account", account);
            return "accountDetails";
        }
        return "accountNotFound";
    }

    private Map<String, Account> accounts;

    public BankAPIController() {
        this.accounts = new HashMap<>();
    }




    @PostMapping("/{accountNumber}/deposit")
    public String deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return "Deposit successful";
        }
        return "Account not found";
    }

    @PostMapping("/{accountNumber}/withdraw")
    public String withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            return "Withdrawal successful";
        }
        return "Account not found";
    }

    @GetMapping("/{accountNumber}/transact ions")
    public List<Transaction> getTransactionHistory(@PathVariable String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getTransactionHistory();
        }
        return null;
    }
}
