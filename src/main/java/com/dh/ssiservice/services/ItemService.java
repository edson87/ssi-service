/**
 * @author: Edson A. Terceros T.
 */

package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Item;

import java.util.List;

public interface ItemService extends GenericService<Item> {
    List<Item> findByCode(String code);
}

