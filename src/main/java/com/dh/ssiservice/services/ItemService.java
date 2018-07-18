/**
 * @author: Edson A. Terceros T.
 */

package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService extends GenericService<Item> {
   // List<Item> findByCode(String code);

    void saveImage(Long id, MultipartFile file);
}

