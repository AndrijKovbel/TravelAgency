package com.kovbel.agency.agency.dao;

import com.kovbel.agency.agency.dao.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Info info){
        String sql="INSERT  INTO infoukraine( tour, country, price) VALUES ('"+info.getCountry()+"','"+info.getTour()+"','"+info.getPrice()+"')";
        return jdbcTemplate.update(sql);
    }
    public int update(Info info){
        String sql="UPDATE infoukraine SET tour = ?, country= ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, info.getTour(), info.getCountry(), info.getPrice(), info.getId());
    }
    public int delete(int id){
        String sql="DELETE FROM infoukraine WHERE id=" + id + " ";
        return jdbcTemplate.update(sql);
    }
    public Info getEmpById(int id){
        String sql="SELECT * FROM infoukraine WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Info>(Info.class));
    }
    public List<Info> getMyList(){
        return jdbcTemplate.query("SELECT * FROM infoukraine", (rs, row) -> {
            Info info = new Info();
            info.setId(rs.getInt(1));
            info.setCountry(rs.getString(2));
            info.setTour(rs.getString(3));
            info.setPrice(rs.getInt(4));
            return info;
        });
    }
}
