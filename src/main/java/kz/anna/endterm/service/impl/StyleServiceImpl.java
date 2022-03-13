package kz.anna.endterm.service.impl;
import kz.anna.endterm.entity.Style;
import kz.anna.endterm.repository.StyleRepository;
import kz.anna.endterm.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleRepository styleRepository;

    @Override
    public List<Style> getAllStyles() {
        return styleRepository.findAll();
    }

    @Override
    public void createStyle(Style style) {
        styleRepository.saveAndFlush(style);
    }

    @Override
    public void updateStyle(Long id, Style style) {
        Style userDb = styleRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setName(style.getName());
            styleRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteStyle(Long id) {
        Style style = styleRepository.findById(id).get();
        styleRepository.delete(style);
    }
}
