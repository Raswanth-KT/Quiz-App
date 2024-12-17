
package com.example.quizapp.controller;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.User;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    private User user = new User(); // Single user for simplicity

    @PostMapping("/start")
    public String startQuiz() {
        user.setUsername("testUser");
        user.setTotalQuestionsAnswered(0);
        user.setCorrectAnswers(0);
        return "Quiz started for user: " + user.getUsername();
    }

    @GetMapping("/question")
    public Question getQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        quizService.submitAnswer(user, questionId, answer);
        return "Answer submitted.";
    }

    @GetMapping("/stats")
    public String getStats() {
        return "Total Questions Answered: " + user.getTotalQuestionsAnswered() +
                ", Correct Answers: " + user.getCorrectAnswers();
    }
}
