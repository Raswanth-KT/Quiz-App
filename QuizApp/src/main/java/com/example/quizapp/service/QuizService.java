
package com.example.quizapp.service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.User;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) return null;
        int randomIndex = (int) (Math.random() * questions.size());
        return questions.get(randomIndex);
    }

    public void submitAnswer(User user, Long questionId, String answer) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            user.setTotalQuestionsAnswered(user.getTotalQuestionsAnswered() + 1);
            if (question.getCorrectOption().equalsIgnoreCase(answer)) {
                user.setCorrectAnswers(user.getCorrectAnswers() + 1);
            }
            userRepository.save(user);
        }
    }
}
