package vn.codegym.baithi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    private List<Question> questions;
    private String name;

    public QuestionType() {
    }

    public QuestionType(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
