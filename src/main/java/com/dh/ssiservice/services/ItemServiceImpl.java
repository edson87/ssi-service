/**
 * @author: Edson A. Terceros T.
 */

package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Item;
import com.dh.ssiservice.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Item, Long> getRepository() {
        return repository;
    }


   /* @Override
    public List<Item> findByCode(String code) {
        List<Item> results = new ArrayList<>();
        repository.findByCode(code).get().iterator().forEachRemaining(results::add);
        return results;
    }*/

    @Override
    public void saveImage(Long id, MultipartFile file) {
        Item itemPersisted = findById(id);
        try {
            Byte[] bytes = new Byte[file.getBytes().length];
            int i = 0;
            for (Byte aByte : file.getBytes()) {
                bytes[i++] = aByte;
            }
            itemPersisted.setImage(bytes);
            getRepository().save(itemPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

}
