package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daouserimplement;
import Dao.Daousers;
import Model.User;

@WebServlet({"/Registration",
	"/Registration/login"
})
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daousers daousers;
	private User u;
    public Registration() {
        super();
        this.daousers=new Daouserimplement();
        this.u=new User();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Customer/Registration.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURI().toString();
		if(url.contains("login")) {
			createuser(request, response);
		}
		request.getRequestDispatcher("/Login").forward(request, response);
	}

	private void createuser(HttpServletRequest request, HttpServletResponse response) {
		try {
			User u1=new User();;
			u1.setRoles("Customer");
			BeanUtils.populate(u1, request.getParameterMap());
			this.daousers.create(u1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
