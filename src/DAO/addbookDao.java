package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.addbookBean;
import bean.addbookqtyBean;
import bean.libraryBean;
import bean.library_addressBean;
import bean.library_book_mappingBean;
import util.DBConnection;


public class addbookDao {
	 private final Connection con;	
		public addbookDao()  throws ClassNotFoundException, SQLException {
			//System.out.println("hii shilpi in database");
	        con = DBConnection.getInstance().getConnection();   
	    }
		
		public List<addbookBean> getAllcategory(){
		      List<addbookBean> category =new ArrayList<addbookBean>();
		      Statement stmt;
		      addbookBean b;
		      try {
		        System.out.println("llllll");
		    	  stmt = con.createStatement();        
		          ResultSet rs = stmt.executeQuery("select * from category");
		         
		          while ( rs.next() ) 
		          {
		              b = new addbookBean();
		              b.setCategory_id(rs.getInt("category_id"));
		              b.setCategory_name(rs.getString("category_name"));
		              System.out.println("dao"+rs.getString("category_name"));
		              category.add( b );
		          }    
		    	  
		      }  catch(SQLException e) {
		          System.out.println("dao"+e);
		      }
		      System.out.println("ccccc");
		      return category;
		}
		

		public int addbook(String book_title,String author,int edition,String publisher,String isbn,int pages,int mrp,int categorys,String description,int publish_year,String book_language,String strDate,String modified_on,int status,int count,int librarys) {
			int n=0;
			int id = 0;
			try {
				String query="insert into book values(null,'"+book_title+"','"+author+"',"+edition+",'"+publisher+"','"+isbn+"',"+pages+","+mrp+",'img/product/1.jpg',"+categorys+",'"+description+"',"+publish_year+",'"+book_language+"',0,'"+strDate+"','"+
						modified_on+"');";
				
			
				Statement stmt = con.createStatement();
				n = stmt.executeUpdate( query );
				if(n>0)
				{
					System.out.println("Inserted");
					String Query="SELECT book_id from book  order by book_id desc limit 1";
					Statement Stmt = con.createStatement();
					ResultSet rs = Stmt.executeQuery( Query );
					System.out.println("rs is sss:"+Query);
					while(rs.next()) {
					 id=rs.getInt("book_id");
					}
					System.out.println("Id:::" +id);
					String qry="Insert into library_book_mapping values(null,"+librarys+","+id+","+count+",'"+strDate+"')";
					Statement stmt1 = con.createStatement();
					int x = stmt1.executeUpdate( qry );
					System.out.println("value of x: "+x);
				}
				else
				{
					System.out.println("not");
				}
				
				
				
				
			}
			 catch(SQLException e) {
		            System.out.println(e.getMessage());
		        }
			
			return n;
			
		}
		
		
		public List<addbookqtyBean>getallbook()
		
		{
			List<addbookqtyBean> bookList =new ArrayList<addbookqtyBean>();
		      Statement stmt;
		      addbookqtyBean b;
		      int cnt=0;
		      try {
		    	  
		    	  stmt = con.createStatement();  
		    	 
		    	  
		          ResultSet rs = stmt.executeQuery("select * from book as b,category as c,library_book_mapping as lbm,library_address as la Where b.category_id=c.category_id and b.status=0 and lbm.book_id=b.book_id and la.library_address_id=lbm.branch_id");
		          
		          while(rs.next())
		          {
		        	  b= new addbookqtyBean();
		        	  b.setBook_id(rs.getInt("book_id"));
		        	  b.setBook_title(rs.getString("book_title"));
		        	  b.setAuthor(rs.getString("author"));
		        	  b.setEdition(rs.getInt("edition"));
		        	  b.setPublisher(rs.getString("publisher"));
		        	  b.setIsbn(rs.getString("isbn"));
		        	  b.setPages(rs.getInt("pages"));
		        	  b.setMrp(rs.getInt("mrp"));
		        	  b.setPhoto(rs.getString("photo"));
		        	  b.setCategory_name(rs.getString("category_name"));
		              b.setDescription(rs.getString("description"));
		              b.setPublish_year(rs.getInt("publish_year"));
		              b.setBook_language(rs.getString("book_language"));
		              b.setCount(rs.getInt("count"));
		              b.setBranch_name(rs.getString("branch_name"));
		              
		              bookList.add(b);
		          }
		          }
		      catch(Exception e) {
		    	  System.out.println("dao"+e);
		      		}
		      return bookList;
		         
		          
		      	}
		
public List<library_book_mappingBean>getAllLibraryAddress()
		
		{
			List<library_book_mappingBean> librarylist =new ArrayList<library_book_mappingBean>();
		      Statement stmt;
		      library_book_mappingBean l;
		      
		      try {
		        
		    	  stmt = con.createStatement();  
		    	  
		    	 
		    	  ResultSet rs=stmt.executeQuery("select library_book_mapping.count, library_book_mapping.book_id,library_address.library_address_id,library_address.branch_name from library_book_mapping,library_address,book Where library_book_mapping.book_id=book.book_id and library_address.library_address_id=library_book_mapping.branch_id ");
		         // ResultSet rs = stmt.executeQuery("select book.book_id,book.book_title,book.author,book.edition,book.publisher,book.isbn,book.pages,book.mrp,book.photo,book.description,book.publish_year,book.book_language,category.category_id,category.category_name from book,category Where book.category_id=category.category_id and book.status=0");
		          
		          while(rs.next())
		          {
		        	 // System.out.println("count is"+count);
		        	  l= new library_book_mappingBean();
		        	  l.setCount(rs.getInt("count"));
		        	
		              librarylist.add(l);
		          }
		          }
		      catch(Exception e) {
		    	  System.out.println("dao"+e);
		      		}
		      return librarylist;
		         
		          
		      	}
		
		
public List<addbookBean>getBookById(int id)
		
