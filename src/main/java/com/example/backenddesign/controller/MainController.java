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

    @GetMapping("/addUser")
    public String adduser(){

        return "addUser";
    }

    @PostMapping("/Send-Info")
    public String addingUser(WebRequest dataFromForm){

        UserIntegration addUser = new UserIntegration();

        String ID = (dataFromForm.getParameter("employeeID"));
        String name = (dataFromForm.getParameter("employeeName"));
        String job = (dataFromForm.getParameter("employeeJob"));
        String manager = (dataFromForm.getParameter("employeeManager"));
        String hire = (dataFromForm.getParameter("employeeHIRE"));
        String salary = (dataFromForm.getParameter("employeeSALARY"));
        String commission = (dataFromForm.getParameter("employeeComm"));
        String DP = (dataFromForm.getParameter("employeeDP"));



        if( addUser.addUserDB(ID,name,job,manager,hire,salary,commission,DP) == true) {
            return "redirect:/main\"";
        }else{
            return "addUser";
        }
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
