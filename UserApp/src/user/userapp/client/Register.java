package user.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.ValidationServiceImpl;

public class Register {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name:");
		String Username=scanner.next();
		ValidationServiceImpl validationservice=new ValidationServiceImpl();
		try {
			if(validationservice.validateUsername(Username)) {
				System.out.println("Enter password");
				String password=scanner.next();
				if(validationservice.validatePassword(password)) {
					System.out.println("Hi user");
				}
					
			}
		}catch(NameExistsException|TooShortException|TooLongException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("--");
		}
		scanner.close();
		
	}

}
