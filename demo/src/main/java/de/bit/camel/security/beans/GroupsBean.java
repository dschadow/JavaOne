package de.bit.camel.security.beans;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class GroupsBean {
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_FOR_ID = "select group_id from groups where group_name = ?";
    
    public String getGroupId(String name) {
        String id = simpleJdbcTemplate.queryForObject(QUERY_FOR_ID, String.class, new Object[] {name});
        
        return id;
    }

    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
