package com.Prasanna.question_service.dao;

import com.Prasanna.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    public List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q where q.category=:category order by RANDOM() LIMIT :noQ",nativeQuery = true)
    public  List<Integer> findRandomQuestionByCategory(String category, int noQ);

    Question getQuestionsById(int id);
}
