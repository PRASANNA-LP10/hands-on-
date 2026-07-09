package com.Prasanna.question_service.controller;


import com.Prasanna.question_service.model.Question;
import com.Prasanna.question_service.model.QuestionWrapper;
import com.Prasanna.question_service.model.Response;
import com.Prasanna.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/questions")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionBasedOnCategory(@PathVariable String category) {
        return questionService.getQuestionsBasedOnCategory(category);
    }

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @GetMapping("/generatequestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer noOfQ) {
        return questionService.getQuestionsForQuiz(categoryName, noOfQ);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestiondById(@RequestBody List<Integer> questionids) {
        return questionService.getQuestionsBasedOnId(questionids);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response) {

        return questionService.getScore(response);
    }
}
