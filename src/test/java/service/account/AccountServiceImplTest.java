package service.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import model.Account;

class AccountServiceImplTest {

	private Account account;

	@InjectMocks
	private AccountServiceImpl accountService;

	@BeforeEach
	void setup() {
		account = new Account();
		MockitoAnnotations.openMocks(this);

	}

	@Test
	void depositShouldIncreaseBalance() {
		accountService.deposit(account, 100.0);
		assertEquals(100.0, account.getBalance());
	}

	@Test
	void depositWithNegativeAmountShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> accountService.deposit(account, -50.0));
	}

	@Test
	void depositWithZeroAmountShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> accountService.deposit(account, 0.0));
	}

	@Test
	void withdrawShouldDecreaseBalance() {
		accountService.deposit(account, 100.0);
		accountService.withdraw(account, 50.0);
		assertEquals(50.0, account.getBalance());
	}

	@Test
	void withdrawWithNegativeAmountShouldThrowException() {
		accountService.deposit(account, 100.0);
		assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, -50.0));
	}

	@Test
	void withdrawWithZeroAmountShouldThrowException() {
		accountService.deposit(account, 100.0);
		assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, 0.0));
	}

	@Test
	void withdrawWithInsufficientFundsShouldThrowException() {
		accountService.deposit(account, 100.0);
		assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, 150.0));
	}

}
