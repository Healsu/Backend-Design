package com.example.backenddesign.controller;

import com.example.backenddesign.models.employee;
import com.example.backenddesign.repository.CRUDInterface;
import com.example.backenddesign.repository.EmployeeDepository;
import com.example.backenddesign.service.UserIntegration;
import com.example.backenddesign.utility.DatabaseConnector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    EmployeeDepository employeeTest = new EmployeeDepository();


    @GetMapping("/main")
    public String mainSite(){
        DatabaseConnector.getConnection();

        return "Homepage";
    }

    @PostMapping("/Send-Info")
    public String addingUser(WebRequest dataFromForm, HttpSession session, Model model){

        return null;
    }
    @PostMapping("/Find-Info-Single")
    public String findUser(WebRequest dataFromForm, Model model) {
        UserIntegration user = new UserIntegration();
        String userInput = (dataFromForm.getParameter("userID"));
        List theUser = user.returnUser(userInput);

        if (theUser != null) {
           model.addAttribute("OneUser",theUser);
            return "showUser";
        } else {
            return "Homepage";
        }
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model){
        List allUsers;
        allUsers = employeeTest.getAllEmployees();
        model.addAttribute("allCurrentUsers",allUsers);
        return "SeeAllUsers";
    }
    @GetMapping("/SeeOneUser")
   public String show(){

        return "SeeOneUser";
    }
}
