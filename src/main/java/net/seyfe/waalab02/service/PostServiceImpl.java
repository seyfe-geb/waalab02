package net.seyfe.waalab02.service;

import net.seyfe.waalab02.domain.Post;
import net.seyfe.waalab02.domain.dto.PostDto;
import net.seyfe.waalab02.helper.ListMapper;
import net.seyfe.waalab02.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepo postRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToPostDto.mapList(postRepo.findAll(), new PostDto());

    }

    @Override
    public PostDto findById(Long postID) {
        return modelMapper.map(postRepo.findById(postID).orElse(null), PostDto.class);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deleteById(Long postId) {
        postRepo.deleteById(postId);
    }

    @Transactional
    @Override
    public void updatePost(Long postId, Post post) {
        Post oldPost = postRepo.findById(postId).orElse(null);
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setAuthor(post.getAuthor());
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        return (List<PostDto>)listMapperPostToPostDto.mapList(postRepo.findPostByAuthor(author), new PostDto());
    }
}
