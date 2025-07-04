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

 
public class SupplierData {
    public void insertData(SupplierC obj){
        
        DB.loadConnection();
        
        try{
            String query = "INSERT INTO supplier (supplier_name, supplier_tel, supplier_address, supplier_email) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, obj.getSupplierName());
            ps.setString(2, obj.getSupplierTel());
            ps.setString(3, obj.getSupplierAddress());
            ps.setString(4, obj.getSupplierEmail());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "You have saved Supplier succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void updateData(SupplierC obj){
        
        DB.loadConnection();
                
        try{
            String query = "Update supplier set supplier_name = ?, supplier_tel = ?, supplier_address = ?, supplier_email = ? where supplier_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setString(1, obj.getSupplierName());
            ps.setString(2, obj.getSupplierTel());
            ps.setString(3, obj.getSupplierAddress());
            ps.setString(4, obj.getSupplierEmail());
            ps.setInt(5, obj.getSupplierId());
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Supplier updated succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void deleteData(int id){
        
        DB.loadConnection();
                
        try{
            String query = "Delete from supplier where supplier_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Supplier deleted succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public List<SupplierC> loadData(){
        
        DB.loadConnection();
        
        List<SupplierC> list = new ArrayList<SupplierC>();
        
        try{
            String query = "Select * from supplier";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int supplierId = rs.getInt("supplier_id");
                String supplierName = rs.getString("supplier_name");
                String supplierTel = rs.getString("supplier_tel");
                String supplierAddress = rs.getString("supplier_address");
                String supplierEmail = rs.getString("supplier_email");
                
                SupplierC obj = new SupplierC(supplierId, supplierName, supplierTel, supplierAddress, supplierEmail);
                list.add(obj);
                
            }
            JOptionPane.showMessageDialog(null, "You have saved Supplier succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
        
        return list;
    }
    
    public SupplierC loadSupplierData(int id){
        SupplierC obj = null;
        try{
            String query = "Select * from supplier where supplier_id =" +id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int supplierId = rs.getInt("supplier_id");
                String supplierName = rs.getString("supplier_name");
                String supplierTel = rs.getString("supplier_tel");
                String supplierAddress = rs.getString("supplier_address");
                String supplierEmail = rs.getString("supplier_email");
                
                obj = new SupplierC(supplierId, supplierName, supplierTel, supplierAddress, supplierEmail);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " "+ e);
        }
        return obj;
    }

}


