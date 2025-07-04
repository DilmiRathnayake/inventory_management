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

 
public class CategoryData {
    public void insertData(CategoryC obj){
        
        DB.loadConnection();
        
        try{
            String query = "INSERT INTO category (category_name, category_description) VALUES(?, ?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getCategoryDescription());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "You have saved category succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void updateData(CategoryC obj){
        
        DB.loadConnection();
                
        try{
            String query = "Update category set category_name = ?, category_description = ? where category_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setString(1, obj.getCategoryName());
            ps.setString(2, obj.getCategoryDescription());
            ps.setInt(3, obj.getCategoryId());
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Category updated succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public void deleteData(int id){
        
        DB.loadConnection();
                
        try{
            String query = "Delete from category where category_id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Category deleted succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
    }
    
    public List<CategoryC> loadData(){
        
        DB.loadConnection();
        
        List<CategoryC> list = new ArrayList<CategoryC>();
        
        try{
            String query = "Select * from category";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String categoryDescription = rs.getString("category_description");
                
                CategoryC obj = new CategoryC(categoryId, categoryName, categoryDescription);
                list.add(obj);
                
            }
            JOptionPane.showMessageDialog(null, "You have saved category succesfully");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " " + e);
        }
        
        return list;
    }
    
    public CategoryC loadCategoryData(int id){
        CategoryC obj = null;
        try{
            String query = "Select * from category where category_id =" +id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String categoryDescription = rs.getString("category_description");
                
                obj = new CategoryC(categoryId, categoryName, categoryDescription);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, " "+ e);
        }
        return obj;
    }

}
