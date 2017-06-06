package com.dashboard.contoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.helper.FERSDataConnection;



@Controller
public class DefaultController {

	private Connection connection = null;
	private PreparedStatement statement = null;	
	private ResultSet resultSet = null;
	
	@RequestMapping("/resources")
	public ModelAndView newVisitor() throws Exception {
		System.out.println("inside controller");
		ModelAndView mv = new ModelAndView();
		ArrayList<String[]> resourcelist = new ArrayList<String[]>();
			
		Connection connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement("select * from resources");
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			String[] eventObject = new String[8];
			eventObject[0] = resultSet.getString("ntid");
			eventObject[1] = resultSet.getString("first_name");
			eventObject[2] = resultSet.getString("last_name");
			eventObject[3] = resultSet.getString("email");
			eventObject[4] = resultSet.getString("shift");
			eventObject[5] = resultSet.getString("contact_number");
			resourcelist.add(eventObject);
			
		}
		
		
		resultSet.close();
		FERSDataConnection.closeConnection();
		System.out.println(resourcelist);	
		mv.addObject("resourcelist",resourcelist);
		mv.setViewName("/index.jsp");
		return mv;
	}

	
}
