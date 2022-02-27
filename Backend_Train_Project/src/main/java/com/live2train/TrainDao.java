package com.live2train;
import java.util.*;  
import java.sql.*;  
  
public class TrainDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Train e){  
        int status=0;  
        try{  
            Connection con=TrainDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into test.traindata(cname,ccode,address,scapacity,coffered,cemail,cnumber) values (?,?,?,?)");  
            ps.setString(1,e.getCname());  
            ps.setString(2,e.getCcode());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getScapacity()); 
            ps.setString(5,e.getCoffered());
            ps.setString(6,e.getCemail());
            ps.setString(7,e.getCnumber());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Train e){  
        int status=0;  
        try{  
            Connection con=TrainDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update test.traindata set cname=?,code=?,caddress=?,ccapacity,coffered,cemail,cnumber, where id=?");  
            ps.setString(1,e.getCname());  
            ps.setString(2,e.getCcode());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getScapacity()); 
            ps.setString(5,e.getCoffered());
            ps.setString(6,e.getCemail());
            ps.setString(7,e.getCnumber());
            ps.setInt(8,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=TrainDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from test.traindata where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Train getEmployeeById(int id){  
        Train e=new Train();  
          
        try{  
            Connection con=TrainDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from test.traindata where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setCname(rs.getString(2));  
                e.setCcode(rs.getString(3));  
                e.setAddress(rs.getString(4));  
                e.setCoffered(rs.getString(6));  
                e.setCemail(rs.getString(7));
                e.setCnumber(rs.getString(8));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Train> getAllData(){  
        List<Train> list=new ArrayList<Train>();  
          
        try{  
            Connection con=TrainDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from test.traindata");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Train e=new Train();  
                e.setId(rs.getInt(1));  
                e.setCname(rs.getString(2));  
                e.setCcode(rs.getString(3));  
                e.setAddress(rs.getString(4));  
                e.setCoffered(rs.getString(5)); 
                e.setCemail(rs.getString(6));
                e.setCnumber(rs.getString(7));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
