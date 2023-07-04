package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author izarati
 *
 */

@Data
public class Account {
	private double balance;
	private List<Transaction> transactions;

	public Account() {
		balance = 0.0;
		transactions = new ArrayList<>();
	}

}
