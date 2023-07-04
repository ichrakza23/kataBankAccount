package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author izarati
 *
 */

@Data
@AllArgsConstructor
public class Transaction {
	private LocalDate date;
	private double amount;
	private double balance;
}
