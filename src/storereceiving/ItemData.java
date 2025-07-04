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

 
public class ItemData {
    public void insertData(ItemC obj){
        
        DB.loadConnection();
        
        try{
            String query = "INSERT INTO item (item_name, item_description, quantity, category_id, supplier_id) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, obj.getItemName());
            ps.setString(2, obj.getItemDescription());
            ps.setInt(3, obj.getQuantity());
            ps.setInt(4, obj.getCategoryId());
            ps.setInt(5, obj.getSupplierId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "You have saved item succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void updateData(ItemC obj){
        
        DB.loadConnection();
                
        try{
            String query = "Update item set item_name = ?, item_description = ?, quantity = ?, category_id = ?, supplier_id = ? where item_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setString(1, obj.getItemName());
            ps.setString(2, obj.getItemDescription());
            ps.setInt(3, obj.getQuantity());
            ps.setInt(4, obj.getCategoryId());
            ps.setInt(5, obj.getSupplierId());
            ps.setInt(6, obj.getItemId());
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Item updated succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void updateQuantity(ItemC obj){
        
        DB.loadConnection();
                
        try{
            String query = "Update item set quantity = ? where item_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setInt(1, obj.getQuantity());
            ps.setInt(2, obj.getItemId());
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Item updated succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void deleteData(int id){
        
        DB.loadConnection();
                
        try{
            String query = "Delete from item where item_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Item deleted succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public List<ItemC> loadData(){
        
        DB.loadConnection();
        
        List<ItemC> list = new ArrayList<ItemC>();
        
        try{
            String query = "Select * from item";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int itemId = rs.getInt("item_id");
                String itemName = rs.getString("item_name");
                String itemDescription = rs.getString("item_description");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                int supplierId = rs.getInt("supplier_id");
                
                ItemC obj = new ItemC(itemId, itemName, itemDescription, quantity, categoryId, supplierId);
                list.add(obj);
                
            }
            JOptionPane.showMessageDialog(null, "You have saved Item succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
        
        return list;
    }
    
    public ItemC loadItemData(int id){
        ItemC obj = null;
        try{
            String query = "Select * from item where item_id =" +id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int itemId = rs.getInt("item_id");
                String itemName = rs.getString("item_name");
                String itemDescription = rs.getString("item_description");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                int supplierId = rs.getInt("supplier_id");
                
                obj = new ItemC(itemId, itemName, itemDescription, quantity, categoryId, supplierId);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " "+ e);
        }
        return obj;
    }

}
