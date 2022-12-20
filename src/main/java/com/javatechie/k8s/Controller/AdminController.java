package com.javatechie.k8s.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.k8s.Model.Admin;
import com.javatechie.k8s.Repo.AdminRepo;

@RestController //tells the ide that this class is a rest controller and we are going to have endpoints
@RequestMapping("/api")
public class AdminController 
{
    @Autowired
    private AdminRepo adminRepo;
    
    //ang:getAll()
    @GetMapping(value="/admins")
    public List<Admin> getUsers()
    {
       return adminRepo.findAll();
    }

    //ang: getAdmin(id)
    @GetMapping(value="/admins/{id}")
    public Optional<Admin> getById(@PathVariable long id)
    {
       return  adminRepo.findById(id);

    }


    //ang:register(Admin)
    @PostMapping("/admins")
    public String signUp (@RequestBody Admin admin)
    {
        
        adminRepo.save(admin);
        return"Account successfully saved";
    }


    @GetMapping("/admins/signIn")
    public String signIn (@RequestBody Admin admin)
    {
        for(Admin a : adminRepo.findAll())
        {
            if(a.getfullName().equals(admin.getfullName()) && a.getPassword().equals(admin.getPassword()) )
            {
                return "welcome " ;
            }
        
        }
        
        return "account does not exist";  

    }



    @DeleteMapping(value="/delete/{id}")
    public String deleteAdmin(@PathVariable long id)
    {
      Admin deletedAdmin= adminRepo.findById(id).get();
      adminRepo.delete(deletedAdmin);
      return "deleted admin successfully..";
    }

    

    // @PostMapping(value="/save")
    // public String saveAdmin(@RequestBody Admin admin)
    // {
    //   adminRepo.save(admin);
    //   return "saved successfully..";
    // }

    // @PutMapping(value="/update/{id}")
    // public String updateAdmin(@PathVariable long id, @RequestBody Admin admin) //we put id param bec we are passing it in the url
    // {
    //   Admin targetAdmin= adminRepo.findById(id).get();
    //   targetAdmin.setfullName(admin.getfullName());
    //   targetAdmin.setPassword(admin.getPassword());
    //   adminRepo.save(targetAdmin);
    //   return "updated successfully..";
    // }

    
}
