package kz.anna.endterm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Client;
import kz.anna.endterm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client")
@Api(value = "ClientControllerClass", description = "This class allows to interact with Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping({ "/", "all" })  //  get all clients from db
    @ApiOperation(value = "Method to get list of users", response = List.class)
    public String  getAllClients(Model model ) {
        model.addAttribute("name", "John"); // set 'John' value for 'name' attribute

        return "pages/clientsAll"; // name of the View

    }


    @GetMapping("/create")
    @ApiOperation(value = "Method to create clients by GET mapping", response = List.class)
    public String createClientByUsernamePassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        Client client = new Client();
        client.setPassword(password);
        client.setUsername(username);

        clientService.createClient(client);
        return "New client successfully added!";
    }

    @PostMapping
    @ApiOperation(value = "Method to create clients by POST mapping", response = List.class)
    public void createClient(@RequestBody Client client) {
        System.out.println("ClientController.createClient");
        System.out.println("user = " + client);

        clientService.createClient(client);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update clients by id", response = List.class)
    public void updateClient(@PathVariable Long id,
                           @RequestBody Client client) {

        System.out.println("ClientController.updateClient");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        clientService.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete client", response = List.class)
    public void deleteClient(@PathVariable Long id) {

        System.out.println("ClientController.deleteClient");
        System.out.println("id = " + id);

        clientService.deleteClient(id);
    }
}
