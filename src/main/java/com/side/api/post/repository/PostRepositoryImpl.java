package com.side.api.post.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.side.common.repository.BasicRepoSupport;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl extends BasicRepoSupport implements PostRepositoryCustom {


	protected PostRepositoryImpl(JPAQueryFactory jpaQueryFactory, EntityManager em) {
		super(jpaQueryFactory, em);
	}


}