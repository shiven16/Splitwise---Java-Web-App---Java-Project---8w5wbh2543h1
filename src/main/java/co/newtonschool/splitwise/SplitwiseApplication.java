package co.newtonschool.splitwise;

import co.newtonschool.splitwise.repository.ExpenseRepository;
import co.newtonschool.splitwise.repository.UserExpenseRepository;
import co.newtonschool.splitwise.repository.UserRepository;
import co.newtonschool.splitwise.service.ExpenseService;
import co.newtonschool.splitwise.service.ExpenseServiceImpl;
import co.newtonschool.splitwise.service.UserService;
import co.newtonschool.splitwise.service.UserServiceImpl;
// import com.sun.tools.javac.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication {
	private static ExpenseRepository expenseRepository;
	private static UserRepository userRepository;
	private static UserExpenseRepository userExpenseRepository;
	private static ExpenseService expenseService;
	private static UserService userService;

	static {
		expenseRepository = new ExpenseRepository();
		userRepository = new UserRepository();
		userExpenseRepository = new UserExpenseRepository();
		expenseService = new ExpenseServiceImpl();
		userService = new UserServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	public static ExpenseRepository getExpenseRepository() {
		return expenseRepository;
	}

	public static UserRepository getUserRepository() {
		return userRepository;
	}

	public static UserExpenseRepository getUserExpenseRepository() {
		return userExpenseRepository;
	}

	public static ExpenseService getExpenseService() {
		return expenseService;
	}

	public static UserService getUserService() {
		return userService;
	}
}
