package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.note;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class deleteNotes
 */
public class deleteNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int noteId = Integer.parseInt(request.getParameter("note_id"));

			// called Factory session methods
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			note n = session.get(note.class, noteId);
			System.out.println(n.getId());
			session.delete(n);
			tx.commit();
			session.close();
			response.sendRedirect("allNotes.jsp");

		} catch (Exception error) {
			error.printStackTrace();
		}
	}
 
}
