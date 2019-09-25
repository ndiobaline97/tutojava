package service;

import model.Employe;
import model.Service;
import model.User;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeDao {
    public void addEmploye(Employe e) throws Exception{
        try{
            String sql = "INSERT INTO employe values (null,?,?,?,?,?,?)";
            DatabaseHelper db = DatabaseHelper.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1,e.getMatricule());
            db.getPstmt().setString(2,e.getNom());
            db.getPstmt().setString(3,e.getTelephone());
            db.getPstmt().setString(4,e.getDateNaiss().toString());
            db.getPstmt().setInt(5,e.getSalaire());
            db.getPstmt().setInt(6,e.getServiceId().getId());
            db.My_ExecutePrepareUpdate();

        }catch (Exception ex){
            throw ex;
        }
    }
    public List<Employe> findEmployes(){
        List<Employe> employes = new ArrayList<>();
        try {
                String sql= "SELECT * FROM employe e,service s WHERE e.ServiceId=s.ServiceId";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (rs.next()){
                Employe em = new Employe();
                em.setId(rs.getInt(1));
                em.setMatricule(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTelephone(rs.getString(4));
                em.setDateNaiss(LocalDate.parse(rs.getString(5),df));
                em.setSalaire(rs.getInt(6));
                Service s = new Service();
                s.setId(rs.getInt(8));
                s.setLibelle(rs.getString(9));
                em.setServiceId(s);
                employes.add(em);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return employes;

    }
    public List<Service> findServices(){
        List<Service> services = new ArrayList<>();
        try{
            String sql = "SELECT * FROM service";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            while (rs.next()){
                Service s = new Service();
                s.setId(rs.getInt(1));
                s.setLibelle(rs.getString(2));
                services.add(s);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return services;
    }

}