package kz.anna.endterm.service;

import kz.anna.endterm.entity.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllGroups();
    void createGroup(Team group);
    void updateGroup(Long id, Team group);
    void deleteGroup(Long id);
}
