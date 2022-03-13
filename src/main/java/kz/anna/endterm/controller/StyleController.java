package kz.anna.endterm.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Client;
import kz.anna.endterm.entity.Style;
import kz.anna.endterm.entity.TeamStyle;
import kz.anna.endterm.service.StyleService;
import kz.anna.endterm.service.TeamStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/style")
@Api(value = "StyleControllerClass", description = "This class allows to interact with Style")
public class StyleController {

    @Autowired
    private StyleService styleService;

    @Autowired
    private TeamStyleService teamStyleService;

    @GetMapping("/all")  //  get all styles from db
    @ApiOperation(value = "Method to get list of styles", response = List.class)
    public List<Style> getAllStyles() {
        return styleService.getAllStyles();
    }

    @GetMapping("/create")
    @ApiOperation(value = "Method to create styles by GET ", response = List.class)
    public void createGroupByName(@RequestParam("name") String name) {
        Style style = new Style();
        style.setName(name);

        styleService.createStyle(style);
    }

    @GetMapping("/assign") //assign style to team
    @ApiOperation(value = "Method to assign styles to team ", response = List.class)
    public void assignStyleToTeam(@RequestParam("style") Long style_id, @RequestParam("team") Long team_id) {
        TeamStyle groupStyle = new TeamStyle();
        groupStyle.setStyle_id(style_id);
        groupStyle.setTeam_id(team_id);

        teamStyleService.createGroupStyle(groupStyle);
    }

    @PutMapping("/updateStyleFor/{id}")  // update style for group
    @ApiOperation(value = "Method to update styles for team", response = List.class)
    public void updateStyleFor(@PathVariable Long id,
                            @RequestBody TeamStyle style) {

        System.out.println("StyleController.updateStyleFor");
        System.out.println("id = " + id);

        teamStyleService.updateGroupStyle(id, style);
    }

    @DeleteMapping("/deleteStyleFor/{id}")
    @ApiOperation(value = "Method to delete styles for team", response = List.class)
    public void deleteStyleFor(@PathVariable Long id) {

        System.out.println("StyleController.deleteStyleFor");
        System.out.println("id = " + id);

        teamStyleService.deleteGroupStyle(id);
    }

    @PostMapping
    @ApiOperation(value = "Method to create styles by POST", response = List.class)
    public void createStyle(@RequestBody Style style) {
        System.out.println("StyleController.createStyle");
        System.out.println("style = " + style);

        styleService.createStyle(style);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update styles by Id", response = List.class)
    public void updateStyle(@PathVariable Long id,
                             @RequestBody Style style) {

        System.out.println("StyleController.updateStyle");
        System.out.println("id = " + id);

        styleService.updateStyle(id, style);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete styles", response = List.class)
    public void deleteStyle(@PathVariable Long id) {

        System.out.println("StyleController.deleteStyle");
        System.out.println("id = " + id);
        deleteStyleFor(id);
        styleService.deleteStyle(id);
    }

}
