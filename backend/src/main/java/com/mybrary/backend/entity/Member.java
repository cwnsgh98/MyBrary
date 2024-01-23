package com.mybrary.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(unique = true)
  private String email;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id")
  private Image profileImage;

  private String name;
  private String nickname;
  private String password;
  private String intro;
  private boolean isProfilePublic;
  private boolean isNotifyEnabled;

  // Follow
  @OneToMany(mappedBy = "following")
  private List<Follow> followingList;
  @OneToMany(mappedBy = "follower")
  private List<Follow> followerList;

  // Notification
  @OneToMany(mappedBy = "sender")
  private List<Notification> sendList;
  @OneToMany(mappedBy = "receiver")
  private List<Notification> receiveList;

  // ChatJoin
  @OneToMany(mappedBy = "joinMember")
  private List<ChatJoin> chatJoinList;

  // ChatMessage
  @OneToMany(mappedBy = "receiver")
  private List<ChatMessage> messageList;

  // Like
  @OneToMany(mappedBy = "member")
  private List<Like> likeList;


}
