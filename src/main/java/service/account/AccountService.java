package service.account;

import model.Account;
import service.printer.Printer;

/**
 * 
 * @author izarati
 *
 */
public interface AccountService {

	public void deposit(Account account, double amount);

	public void withdraw(Account account, double amount);

	public void printStatement(Account account, Printer printer);

}
