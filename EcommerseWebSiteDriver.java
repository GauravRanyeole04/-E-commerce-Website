package JavaPraject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EcommerseWebSiteDriver {

	public static void main(String[] args) {
		Welcome obj = new Welcome();
		obj.welcome();

	}
}

class UserDetails {
	String userName;
	String password;
	String address;
	long phoneNumber;

	public UserDetails(String userName, String password, String address, long phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return userName + "," + "address : " + address + ", phoneNumber : " + phoneNumber + ".";
	}
}

class Welcome {
	UserDetails userObject;
	HomePage homePage = new HomePage();
	Scanner sc = new Scanner(System.in);
	static {
		System.out.println("*** WELCOME ***");
		System.out.println();
		System.out.println("<-- Ecommerse WebSite -->");
		System.out.println();
	}

	public void welcome() {
		for (;;) {
			System.out.println("1. Create a new Account");
			System.out.println("2. Existing User");
			System.out.println("3. Exit");
			System.out.print("Option : ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				createAccount();
				break;
			case 2:
				loginUser();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("!! Wrong Input !!");
				System.out.println();
			}
		}
	}

	private void createAccount() {
		sc.nextLine();
		System.out.println();
		System.out.println("** Account Creation Module **");
		System.out.print("Enter your Username : ");
		String username = sc.nextLine();
		System.out.print("Enter your Password : ");
		String password = sc.next();
		sc.nextLine();
		System.out.print("Enter your address : ");
		String address = sc.nextLine();
		System.out.print("Enter your phone number : ");
		long phoneNumber = sc.nextLong();
		System.out.println();
		userObject = new UserDetails(username, password, address, phoneNumber);
	}

	private void loginUser() {

		if (userObject == null) {
			System.out.println("!!Create your account first!!");
			return;
		}
		System.out.println();
		System.out.println("** Login Module **");
		for (int i = 3; i >= 1; i--) {
			sc.nextLine();
			System.out.print(" Username : ");
			String username = sc.nextLine();
			System.out.print(" Password : ");
			String password = sc.next();
			if (this.userObject.userName.equals(username) && this.userObject.password.equals(password)) {
				homePage.categories();
			} else {
				System.out.println("Wrong Credentials");
				System.out.println("Attempts left : " + (i - 1));
			}
		}
		System.exit(0);
	}
}

class Product implements Comparable<Product> {
	String productName;
	double price;

	public Product(String productName, double price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		if (this.price < price) {
			return -1;
		} else if (this.price > o.price) {
			return 1;
		}
		return 0;
	}
}

class HomePage {

	ArrayList<Product> cart = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void categories() {
		for (;;) {
			System.out.println();
			System.out.println("Shop by Categories ---->>");
			System.out.println(" 1.Clothes 2.Footwear 3.Electronics 4.CheckOut 5.Logout");
			System.out.print("Option : ");
			int option = sc.nextInt();
			System.out.println();
			switch (option) {
			case 1:
				clothes();
				break;
			case 2:
				footwear();
				break;
			case 3:
				electronics(0);
				break;
			case 4:
				checkout();
				break;
			case 5:
				logout();
				break;
			default:
				System.out.println("!!Wrong Input!!");
			}
		}
	}

	private void checkout() {
		Collections.sort(cart);
		for(Product product : cart ) {
			System.out.println(product);
		}
		bill();
	}

	private void bill() {
		double totalBill = 0;
		for (Product product : cart) {
			totalBill += product.price;
		}
		System.out.println();
		System.out.println("Your Total Bill is : " + totalBill +" RS.");
	}

	private void logout() {
		System.out.println("*_*_*_Thank You & Visit Again_*_*_*");
		System.out.println();
		Welcome obj = new Welcome();
		obj.welcome();
	}

	private void electronics(int i) {
		String[] arr = { "Mobile(101) : 40000", "Laptop(102) : 80000", "Watch(103): 3500","Exit Electronics (0)" };
		List<String> electronics = Arrays.asList(arr);
		for (;;) {
			System.out.println("** Electronics **");
			for (String str : electronics) {
				System.out.println(str);
			}
			System.out.println();
			System.out.print("Enter a productId : ");
			int productId = sc.nextInt();
			switch (productId) {
			case 101:
				cart(new Product("Mobile ", 1000));
				break;
			case 102:
				cart(new Product("Laptop ", 1500));
				break;
			case 103:
				cart(new Product("Watch ", 1500));
				break;
			case 0:
				return;
			default:
				System.out.println("!! Wrong Input !!");
				System.out.println();
			}
		}
	}

	private void footwear() {
		String[] arr = { "Shoes(104) : 3000", "Crocs(105) : 2500", "FilpFlop(106) : 1200 ","Exit Footwear (0)" };
		List<String> electronics = Arrays.asList(arr);
		for (;;) {
			System.out.println("** Footwear **");
			for (String str : electronics) {
				System.out.println(str);
			}
			System.out.println();
			System.out.print("Enter a productId : ");
			int productId = sc.nextInt();
			switch (productId) {
			case 104:
				cart(new Product("Shoes ", 3000));
				break;
			case 105:
				cart(new Product("Crocs ", 2500));
				break;
			case 106:
				cart(new Product("Filpflop ", 1200));
				break;
			case 0:
				return;
			default:
				System.out.println("!! Wrong Input !!");
				System.out.println();
			}
		}

	}

	private void clothes() {
		String[] arr = { "Shirt(107) : 1000", "Jeans(108) : 1500","Exit Clothes (0)"};
		List<String> electronics = Arrays.asList(arr);
		for (;;) {
			System.out.println("** Clothes **");
			for (String str : electronics) {
				System.out.println(str);
			}
			System.out.println();
			System.out.print("Enter a productId : ");
			int productId = sc.nextInt();
			switch (productId) {
			case 107:
				cart(new Product("Shirt ", 1000));
				break;
			case 108:
				cart(new Product("Jeans ", 1500));
				break;
			case 0:
				return;
			default:
				System.out.println("!! Wrong Input !!");
				System.out.println();
			}
		}
	}

	private void cart(Product product) {
		System.out.println("---Product added inside cart Successfully---");
		System.out.println();
		cart.add(product);

	}
}
