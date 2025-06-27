package basicofjava;
import java.util.Scanner;

public class BasicJavaCode {
	public static void main(String[] args)
	{
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter your name:");
		String name=scanner.nextLine();
		System.out.println("enter your age:");
		int age=scanner.nextInt();
		System.out.printf("hi "+name+",your age "+age);
		
		scanner.close();
		
		
		
	}

}
