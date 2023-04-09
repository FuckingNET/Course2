package com.skypro.course2.service;

import com.skypro.course2.entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ExaminerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ExaminerServiceImplTest {

    @Autowired
    private ExaminerService examinerService;

    @MockBean
    private QuestionService questionService;


    @Test
    void getQuestions_success() {
        int amount = 1;
        Question question1 = new Question("hello", "world");
        Question question2 = new Question("Hi", "World!");
        Collection<Question> questions = Set.of(question1, question2);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        Collection<Question> expected = Set.of(question1);

        Collection<Question> actual = examinerService.getQuestions(amount);
        assertEquals(expected, actual);
        verify(questionService).getAll();
        assertEquals(amount, actual.size());
    }
}