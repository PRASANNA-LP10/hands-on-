package com.Prasanna.question_service.service;

import com.Prasanna.question_service.dao.QuestionDao;
import com.Prasanna.question_service.model.Question;
import com.Prasanna.question_service.model.QuestionWrapper;
import com.Prasanna.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsBasedOnCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer noOfQ) {
            return new ResponseEntity<>(questionDao.findRandomQuestionByCategory(categoryName,noOfQ),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsBasedOnId(List<Integer> questionids) {
    List<QuestionWrapper> questions=new ArrayList<>();
    List<Question> ques=new ArrayList<>();
    for(int id:questionids){
        ques.add(questionDao.getQuestionsById(id));
    }
    for(Question q:ques){
        questions.add(new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
    }
    return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right=0;
        for(Response r:responses){
            Question q=questionDao.getQuestionsById(r.getId());
            if(r.getResponse().equals(q.getRightAnswer()))right++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
