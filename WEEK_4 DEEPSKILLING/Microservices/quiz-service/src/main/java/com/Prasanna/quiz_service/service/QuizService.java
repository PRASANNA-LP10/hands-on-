package com.Prasanna.quiz_service.service;


import com.Prasanna.quiz_service.dao.QuizDao;
import com.Prasanna.quiz_service.feign.QuizInterface;
import com.Prasanna.quiz_service.model.QuestionWrapper;
import com.Prasanna.quiz_service.model.Quiz;
import com.Prasanna.quiz_service.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    Logger logger= LoggerFactory.getLogger("QuizService");

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,noQ).getBody();
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Successfully Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(Integer id) {

        Optional<Quiz> quiz= Optional.of(quizDao.getById(id));
        ResponseEntity<List<QuestionWrapper>> questionsForUser=quizInterface.getQuestiondById(quiz.get().getQuestions());
        return questionsForUser;
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> response) {
        return quizInterface.getScore(response);
    }
}
