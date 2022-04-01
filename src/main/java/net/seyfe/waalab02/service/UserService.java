package net.seyfe.waalab02.service;

import net.seyfe.waalab02.domain.Post;
import net.seyfe.waalab02.domain.User;
import net.seyfe.waalab02.domain.dto.PostDto;
import net.seyfe.waalab02.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long userId);

    void save(User user);

    public void deleteById(Long userId);

    public void updateUser(Long postId, User user);

    public List<UserDto> getPostByUserName(String userName);

    List<PostDto> findPostsById(Long userId);

    List<UserDto> getUsersHavingMoreThanOnePost();
}
