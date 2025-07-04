/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storereceiving;

import com.databaseCon.DB;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

 
public class OrderData {
    public void insertData(OrderC obj){
        
        DB.loadConnection();
        
        try{
            String query = "INSERT INTO customer_order (customer_order_no, customer_order_date, item_id, quantity) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, obj.getOrderNo());
            ps.setString(2, obj.getOrderDate());
            ps.setInt(3, obj.getItemId());
            ps.setInt(4, obj.getQuantity());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "You have saved Order succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void updateData(OrderC obj){
        
        DB.loadConnection();
                
        try{
            String query = "Update customer_order set customer_order_no= ?, customer_order_date = ?, item_id = ?, quantity = ? where id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setString(1, obj.getOrderNo());
            ps.setString(2, obj.getOrderDate());
            ps.setInt(3, obj.getItemId());
            ps.setInt(4, obj.getQuantity());
            ps.setInt(5, obj.getOrderId());
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Order updated succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void deleteData(int id){
        
        DB.loadConnection();
                
        try{
            String query = "Delete from customer_order where id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Order deleted succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public List<OrderC> loadData(){
        
        DB.loadConnection();
        
        List<OrderC> list = new ArrayList<OrderC>();
        
        try{
            String query = "Select * from customer_order";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int orderId = rs.getInt("id");
                String orderNo = rs.getString("customer_order_no");
                String orderDate = rs.getString("customer_order_date");
                int itemId = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                
                OrderC obj = new OrderC(orderId, orderNo, orderDate, itemId, quantity);
                list.add(obj);
                
            }
            JOptionPane.showMessageDialog(null, "You have saved Order succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
        
        return list;
    }
    
    public OrderC loadOrderData(int id){
        OrderC obj = null;
        try{
            String query = "Select * from customer_order where id =" +id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int orderId = rs.getInt("id");
                String orderNo = rs.getString("customer_order_no");
                String orderDate = rs.getString("customer_order_date");
                int itemId = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                
                obj = new OrderC(orderId, orderNo, orderDate, itemId, quantity);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " "+ e);
        }
        return obj;
    }

}

