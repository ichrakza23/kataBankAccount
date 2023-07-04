package service.account;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import exception.InvalidAmountException;
import model.Account;
import model.Transaction;
import service.printer.Printer;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	@Qualifier("ConsolePrinter")
	private Printer printer;

	@Override
	public void deposit(Account account, double amount) throws InvalidAmountException {
		validateAmount(amount);
		account.setBalance(account.getBalance() + amount);
		List<Transaction> transactions = account.getTransactions();
		transactions.add(new Transaction(LocalDate.now(), amount, account.getBalance()));
		account.setTransactions(transactions);

	}

	@Override
	public void withdraw(Account account, double amount) throws InvalidAmountException {
		validateAmount(amount);
		if (amount > account.getBalance()) {
			throw new InvalidAmountException("Insufficient funds");
		}
		account.setBalance(account.getBalance() - amount);
		List<Transaction> transactions = account.getTransactions();
		transactions.add(new Transaction(LocalDate.now(), -amount, account.getBalance()));
		account.setTransactions(transactions);

	}

	@Override
	public void printStatement(Account account) {
		printer.printHeader();
		List<Transaction> transactions = account.getTransactions();
		Collections.sort(transactions, new Comparator<Transaction>() {
		    @Override
		    public int compare(Transaction t1, Transaction t2) {
		    	return t1.getDate().compareTo(t2.getDate());
	    }});
		transactions.forEach(transaction ->printer.printTransaction(transaction));
	}

	private void validateAmount(double amount) throws InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Invalid amount");
		}
	}

}
