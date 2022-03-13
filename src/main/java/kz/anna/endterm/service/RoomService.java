package kz.anna.endterm.service;

import kz.anna.endterm.entity.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    void createRoom(Room room);
    void updateRoom(Long id, Room room);
    void deleteRoom(Long id);
}
