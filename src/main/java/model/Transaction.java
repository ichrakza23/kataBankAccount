package model;

import java.time.LocalDate;

import enums.OperationType;
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
	private OperationType operationType;
}
