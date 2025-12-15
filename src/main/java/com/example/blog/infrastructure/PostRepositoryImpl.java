package com.example.blog.infrastructure;

import com.example.blog.domain.entity.Post;
import com.example.blog.domain.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post save(Post post){
        PostJpaEntity postJpaEntity = PostMapper.toEntity(post);
        postJpaEntity = entityManager.merge(postJpaEntity);
        return PostMapper.toDomain(postJpaEntity);
    }

    @Override
    public Optional<Post> findById(UUID postId) {
        PostJpaEntity postJpaEntity = entityManager.find(PostJpaEntity.class, postId.toString());
        return postJpaEntity != null ? Optional.of(PostMapper.toDomain(postJpaEntity)) : Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        TypedQuery<PostJpaEntity> query = entityManager.
                createQuery("SELECT p FROM PostJpaEntity p", PostJpaEntity.class);
        List<PostJpaEntity> postJpaEntities = query.getResultList();
        return  postJpaEntities.stream().map(PostMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID postId) {
        PostJpaEntity postJpaEntity = entityManager.find(PostJpaEntity.class, postId.toString());
        if (postJpaEntity != null) {
            entityManager.remove(postJpaEntity);
        }
    }
}