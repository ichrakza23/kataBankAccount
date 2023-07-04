package service.account;

import exception.InvalidAmountException;
import model.Account;
import service.printer.Printer;

/**
 * 
 * @author izarati
 *
 */
public interface AccountService {
	/**
	 * deposit an amount to actual account
	 * @param account
	 * @param amount
	 * @throws InvalidAmountException
	 */
	public void deposit(Account account, double amount) throws InvalidAmountException;

	/**
	 * withdraw an amount from actual account
	 * @param account
	 * @param amount
	 * @throws InvalidAmountException
	 */
	public void withdraw(Account account, double amount) throws InvalidAmountException;

	/**
	 * 
	 * @param account
	 */
	public void printStatement(Account account);

}
