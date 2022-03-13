package kz.anna.endterm.service.impl;

import kz.anna.endterm.entity.TeamStyle;
import kz.anna.endterm.repository.TeamStyleRepository;
import kz.anna.endterm.service.TeamStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class TeamStyleServiceImpl implements TeamStyleService {

    @Autowired
    private TeamStyleRepository groupStyleRepository;

    @Override
    public List<TeamStyle> getAllGroupStyles() {
        return groupStyleRepository.findAll();
    }

    @Override
    public void createGroupStyle(TeamStyle groupStyle) {
        groupStyleRepository.saveAndFlush(groupStyle);
    }

    @Override
    public void updateGroupStyle(Long id, TeamStyle groupStyle) {
        TeamStyle userDb = groupStyleRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setTeam_id(groupStyle.getTeam_id());
            userDb.setStyle_id(groupStyle.getStyle_id());
            groupStyleRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteGroupStyle(Long id) {
        TeamStyle groupStyle = groupStyleRepository.findById(id).get();
        groupStyleRepository.delete(groupStyle);
    }
}
