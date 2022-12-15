package main.entities;

import main.DbContext;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Problem {
    private Integer problem_id;
    private String title;
    private String description;
    private String path;
    private String user_name;
    private Date created_at;
    private String last_editor;
    private Date last_edited_at;
    private String edit_description;

    public void insert() throws SQLException {
        try (PreparedStatement s = DbContext.getConnection().
                prepareStatement("INSERT INTO \"problem\" (title, description, path, user_name, create_at) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            s.setString(1, title);
            s.setString(2, description);
            s.setString(3, path);
            s.setString(4, user_name);
            s.setDate(5, (java.sql.Date) created_at);
            s.executeUpdate();
        }
    }
    public void delete() throws SQLException {
        try (PreparedStatement s = DbContext.getConnection().prepareStatement("DELETE FROM \"problem\" WHERE problem_id = ?")) {
            s.setInt(1, problem_id);
            s.executeUpdate();
        }
    }

    public void update()throws SQLException {
        try(PreparedStatement s = DbContext.getConnection().
                prepareStatement("UPDATE \"problem\" SET title = ?, description = ?, path = ?, user_name = ?, create_at = ?, last_editor = ?, last_edited_at = ?, edit_description = ? WHERE problem_id = ?")){
            s.setString(1, title);
            s.setString(2, description);
            s.setString(3, path);
            s.setString(4, user_name);
            s.setDate(5, (java.sql.Date) created_at);
            s.setString(6, last_editor);
            s.setDate(7, (java.sql.Date) last_edited_at);
            s.setString(8, edit_description);
            s.executeUpdate();
        }
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    private Integer category_id;

    public String getLast_editor() {
        return last_editor;
    }

    public void setLast_editor(String last_editor) {
        this.last_editor = last_editor;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getEdit_description() {
        return edit_description;
    }

    public void setEdit_description(String edit_description) {
        this.edit_description = edit_description;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEdited_at(Date last_edited_at) {
        this.last_edited_at = last_edited_at;
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }

    public String getUser_name() {
        return user_name;
    }

    public Date getEdited_at() {
        return last_edited_at;
    }
}