		{
			List<addbookBean> bookList =new ArrayList<addbookBean>();
			
			
			
		      Statement stmt,Stmt;
		      addbookBean b;
		     int cnt=0;
		      try {
		    	  Stmt=con.createStatement();
		          ResultSet Rs=Stmt.executeQuery("Select count from library_book_mapping Where book_id="+id+"");
		          while(Rs.next())
		          {
		        	// cnt=new addbookBean();
		        	 cnt=Rs.getInt("count");
		        	// bookList.add(cnt);
		          }
		        
		    	  stmt = con.createStatement();        
		          ResultSet rs = stmt.executeQuery("select book.book_id, book.book_title,book.author,book.edition,book.publisher,book.isbn,book.pages,book.mrp,book.photo,book.description,book.publish_year,book.book_language,category.category_id,category.category_name from book,category Where book.category_id=category.category_id and book.book_id=" + id + " ");
		          
		          
		          while(rs.next() )
		          {
		        	  b= new addbookBean();
		        	  b.setBook_id(rs.getInt("book_id"));
		        	  b.setBook_title(rs.getString("book_title"));
		        	  b.setAuthor(rs.getString("author"));
		        	  b.setEdition(rs.getInt("edition"));
		        	  b.setPublisher(rs.getString("publisher"));
		        	  b.setIsbn(rs.getString("isbn"));
		        	  b.setPages(rs.getInt("pages"));
		        	  b.setMrp(rs.getInt("mrp"));
		        	  b.setPhoto(rs.getString("photo"));
		        	  b.setCategory_name(rs.getString("category_name"));
		              b.setDescription(rs.getString("description"));
		              b.setPublish_year(rs.getInt("publish_year"));
		              b.setBook_language(rs.getString("book_language"));
		              b.setCount(cnt);
		              bookList.add(b);
		          }
		          
		         
		          
		          }
		      catch(Exception e) {
		    	  System.out.println("dao"+e);
		      		}
		      return bookList;
		         
		          
		      	}


/*public List<library_book_mappingBean>getcountById(int id)

{
		List <library_book_mappingBean>book=new ArrayList<library_book_mappingBean>();
	
      Statement stmt;
      library_book_mappingBean lb = null;
      try {
        
    	 
          Stmt=con.createStatement();
          ResultSet Rs=stmt.executeQuery("Select count from library_book_mapping Where book_id="+id+"");
          while(Rs.next())
          {
        	  lb.setCount(Rs.getInt("count"));
        	  book.add(lb);
        	  
          }
          }
      catch(Exception e) {
    	  System.out.println("dao"+e);
      		}
      return book;
         
          
      	}*/


		int i=1;
		
public Boolean deleteBook(int id) {
	
	String sql = "UPDATE book SET status=" + i + " WHERE book_id = " + id + "; ";
    int n=0;
    try {
    	System.out.println("In try2");
        Statement stmt = con.createStatement();
        n = stmt.executeUpdate( sql );
    }
    catch(SQLException e) {
        System.out.println(e.getMessage());
    }
    return n>0;
}

public int updatebook(String book_title,String author,int edition,String publisher,String isbn,int pages,int mrp,int categorys,String description,int publish_year,String book_language,String modified_on,int id,int count) {
	int n=0;
	int x=0;
	System.out.println("in update"+categorys+id);
	//int id=0;
	try {
		
		
		String query="Update book set book_title='" + book_title + "' , author='" + author+"', edition="+edition+", publisher='"+publisher+"', isbn='"+isbn+"',pages="+pages+",mrp= "+mrp+", category_id= "+categorys+",description= '"+description+"',publish_year="+publish_year+",book_language='"+book_language+"',modified_on='"+modified_on+"'where book_id= " + id + "";
		//String query="update admin set email= '" + email + "' , password='" + password + "' where admin_id = " + id + " ; "; 
		String Query="Update library_book_mapping set count="+count+" where book_id="+id+"";
		System.out.println(Query);
		System.out.println(query);
		Statement Stmt=con.createStatement();
		Statement stmt = con.createStatement();
		n = stmt.executeUpdate( query );
		x=Stmt.executeUpdate(Query);
		
		
		
		
	}
	 catch(SQLException e) {
            System.out.println(e.getMessage());
        }
	return n;
	
	
}
		      

public List<library_addressBean> getAllLibrary(){
    List<library_addressBean> library =new ArrayList<library_addressBean>();
    Statement stmt;
    library_addressBean b;
    try {
      System.out.println("llllll");
  	  stmt = con.createStatement();        
        ResultSet rs = stmt.executeQuery("select * from library_address");
       
        while ( rs.next() ) 
        {
            b = new library_addressBean();
            b.setLibrary_address_id(rs.getInt("library_address_id"));
            b.setBranch_name(rs.getString("branch_name"));
            System.out.println("dao"+rs.getString("branch_name"));
          library.add( b );
        }    
  	  
    }  catch(SQLException e) {
        System.out.println("dao"+e);
    }
    System.out.println("ccccc");
    return library;
}

			
	
}


