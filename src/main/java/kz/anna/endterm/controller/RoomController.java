package kz.anna.endterm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Room;
import kz.anna.endterm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@Api(value = "RoomControllerClass", description = "This class allows to interact with Room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @GetMapping("/all")  //  get all styles from db
    @ApiOperation(value = "Method to get list of rooms", response = List.class)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/create")
    @ApiOperation(value = "Method to create rooms by GET ", response = List.class)
    public void createRoomByName(@RequestParam("name") String name) {
        Room room = new Room();
        room.setName(name);
        roomService.createRoom(room);
    }


    @PostMapping
    @ApiOperation(value = "Method to create rooms by POST", response = List.class)
    public void createRoom(@RequestBody Room room) {
        System.out.println("RoomController.createRoom");
        System.out.println("room = " + room);

        roomService.createRoom(room);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update rooms by Id", response = List.class)
    public void updateRoom(@PathVariable Long id,
                            @RequestBody Room room) {

        System.out.println("RoomController.updateRoom");
        System.out.println("id = " + id);

        roomService.updateRoom(id, room);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete rooms", response = List.class)
    public void deleteRoom(@PathVariable Long id) {

        System.out.println("RoomController.deleteRoom");
        System.out.println("id = " + id);
        roomService.deleteRoom(id);
    }
}
