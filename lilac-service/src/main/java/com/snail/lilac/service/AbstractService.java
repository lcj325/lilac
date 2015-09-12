package com.snail.lilac.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.snail.lilac.logging.Logger;
import com.snail.lilac.logging.LoggerFactory;
import com.snail.lilac.model.IdEntity;
import com.snail.lilac.repository.BaseRepository;
import com.snail.lilac.service.id.UUIDHexGenerator;

/**
 * @author Andy
 * @since 2013-5-16
 */
@Transactional
public abstract class AbstractService<R extends BaseRepository<T, ID>, T extends IdEntity<ID>, ID extends Serializable> implements Service<T, ID> {

    protected Logger         log = LoggerFactory.getLogger(getClass());

    private UUIDHexGenerator uuidHexGenerator;

    protected Class<T>       entityClass;

    protected R              repository;

    /**
     * @return the uuidHexGenerator
     */
    public UUIDHexGenerator getUuidHexGenerator() {
        return uuidHexGenerator;
    }

    /**
     * @param uuidHexGenerator the uuidHexGenerator to set
     */
    public void setUuidHexGenerator(UUIDHexGenerator uuidHexGenerator) {
        this.uuidHexGenerator = uuidHexGenerator;
    }

    /**
     * @param repository the repository to set
     */
    public abstract void setRepository(R repository);

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public AbstractService(){
        Type type = getClass().getGenericSuperclass();
        if (type != null && type instanceof ParameterizedType) {
            entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[1];
        }
    }

    /*
     * (non-Javadoc)
     * @see com.snail.lilac.core.service.Service#save(java.lang.Object)
     */
    @Override
    public T save(T entity) {
        repository.insert(entity);
        return null;
    }

    /*
     * (non-Javadoc)`
     * @see com.snail.lilac.core.service.Service#delete(java.io.Serializable)
     */
    @Override
    public void delete(ID id) {
        Assert.notNull(id);
        repository.deleteById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.snail.lilac.core.service.Service#findOne(java.io.Serializable)
     */
    @Override
    public T findOne(ID id) {
        return repository.findOne(id);
    }
}
