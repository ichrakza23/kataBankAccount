package service.printer;

import org.springframework.stereotype.Service;

import model.Transaction;

/**
 * 
 * @author izarati
 *
 */
@Service
public class MockPrinter implements Printer {

	private StringBuilder output;

	public MockPrinter() {
		output = new StringBuilder();
	}

	@Override
	public void printHeader() {
		output.append("Statement:\n");
		output.append("Date\t\tAmount\tBalance\n");
	}

	@Override
	public void printTransaction(Transaction transaction) {
		output.append(transaction.getDate()).append("\t").append(transaction.getAmount()).append("\t")
				.append(transaction.getBalance()).append("\n");
	}

	public String getOutput() {
		return output.toString();
	}

}
