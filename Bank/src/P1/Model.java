package P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="SYSTEM";
	String passwd="SYSTEM";
	private String name;
	private int accno;
	private int balance;
	private String userid;
	private String pwd;
	private String email;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private int row;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String pwd)
	{
		this.pwd=pwd;
	}
	public Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url,user,passwd);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public boolean login()throws Exception
	{
		pstmt=con.prepareStatement("SELECT * FROM BANK WHERE USERID=? AND PWD=?");
		pstmt.setString(1,userid);
		pstmt.setString(2, pwd);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			accno=res.getInt(2);
			return true;
		}
		return false;
		}

	
public boolean balanceCheck()throws Exception
{
	pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
	pstmt.setInt(1,accno);
	res=pstmt.executeQuery();
	
	if(res.next()==true)
	{
		balance=res.getInt(3);
		return true;
	}
	return false;
}
public boolean resetPassword(String npwd)throws Exception
{
	pstmt=con.prepareStatement("UPDATE BANK SET PWD=? WHERE PWD=?");
	pstmt.setString(1,npwd);
	pstmt.setString(2,pwd);
	row = pstmt.executeUpdate();
	if(row==0)
	{
		return false;
	}
	else
	{
		return true;
	}
	
}
public boolean amountTransfer(int amt)throws Exception
{
	pstmt=con.prepareStatement("UPDATE BANK SET BALANCE =BALANCE-? WHERE ACCNO=?");
	pstmt.setInt(1, amt);
	pstmt.setInt(2, accno);
	row=pstmt.executeUpdate();
	
	pstmt=con.prepareStatement("INSERT INTO BANK_STATEMENT VALUES(?,?)");
	pstmt.setInt(1, accno);
	pstmt.setInt(2, amt);
	pstmt.executeUpdate();
	if(row==0)
	{
		return false;
	}
	else
	{
		return true;
	}
}
public ArrayList getStatement()throws Exception
{
	pstmt=con.prepareStatement("SELECT * FROM BANK_STATEMENT WHERE ACCNO=?");
	pstmt.setInt(1, accno);
	res=pstmt.executeQuery();
	ArrayList al=new ArrayList();
	
while(res.next()==true)
	{
	al.add(res.getInt(2));
	}
return al;
	}
 public boolean forgetPassword()throws Exception
 {
	 pstmt=con.prepareStatement("UPDATE BANK SET PWD=? WHERE EMAIL=?");
	 pstmt.setString(1, pwd);
	 pstmt.setString(2, email);
	 row=pstmt.executeUpdate();
	 if(row==1)
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
 }
}

	
	
	
	


