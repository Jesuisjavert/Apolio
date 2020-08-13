package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

    @Transactional
    public Long community(String title, String content, String username) {
        User user = new User();
        user.setUsername(username);
        Community community = Community.createCommunity(title, content, user);
        communityRepository.save(community);

        return community.getId();
    }

    public List<Community> findCommunityAll() {
        return communityRepository.findAll();
    }
    public Community findCommunity(Long community_id) {
        return communityRepository.findOne(community_id);
    }
    @Transactional
    public int updateCommunity(Community community){
        return communityRepository.updateCommunityById(community);
    }

    @Transactional
    public int deleteCommunity(Long id){
        return communityRepository.deleteCommunityById(id);
    }


}
