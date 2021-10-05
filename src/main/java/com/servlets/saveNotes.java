package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.note;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class saveNotes
 */
public class saveNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveNotes() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			note note = new note(title, content, new Date());
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(note);
			tx.commit();
			session.close();

			// after save note send response
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<h2>Note is added successfully</h2>");
//			System.out.println("Note added successfully");
			response.sendRedirect("allNotes.jsp");


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
