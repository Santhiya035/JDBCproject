package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DriverClass {

	private static Scanner scan=new Scanner(System.in);

	// to create the connection
	static Connection toCreateConnection() {
		Connection connection=null;
		try {
			String userName="root";
			String password="Santy@99";
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library",userName,password);
		}
		catch(Exception object) {
			System.out.println(object);
		}
		return connection;
	}

	// to perform the operations like add,update,delete,search using switch cases
	static void toCheckCases() throws Exception {
		DatabaseLibrary obj=new DatabaseLibrary();

		System.out.println("Enter a number from the below options which you want to perform: ");
		System.out.print("1.Add the books"+ '\n'+"2.Display all books" +'\n'+ "3.Search a book"+'\n'+ "4.Delete a book" +'\n'+ "5.Update book" +'\n'+"6.Exit " );
		Connection connectingToDatabase=toCreateConnection();
		System.out.println();
		System.out.println("Enter the Choice");
		byte choice;
		do {
			choice=scan.nextByte();		

			switch(choice) {
			case 1:
				obj.add_record(connectingToDatabase);
				break;
			case 2:
				obj.display_all(connectingToDatabase);
				break;
			case 3:
				obj.search_by_id(connectingToDatabase);
				break;
			case 4:
				obj.delete_by_id(connectingToDatabase);
				break;
			case 5:
				obj.update_by_id(connectingToDatabase);
				break;
			case 6:
				Library.toLogout();
				connectingToDatabase.close();
			}
		}
		while(choice!=6); {

		}
	}


	public static void main(String[] args) throws Exception{

		System.out.println("Enter the Login UserName: ");
		String username=scan.nextLine();
		System.out.println("Enter the Login Password: ");
		String password=scan.nextLine();
		Library.toCheckLogin(username, password); //method call to check login details
	}

}

