package kz.anna.endterm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Client;
import kz.anna.endterm.entity.Team;
import kz.anna.endterm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@Api(value = "TeamControllerClass", description = "This class allows to interact with Team")
public class TeamController {

    @Autowired
    private TeamService groupService;

    @GetMapping("/all")  //  get all groups from db
    @ApiOperation(value = "Method to get list of groups", response = List.class)
    public List<Team> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/create")
    @ApiOperation(value = "Method to create groups by GET", response = List.class)
    public void createGroupByName(@RequestParam("name") String name, @RequestParam("choreo") Long id) {
        Team group = new Team();
        group.setName(name);
        group.setChoreographer_id(id);
        groupService.createGroup(group);
    }

    @PostMapping
    @ApiOperation(value = "Method to create groups by POST", response = List.class)
    public void createGroup(@RequestBody Team group) {
        System.out.println("GroupController.createGroup");
        System.out.println("group = " + group);

        groupService.createGroup(group);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update groups by Id", response = List.class)
    public void updateGroup(@PathVariable Long id,
                             @RequestBody Team team) {

        System.out.println("TeamController.updateGroup");
        System.out.println("id = " + id);

        groupService.updateGroup(id, team);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete groups", response = List.class)
    public void deleteGroup(@PathVariable Long id) {

        System.out.println("TeamController.deleteGroup");
        System.out.println("id = " + id);

        groupService.deleteGroup(id);
    }
}
