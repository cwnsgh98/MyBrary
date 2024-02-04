package com.mybrary.backend.domain.chat.repository;

import com.mybrary.backend.domain.chat.entity.ChatJoin;
import com.mybrary.backend.domain.chat.entity.ChatMessage;
import com.mybrary.backend.domain.chat.repository.custom.ChatRepositoryCustom;
import com.mybrary.backend.domain.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>,
    ChatRepositoryCustom {

    /* 채팅 메세지 리스트 조회 (채팅방id로) */
    @Query("select cm from ChatMessage cm where cm.chatRoom.id = :chatRoomId")
    List<ChatMessage> getAllChatMessageByChatRoomId(Long chatRoomId);

    @Query("select m from Member m where m.id = :memberId")
    Member getJoinMemberByMemberId(@Param("memberId") Long memberId);


    /* 채팅 메세지 리스트 조회 (회원id로) */
    @Query("select cj1 from ChatJoin cj1 inner join ChatJoin cj2 on cj1.chatRoom.id = cj2.chatRoom.id where cj1.joinMember.id = :myId and cj2.joinMember.id = :memberId")
    ChatJoin isExistChatRoom(@Param("myId") Long myId, @Param("memberId") Long memberId);


}
