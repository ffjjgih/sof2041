package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daouserimplement;
import Dao.Daousers;
import Model.User;

/**
 * Servlet implementation class Manageuser
 */
@WebServlet({
	"/Manageuser",
	"/Manageuser/edit",
	"/Manageuser/insert",
	"/Manageuser/update",
	"/Manageuser/delete"
})
public class Manageuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daousers dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manageuser() {
        super();
        this.dao=new Daouserimplement();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url=request.getRequestURL().toString();
		if(url.contains("edit")) {
			edituser(request, response);
		}else if(url.contains("delete")) {
			remoteuser(request, response);
		}
		showuser(request, response);
		request.getRequestDispatcher("/Admin/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		if(url.contains("insert")) {
			insertuser(request, response);
		}else if(url.contains("update")) {
			updateuser(request, response);
		}
		showuser(request, response);
		request.getRequestDispatcher("/Admin/User.jsp").forward(request, response);
	}

	private void showuser(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<User> lst=this.dao.xuatlstuser();
			request.setAttribute("lstuser", lst);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void insertuser(HttpServletRequest request, HttpServletResponse response) {
		try {
			User u=new User();
			BeanUtils.populate(u, request.getParameterMap());
			u.setRoles("Customer");
			this.dao.create(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void edituser(HttpServletRequest request, HttpServletResponse response){
		try {
			User u=new User();
			int id=Integer.parseInt(request.getParameter("id"));
			u=this.dao.findid(id);
			request.setAttribute("users", u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateuser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			User u=new User();
			u=this.dao.findid(id);
			BeanUtils.populate(u, request.getParameterMap());
			this.dao.update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void remoteuser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			User u=new User();
			u=this.dao.findid(id);
			this.dao.delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
