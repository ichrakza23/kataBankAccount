package service.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import exception.InvalidAmountException;
import model.Account;
import service.printer.ConsolePrinter;

class AccountServiceImplTest {

	private Account account;

	@InjectMocks
	private AccountServiceImpl accountService;

	@Mock
	private ConsolePrinter printer;

	@BeforeEach
	void setup() {
		account = new Account();
		MockitoAnnotations.openMocks(this);

	}

	@Test
	void depositShouldIncreaseBalance() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		assertEquals(100.0, account.getBalance());
	}

	@Test
	void depositWithNegativeAmountShouldThrowException() {
		assertThrows(InvalidAmountException.class, () -> accountService.deposit(account, -50.0));
	}

	@Test
	void depositWithZeroAmountShouldThrowException() {
		assertThrows(InvalidAmountException.class, () -> accountService.deposit(account, 0.0));
	}

	@Test
	void withdrawShouldDecreaseBalance() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		accountService.withdraw(account, 20.0);
		assertEquals(80.0, account.getBalance());
	}

	@Test
	void withdrawWithNegativeAmountShouldThrowException() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		assertThrows(InvalidAmountException.class, () -> accountService.withdraw(account, -50.0));
	}

	@Test
	void withdrawWithZeroAmountShouldThrowException() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		assertThrows(InvalidAmountException.class, () -> accountService.withdraw(account, 0.0));
	}

	@Test
	void withdrawWithInsufficientFundsShouldThrowException() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		assertThrows(InvalidAmountException.class, () -> accountService.withdraw(account, 150.0));
	}

	@Test
	void printStatementShouldCallPrinterMethods() throws InvalidAmountException {
		accountService.deposit(account, 100.0);
		accountService.withdraw(account, 20.0);
		accountService.printStatement(account);
		verify(printer).printHeader();
		verify(printer).printTransaction(account.getTransactions().get(0));
		verify(printer).printTransaction(account.getTransactions().get(1));
	}
}
