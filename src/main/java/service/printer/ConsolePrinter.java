package service.printer;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import model.Transaction;

/**
 * 
 * @author izarati
 *
 */
@Slf4j
@Service
public class ConsolePrinter implements Printer {

	@Override
	public void printHeader() {
		ConsolePrinter.log.info("Statement:");
		ConsolePrinter.log.info("Operation\tDate\t\tAmount\tBalance");

	}

	@Override
	public void printTransaction(Transaction transaction) {

		ConsolePrinter.log.info(transaction.getOperationType().toString() + "\t" + transaction.getDate() + "\t"
				+ transaction.getAmount() + "\t" + transaction.getBalance());

	}

}
