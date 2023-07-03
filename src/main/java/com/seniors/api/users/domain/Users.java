package com.seniors.api.users.domain;

import com.seniors.api.comment.Comment;
import com.seniors.api.common.BaseEntity;
import com.seniors.api.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "varchar(255) COMMENT 'sns 고유 ID'", unique = true)
	private String snsId;

	@Column(columnDefinition = "varchar(50) COMMENT '이메일'")
	private String email;

	@Column(columnDefinition = "varchar(30) COMMENT '닉네임'", unique = true)
	private String nickname;

	@Column(columnDefinition = "varchar(10) COMMENT '성별'")
	private String gender;

	@Column(columnDefinition = "varchar(50) COMMENT '휴대전화번호'")
	private String phoneNumber;

	@Column(columnDefinition = "text COMMENT '프로필 이미지 url'")
	private String profileImageUrl;

	@OneToMany(mappedBy = "users", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "users", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	public static Users initSnsUsers(
			String snsId, String email, String nickname
	) {
		return Users.builder()
				.snsId(snsId)
				.email(email)
				.nickname(nickname)
				.build();
	}

	@Builder
	public Users (String snsId, String email, String nickname) {
		this.snsId = snsId;
		this.email = email;
		this.nickname = nickname;
	}
}