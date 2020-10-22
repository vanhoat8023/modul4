package vn.codegym.baithi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @NotEmpty(message = "khong de trong")
    private String title;
    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "idQuestionType")
    private QuestionType questionType;
    private String dateCreate;
   @ManyToOne
   @JoinColumn(name = "idUser")
   private User user;
   private String status;

    public Question() {
    }

    public Question(String title, String question, String answer, QuestionType questionType, String dateCreate, User user, String status) {
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.user = user;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
