package CommentAnalysisAPI.controller;

import CommentAnalysisAPI.model.Comment;
import CommentAnalysisAPI.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @PostMapping("/analyze")
    public Comment analyzeComment(@RequestBody Comment comment) {
        return sentimentAnalysisService.analyzeSentiment(comment);
    }
}
