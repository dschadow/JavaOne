package de.bit.camel.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.User;

public class UsersBean {
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_FOR_USER = "select user_id, user_name from users where group_id = ?";

    public List<User> getUsersInGroup(String id) {
        RowMapper<User> mapper = new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("user_name"));
                user.setId(rs.getString("user_id"));

                return user;
            }
        };

        List<User> users = simpleJdbcTemplate.query(QUERY_FOR_USER, mapper, new Object[] {id});

        return users;
    }

    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
