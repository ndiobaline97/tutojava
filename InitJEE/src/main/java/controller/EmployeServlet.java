package controller;

import model.Employe;
import model.Service;
import model.User;
import service.EmployeDao;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name="employe", urlPatterns="/employe")

public class EmployeServlet extends HttpServlet {
    EmployeDao employeDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Charge une page de redirection
        String action=req.getParameter("action");
        employeDao = new EmployeDao();
        switch (action){
            case "add":
                req.setAttribute("employes",employeDao.findEmployes());
                req.setAttribute("services",employeDao.findServices());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action=req.getParameter("action");
        employeDao = new EmployeDao();

        switch (action){
            case "add":

                try {
                    req.setAttribute("employes",employeDao.findEmployes());
                    String matricule = req.getParameter("matricule");
                    String nom = req.getParameter("nom");
                    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate Datenaiss = LocalDate.parse(req.getParameter("date"),df);
                    String telephone = req.getParameter("tel");
                    int salaire = Integer.parseInt(req.getParameter("salaire"));
                    int ids= Integer.parseInt(req.getParameter("idservice"));
                    Service s = new Service();
                    s.setId(ids);
                    Employe e = new Employe();
                    e.setDateNaiss(Datenaiss);
                    e.setMatricule(matricule);
                    e.setSalaire(salaire);
                    e.setNom(nom);
                    e.setTelephone(telephone);
                    e.setServiceId(s);
                    employeDao.addEmploye(e);
                } catch (Exception ex) {
                    req.setAttribute("error","erreur dans l'insertion");

                    ex.printStackTrace();
                }
                req.setAttribute("services",employeDao.findServices());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
        }


    }
}