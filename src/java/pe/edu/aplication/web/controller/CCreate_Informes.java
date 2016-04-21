/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.aplication.web.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.application.dao.Create_InformesDao;

/**
 *
 * @author HectorSH
 */
@WebServlet(name = "CCreate_Informes", urlPatterns = {"/create_informe"})
public class CCreate_Informes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<String, Object> rpta = new HashMap<String, Object>();
        
         //rpta.put("mensaje","error");
           // Gson gson = new Gson();
           
             //rpta.put("lista", rpta)
           //  rpta.put("lista",rpta);
           try {
      // La siguiente línea es para poder apreciar el efecto AJAX.
      Thread.currentThread().sleep(2000);
      // Dato
      String codigo = request.getParameter("codigo");
      // Proceso
    Create_InformesDao model = new Create_InformesDao();
      List<Map<String, ?>> lista = model.listar_alumnado(codigo);
      String json = "{\n" +
"  \"data\": [\n" +
"    {\n" +
"      \"name\": \"Tiger Nixon\",\n" +
"      \"position\": \"System Architect\",\n" +
"      \"salary\": \"$320,800\",\n" +
"      \"start_date\": \"2011/04/25\",\n" +
"      \"office\": \"Edinburgh\",\n" +
"      \"extn\": \"5421\"\n" +
"    },\n" +
"    {\n" +
"      \"name\": \"Garrett Winters\",\n" +
"      \"position\": \"Accountant\",\n" +
"      \"salary\": \"$170,750\",\n" +
"      \"start_date\": \"2011/07/25\",\n" +
"      \"office\": \"Tokyo\",\n" +
"      \"extn\": \"8422\"\n" +
"    } ]}";
      rpta.put("lista", json);
    } catch (Exception e) {
      rpta.put("mensaje", e.getMessage());
    }
            Gson gson = new Gson();
            out.print(gson.toJson(rpta));
            out.flush();
            out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
