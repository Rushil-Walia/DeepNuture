package com.cognizant.ormlearn.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="at_id")
    private int id;

    @Column(name="at_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "attempt_question",
            joinColumns = @JoinColumn(name = "aq_at_id"),
            inverseJoinColumns = @JoinColumn(name = "aq_qu_id"))
    private Set<Question> questions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "attempt_option",
            joinColumns = @JoinColumn(name = "ao_at_id"),
            inverseJoinColumns = @JoinColumn(name = "ao_op_id"))
    private Set<Options> selectedOptions;

    public Attempt() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Options> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Set<Options> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
