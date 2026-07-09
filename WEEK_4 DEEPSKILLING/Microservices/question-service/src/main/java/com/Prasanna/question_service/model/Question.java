package com.Prasanna.question_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;


@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;

    @Column(name = "difficulty_level")
    private String difficultyLevel;

    @Column(name = "question_title")
    private String questionTitle;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @Column(name = "right_answer")
    private String rightAnswer;

}
