package com.example.springredditclone.srpingredditclone.service;

import com.example.springredditclone.srpingredditclone.dto.CommentsDto;
import com.example.springredditclone.srpingredditclone.exceptions.SpringRedditException;
import com.example.springredditclone.srpingredditclone.mapper.CommentMapper;
import com.example.springredditclone.srpingredditclone.model.Comment;
import com.example.springredditclone.srpingredditclone.model.NotificationEmail;
import com.example.springredditclone.srpingredditclone.model.Post;
import com.example.springredditclone.srpingredditclone.model.User;
import com.example.springredditclone.srpingredditclone.repository.CommentRepository;
import com.example.springredditclone.srpingredditclone.repository.PostRepository;
import com.example.springredditclone.srpingredditclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {

    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;
    public void save(CommentsDto commentsDto){
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new SpringRedditException("No se encuentra comentario con id:"+commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String messsage = mailContentBuilder.build(post.getUser().getUsername()+" posteó un comentario en tu post "+ POST_URL);
        sendCommentNotification(messsage, post.getUser());
    }

    private void sendCommentNotification(String message, User user){
        mailService.sendMail(new NotificationEmail(user.getUsername()+" Comentó tu post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new SpringRedditException(postId.toString()));
        return commentRepository.findByPost(post).stream().map(commentMapper::mapToDto).collect(toList());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new SpringRedditException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }
}
