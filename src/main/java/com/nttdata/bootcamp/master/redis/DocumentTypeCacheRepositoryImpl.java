package com.nttdata.bootcamp.master.redis;
import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.domain.repository.IDocumentTypeRedisRepository;
import com.nttdata.bootcamp.master.redis.entity.DocumentTypeCache;
import com.nttdata.bootcamp.master.redis.mapper.IDocumentTypeEntityRedisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DocumentTypeCacheRepositoryImpl implements IDocumentTypeRedisRepository {

    private static final String KEY = "documenttype";
    private RedisTemplate<String, DocumentTypeCache> redisTemplate;
    private HashOperations hashOperations;
    @Autowired
    private IDocumentTypeEntityRedisMapper documentTypeEntityRedisMapper;

    public DocumentTypeCacheRepositoryImpl(RedisTemplate<String, DocumentTypeCache> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public List<DocumentTypeEntity> findAll() {
        List<DocumentTypeEntity> documentTypeEntityList = new ArrayList<DocumentTypeEntity>();
        Map<String, DocumentTypeCache> documentTypeCacheMap = hashOperations.entries(KEY);
        documentTypeCacheMap.entrySet().stream().forEach(entry -> {
            documentTypeEntityList.add(documentTypeEntityRedisMapper.toDocumentTypeEntity(entry.getValue()));
        });
        return documentTypeEntityList;
    }
    @Override
    public DocumentTypeEntity findById(String id) {
        return  documentTypeEntityRedisMapper.toDocumentTypeEntity(
                (DocumentTypeCache)hashOperations.get(KEY, id)
        );
    }
    @Override
    public Optional<DocumentTypeEntity> findByCode(String code) {

        List<DocumentTypeEntity> documentTypeEntityList = new ArrayList<DocumentTypeEntity>();
        Map<String, DocumentTypeCache> documentTypeCacheMap = hashOperations.entries(KEY);
        documentTypeCacheMap.entrySet().stream().forEach(entry -> {
            documentTypeEntityList.add(documentTypeEntityRedisMapper.toDocumentTypeEntity(entry.getValue()));
        });

        Optional<DocumentTypeEntity> documentType=documentTypeEntityList
                .stream()
                .filter(f -> f.getCode().equals(code)).findFirst();

        return documentType;

    }
    @Override
    public void save(DocumentTypeEntity documentTypeEntity) {
        hashOperations.put(KEY, UUID.randomUUID().toString(),
                documentTypeEntityRedisMapper.toDocumentTypeCache( documentTypeEntity));
    }
    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, UUID.randomUUID().toString(), id);
    }
}
