package service.printer;

import lombok.extern.slf4j.Slf4j;
import model.Transaction;

/**
 * 
 * @author izarati
 *
 */
@Slf4j
public class ConsolePrinter implements Printer {

	@Override
	public void printHeader() {
		ConsolePrinter.log.info("Statement:");
		ConsolePrinter.log.info("Date\t\tAmount\tBalance");

	}

	@Override
	public void printTransaction(Transaction transaction) {
		
		ConsolePrinter.log
				.info(transaction.getDate() + "\t" + transaction.getAmount() + "\t" + transaction.getBalance());

	}

}
