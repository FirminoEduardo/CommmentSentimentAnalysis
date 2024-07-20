package CommentAnalysisAPI.service;

import CommentAnalysisAPI.model.Comment;
import CommentAnalysisAPI.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SentimentAnalysisService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment analyzeSentiment(Comment comment) {
        // Call to an external sentiment analysis API
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.sentimentanalysis.com/analyze";
        String sentiment = restTemplate.postForObject(apiUrl, comment.getText(), String.class);

        comment.setSentiment(sentiment);
        return commentRepository.save(comment);
    }
}
