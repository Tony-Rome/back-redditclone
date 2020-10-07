package com.example.springredditclone.srpingredditclone.service;

import com.example.springredditclone.srpingredditclone.dto.PostRequest;
import com.example.springredditclone.srpingredditclone.dto.PostResponse;
import com.example.springredditclone.srpingredditclone.exceptions.SpringRedditException;
import com.example.springredditclone.srpingredditclone.mapper.PostMapper;
import com.example.springredditclone.srpingredditclone.model.Post;
import com.example.springredditclone.srpingredditclone.model.Subreddit;
import com.example.springredditclone.srpingredditclone.model.User;
import com.example.springredditclone.srpingredditclone.repository.PostRepository;
import com.example.springredditclone.srpingredditclone.repository.SubredditRepository;
import com.example.springredditclone.srpingredditclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final SubredditRepository subredditRepository;
    private final AuthService authService;
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
            .orElseThrow(() -> new SpringRedditException(postRequest.getSubredditName()));

        User currentUser = authService.getCurrentUser();

        return postMapper.map(postRequest, subreddit, currentUser);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException(id.toString()));

        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts(){
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubreddit(Long subredditId){
        Subreddit subreddit = subredditRepository.findById(subredditId)
                .orElseThrow(() -> new SpringRedditException(subredditId.toString()));

        List<Post> posts = postRepository.findAllBySubreddit(subreddit);

        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new SpringRedditException("Usuario no encontrado: "+username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
