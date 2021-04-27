/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author Dell
 */
public class UserService {
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection connection;
    
    public UserService ()
    {
        connection=DataSource.getInstance().getCnx();
    }
    
    public void ajouterUser(User u) 
    {
        String req="insert into user(nom,prenom,adress,type,email,roles,password,Speciality,reset_token,is_confirmed,is_activated,age) values('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getAdress()+"','"+u.getType()+"','"+u.getEmail()+"','"+u.getRoles()+"', '"+u.getPassword()+"', '"+u.getSpeciality()+"', '"+u.getReset_token()+"', '"+u.getIs_confirmed()+"','"+u.getIs_activated()+"', '"+u.getAge()+"')";
    
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public List<User> readAll()
   {
       String req="select * from user";
      ObservableList<User>  list = FXCollections.observableArrayList();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"), rs.getString("type"), rs.getString("email"),rs.getString("roles"),rs.getString("password"),rs.getString("Speciality"),rs.getString("reset_token"),rs.getString("is_confirmed"),rs.getString("is_activated") , rs.getString("Age")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
   }
 
  
   public void updateUser(String id,String nom){
String req = "UPDATE user SET nom='" + nom + "' WHERE id = '" + id + "' ";    
      try {
            ste=connection.createStatement();
         int   rs=ste.executeUpdate(req);
            if ( rs >0)
            {
                System.out.println("l'utilisateur a été bien modifier");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
  } 
    public void DeleteUser(String id) {
        
          String req="DELETE From user WHERE id= '" + id + "'";
    
      try {
            ste=connection.createStatement();
         int   rs=ste.executeUpdate(req);
            if ( rs >0)
            {
                System.out.println("l'utilisateur a été supprimé ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<User> readmy(String mychar) {
        ArrayList<User> form = new ArrayList<>();
       
          String req="SELECT * FROM user WHERE nom LIKE '%" + mychar + "%' ";
        try {
            ste=connection.createStatement();
              rs=ste.executeQuery(req);
              while (rs.next()) {
              form.add(new User(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"), rs.getString("type"), rs.getString("email"),rs.getString("roles"),rs.getString("password"),rs.getString("Speciality"),rs.getString("reset_token"),rs.getString("is_confirmed"),rs.getString("is_activated") , rs.getString("Age")) );
           
        }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return form;
    }
//    public void RechercherUser( String nom ) {
//        
//         String req="SELECT * FROM user WHERE nom ='"+nom+"'";
//     
//         try {
//              ste=connection.createStatement();
//              rs=ste.executeQuery(req);
//              rs.last();
//              int nbrRow= rs.getRow();
//              if (nbrRow!=0) {
//                System.out.println("l'utilisateur a été bien trouvé ");  
//              }
//              else {
//                 System.out.println("Utilisateur non trouvé ! ");    
//              }
//         }
//        catch (SQLException ex) {
//            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//}
    
   public boolean login (String email, String password)
   {
        String req="SELECT * FROM user WHERE  email ='"+email+"' and password ='"+password+"'";
                try {
                  ste=connection.createStatement();
                  rs=ste.executeQuery(req);
                  if (rs.next ()) {
                      return true;
                  }
                }
               catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return false;
   }
      public List<User> TriUser()
   {
       String req="SELECT * FROM user\n" +
"ORDER BY Age DESC;";
       List<User> list= new ArrayList<>();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"), rs.getString("type"), rs.getString("email"),rs.getString("roles"),rs.getString("password"),rs.getString("Speciality"),rs.getString("reset_token"),rs.getString("is_confirmed"),rs.getString("is_activated") , rs.getString("Age")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
   }
      
        public List<Integer> CountUser() throws SQLException
   { 
       String req="SELECT COUNT(*) FROM user ";
       
        
            List<Integer> nb = new ArrayList<>();
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
         while(rs.next()){
       
         nb.add(rs.getInt(1));
        
        }
         
         return nb;
   }
}

