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
 
public class updateNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateNotes() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
		    String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			 
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			note note = session.get(note.class, noteId);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
//			session.save(note);  // no need to save only commit() it work , because it is persistant stage
			tx.commit();
			session.close();
 
			response.sendRedirect("allNotes.jsp");


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
