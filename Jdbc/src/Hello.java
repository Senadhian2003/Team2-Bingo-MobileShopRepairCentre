import java.sql.*;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hello {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		String url="jdbc:mysql://sql3.freesqldatabase.com:3306/sql3476613";
		String username="sql3476613";
		String password="wnPBt3gz2n";
		
		
		try {
			
	        
			

	         Date thisDate =new Date();
	         SimpleDateFormat dateForm= new SimpleDateFormat("YYYY-MM-dd");
	        
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection connection=DriverManager.getConnection(url,username,password);
			
			Statement statement=connection.createStatement();
	        while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" 1.Enter customer details\n 2.Update Cost Involved\n 3.Report in range of date\n 4.Total Report\n");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				int token=(int)Math.floor(Math.random()*10000);
				System.out.println("Your Tokennumber is"+token);
				System.out.print ("enter Your name:");
				String name=sc.next();
				System.out.print ("enter Mobile no:");
				int no=sc.nextInt();
				
				
				System.out.print ("Enter your problem in detail");
				sc.nextLine();
				String prob=sc.nextLine();
				
				String query1 = "INSERT INTO `first`(`token`, `name`, `mobile`, `date`, `descrip`) VALUES ("+token+",'"+name+"',"+no+",'"+dateForm.format(thisDate)+"','"+prob+"')";
         	    statement.executeUpdate(query1);
         	    System.out.println("Data added successfully....");
         	    break;
			}
  			
			case 2:
			{
			  System.out.println("Enter the id to update:");
  			  int x=sc.nextInt();
  			  System.out.println("Enter the cost");
  			  int c=sc.nextInt();
  			  String query2 = "UPDATE `first` SET `cost`='"+c+"' WHERE `token`="+x+"";
     	      statement.executeUpdate(query2);
     	      System.out.println("Updated successfully.....");
     	      break;
  				
  				
  			}
			case 3:
			{
				String lachi=sc.next();
				String mola=sc.next();
				
				ResultSet resultSet = statement.executeQuery("select * from `first` where `date` between '"+lachi+"' and '"+mola+"' ");
	        	 while(resultSet.next()) {
						
	  				System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2)+ " " + resultSet.getInt(3)+" "+ resultSet.getString(4)+" "+ resultSet.getString(5));
	  			
				  }
			}
			case 4:
			{
				ResultSet resultSet1 = statement.executeQuery("select * from first");
	        	 while(resultSet1.next()) {
						
	  				System.out.println(resultSet1.getInt(1)+ " " + resultSet1.getString(2)+ " " + resultSet1.getInt(3)+" "+ resultSet1.getString(4)+" "+ resultSet1.getString(5)+" "+resultSet1.getInt(6));
	  			
				  }
				
			}
			}
			System.out.println("press 1 to continue and 0 to stop");
			int fin=sc.nextInt();
			if(fin==1)
			{
				continue;
			}
			else {
				break;
			}
	        }
	         
			
			
			connection.close();
				
				
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		

	}

}