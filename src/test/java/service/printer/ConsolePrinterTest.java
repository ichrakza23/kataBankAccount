package service.printer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import enums.OperationType;
import model.Transaction;

class ConsolePrinterTest {
	private Transaction transaction;

	@InjectMocks
	private MockPrinter printer;

	@BeforeEach
	void setup() {
		transaction = new Transaction(LocalDate.of(2013, 7, 4), 50, 1000, OperationType.DEPOSIT);
		MockitoAnnotations.openMocks(this);

	}

	@Test
	void printTransactionTest() {
		printer.printTransaction(transaction);
		assertEquals("DEPOSIT	2013-07-04	50.0	1000.0\n", printer.getOutput());
	}

}
