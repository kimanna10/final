package kz.anna.endterm.service;

import kz.anna.endterm.entity.TeamStyle;

import java.util.List;

public interface TeamStyleService {

    List<TeamStyle> getAllGroupStyles();
    void createGroupStyle(TeamStyle groupStyle);
    void updateGroupStyle(Long id, TeamStyle groupStyle);
    void deleteGroupStyle(Long id);
}
