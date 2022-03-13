package kz.anna.endterm.service;


import kz.anna.endterm.entity.Style;

import java.util.List;

public interface StyleService {

    List<Style> getAllStyles();
    void createStyle(Style style);
    void updateStyle(Long id, Style style);
    void deleteStyle(Long id);
}
