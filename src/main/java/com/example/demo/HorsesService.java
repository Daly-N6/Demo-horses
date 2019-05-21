package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.*;

import java.util.List;

@Component
public class HorsesService {
    @Autowired
    private JdbcTemplate HorseTemplate;
    public List findAll() {
        return HorseTemplate.query(
            "SELECT microchip, horsename, DateOfBirth FROM Horses",
                (rs, rowNum) -> new Horses(rs.getLong("microchip"),
                rs.getString("horseName"), rs.getDate("dateOfBirth")));
    }
    public void update(Horses Horses) {
        HorseTemplate.update(
            "UPDATE Horses SET microchip=?, horsename=?, DateOfBirth=? WHERE id=?",
            Horses.getMicrochip(), Horses.getHorseName(), Horses.getDateOfBirth());
    }
}
