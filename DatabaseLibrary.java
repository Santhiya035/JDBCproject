package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseLibrary {
	private static Scanner obj=new Scanner(System.in);

	//to add the records into the table
	void add_record(Connection connection) throws SQLException {
		PreparedStatement pstmt=connection.prepareStatement("INSERT INTO LibraryBookDetails values (?,?,?,?,?,?)");
		System.out.println("Enter the BookId:");
		pstmt.setByte(1,obj.nextByte());
		System.out.println("Enter the BookName:");
		pstmt.setString(2,obj.next());
		System.out.println("Enter the AuthorName:");
		pstmt.setString(3,obj.next());
		System.out.println("Enter the Journal:");
		pstmt.setString(4,obj.next());
		System.out.println("Enter the Edition:");
		pstmt.setInt(5,obj.nextInt());
		System.out.println("Enter the NoOfCopies:");
		pstmt.setByte(6,obj.nextByte());
		int resultSet=pstmt.executeUpdate();
		System.out.println(resultSet+" Record Inserted");

	}

	//to display all the records of the table
	void display_all(Connection connection) throws SQLException {

		Statement stmt=connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM LibraryBookDetails");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1) +"    "+ resultSet.getString(2) +"    "+resultSet.getString(3)+"    "+resultSet.getString(4)+"    "+resultSet.getInt(5)+"     "+resultSet.getInt(6));
		}
	}

	// to search a book by its BookId
	void search_by_id(Connection connection) throws SQLException  {

		PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM LibraryBookDetails WHERE BookId=?");
		System.out.println("Enter the BookId:");
		byte value=obj.nextByte();
		pstmt.setByte(1,value);
		ResultSet resultSet =pstmt.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1) +"    "+ resultSet.getString(2) +"    "+resultSet.getString(3)+"    "+resultSet.getString(4)+"    "+resultSet.getInt(5)+"     "+resultSet.getInt(6));
		}
	}

	// to delete a book by its BookId
	void delete_by_id(Connection connection) throws SQLException {

		PreparedStatement pstmt=connection.prepareStatement("DELETE FROM LibraryBookDetails WHERE BookId=?");
		System.out.println("Enter the BookId you want to delete: ");
		byte value=obj.nextByte();
		pstmt.setByte(1,value);
		int resultSet=pstmt.executeUpdate();
		System.out.println(resultSet +" record is deleted");
	}

	//to update the book details by its BookId
	void update_by_id(Connection connection) throws SQLException  {

		PreparedStatement pstmt=connection.prepareStatement("UPDATE LibraryBookDetails set NoOfCopies=? WHERE BookId=? ");
		System.out.println("Enter the BookId you want to update:");
		pstmt.setByte(2,obj.nextByte());
		System.out.println("Enter how many copies you want");
		pstmt.setByte(1,obj.nextByte());
		int resultSet=pstmt.executeUpdate();
		System.out.println(resultSet+" Record Updated");
	}


}
