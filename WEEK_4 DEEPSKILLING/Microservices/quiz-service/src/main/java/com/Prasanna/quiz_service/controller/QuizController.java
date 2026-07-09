package com.Prasanna.quiz_service.controller;



import com.Prasanna.quiz_service.model.QuestionWrapper;
import com.Prasanna.quiz_service.model.QuizDto;
import com.Prasanna.quiz_service.model.Response;
import com.Prasanna.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizdto){
        return quizService.createQuiz(quizdto.getCatagoryName(),quizdto.getNoOfQ(),quizdto.getTitle());
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> calculatescore(@PathVariable Integer id,@RequestBody List<Response> response){

return quizService.calculateScore(id,response);
    }
}
