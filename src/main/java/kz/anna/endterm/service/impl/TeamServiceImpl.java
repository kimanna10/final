package kz.anna.endterm.service.impl;
import kz.anna.endterm.entity.Team;
import kz.anna.endterm.repository.TeamRepository;
import kz.anna.endterm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository groupRepository;

    @Override
    public List<Team> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void createGroup(Team group) {
        groupRepository.saveAndFlush(group);
    }

    @Override
    public void updateGroup(Long id, Team group) {
        Team userDb = groupRepository.findById(id).get();
        userDb.setName(group.getName());
        userDb.setChoreographer_id(group.getChoreographer_id());
        groupRepository.saveAndFlush(userDb);

    }

    @Override
    public void deleteGroup(Long id) {
        Team group = groupRepository.findById(id).get();
        groupRepository.delete(group);
    }
}
