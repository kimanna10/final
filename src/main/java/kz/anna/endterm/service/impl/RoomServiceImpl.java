package kz.anna.endterm.service.impl;

import kz.anna.endterm.entity.Room;
import kz.anna.endterm.entity.Style;
import kz.anna.endterm.repository.RoomRepository;
import kz.anna.endterm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void createRoom(Room room) {
        roomRepository.saveAndFlush(room);
    }

    @Override
    public void updateRoom(Long id, Room room) {
        Room userDb = roomRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setName(room.getName());
            roomRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).get();
        roomRepository.delete(room);
    }
}
