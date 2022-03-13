package kz.anna.endterm.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Choreographer;
import kz.anna.endterm.entity.Client;
import kz.anna.endterm.entity.Team;
import kz.anna.endterm.service.ChoreographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choreo")
@Api(value = "ChoreographerControllerClass", description = "This class allows to interact with Choreographer")
public class ChoreographerController {

    @Autowired
    private ChoreographerService choreographerService;

    @GetMapping("/all")  //  get all choreographers from db
    @ApiOperation(value = "Method to get list of choreographers", response = List.class)
    public List<Choreographer> getAllChoreographers() {
        return choreographerService.getAllChoreographers();
    }

    @GetMapping("/create")
    @ApiOperation(value = "Method to create choreographers by GET", response = List.class)
    public void createChoreographerByName(@RequestParam("name") String name) {
        Choreographer choreographer = new Choreographer();
        choreographer.setName(name);

        choreographerService.createChoreographer(choreographer);
    }

    @PostMapping
    @ApiOperation(value = "Method to create choreographers by POST", response = List.class)
    public void createChoreographer(@RequestBody Choreographer choreographer) {
        System.out.println("ChoreographerController.createChoreographer");
        System.out.println("choreographer = " + choreographer);

        choreographerService.createChoreographer(choreographer);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update choreographers", response = List.class)
    public void updateChoreographer(@PathVariable Long id,
                            @RequestBody Choreographer choreo) {

        System.out.println("TeamController.updateChoreographer");
        System.out.println("id = " + id);

        choreographerService.updateChoreographer(id, choreo);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete choreographers", response = List.class)
    public void deleteChoreographer(@PathVariable Long id) {

        System.out.println("ChoreographerController.deleteChoreographer");
        System.out.println("id = " + id);

        choreographerService.deleteChoreographer(id);
    }
}
