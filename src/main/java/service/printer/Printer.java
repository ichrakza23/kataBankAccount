package service.printer;

import model.Transaction;

/**
 * 
 * @author izarati
 *
 */
public interface Printer {
	void printHeader();
    void printTransaction(Transaction transaction);
}
