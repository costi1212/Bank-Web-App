package servlets;

import models.Account;
import repositories.AccountRepository;
import repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/mainpagehello")
public class MainPageHelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("userName");
        request.setAttribute("name", name);

        List<Account> accounts=new ArrayList<>();
        try {
            accounts= AccountRepository.getAllAccountsForUser(UserRepository.getUserByUsername(name));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(accounts);
        request.setAttribute("accounts", accounts);

        request.getRequestDispatcher("mainpagehello.jsp").forward(request, response);
    }
    //userCredentials = URLDecoder.decode(userCredentials);
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String userName= request.getParameter("userName");
        userName = URLDecoder.decode(userName);
        String nrCardcont=request.getParameter("nrCardcont");
        System.out.println(nrCardcont);
        String suma_de_adaugat=request.getParameter("suma");
        //System.out.println(request.getParameter("kontrol"));
        //int kontrol=Integer.parseInt(request.getParameter("kontrol"));
        //System.out.println(userName);
        //System.out.println(nrCardcont);
        //System.out.println(suma_de_adaugat);
        //if(kontrol==0)
        try {
            Account account=AccountRepository.findAccoutbynrCard(nrCardcont);
            AccountRepository.increase_amount(account,suma_de_adaugat);

            response.sendRedirect(request.getContextPath() + "/mainpagehello?userName=" + userName);
            //AccountRepository.decrease_amount(account,suma_de_adaugat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //else if(kontrol==1){
            //try {
                //Account account=AccountRepository.findAccoutbynrCard(nrCardcont);
                //AccountRepository.decrease_amount(account,suma_de_adaugat);

               // response.sendRedirect(request.getContextPath() + "/mainpagehello?userName=" + userName);
                //AccountRepository.decrease_amount(account,suma_de_adaugat);
            //} catch (SQLException e) {
               // e.printStackTrace();
           //}
        }


    }

