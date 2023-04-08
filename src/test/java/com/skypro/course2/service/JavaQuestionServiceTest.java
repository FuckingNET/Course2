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
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {JavaQuestionService.class})
@ExtendWith(SpringExtension.class)
class JavaQuestionServiceTest {
    @Autowired
    @MockBean
    private QuestionService questionService;


    @Test
    void add() {
        String question = "1";
        String answer = "22";

        Question expected = new Question("1", "22");

        Question actual = questionService.add(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        String question = "1";
        String answer = "22";

        Question expected = new Question("1", "22");

        Question actual = questionService.remove(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        Question question1 = new Question("1", "22");
        Collection<Question> questions = Set.of(question1);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        Collection<Question> expected = Set.of(question1);

        Collection<Question> actual = questionService.getAll();
        assertEquals(expected, actual);
    }
}