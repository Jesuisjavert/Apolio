package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.domain.Portfolio;
import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommunityService {

    @Transactional
    public Long community(String title, String content, String username) {
        Account account = new Account();
        account.setUsername(username);
        Community community = Community.createCommunity(title, content, account);
        communityRepository.save(community);

        return community.getId();
    }

    private final CommunityRepository communityRepository;

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
