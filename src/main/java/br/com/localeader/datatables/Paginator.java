/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.datatables;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Leandro Laurindo
 */
public class Paginator {

    public void list(Integer pageSize, Integer offset, ModelMap modelMap, JpaRepository repository, String sort, BeanLoaderListener listener) {

        if (offset == null || offset < 0) {
            offset = 0;
        }

        if (pageSize == null || pageSize == 0 || pageSize > 50) {
            pageSize = 10;
        }

        Pageable requestPage = sort == null
                ? PageRequest.of(offset, pageSize)
                : PageRequest.of(offset, pageSize, Sort.by(sort));
        Page page = null;

        page = repository.findAll(requestPage);

        if (listener != null) {
            for (Object it : page.getContent()) {
                listener.load(it);
            }
        }

        modelMap.addAttribute("items", page.getContent());

        Integer next = offset + 1;
        Integer last = offset - 1;

        if (!page.hasNext() && page.hasPrevious()) {
            next = page.getTotalPages() - 1;
        } else if (!page.hasNext()) {
            next = 0;
        }

        if (page.isFirst()) {
            last = 0;
        }

        if (last == null && next == null) {
            modelMap.addAttribute("paginated", false);
        } else {
            modelMap.addAttribute("paginated", true);
            modelMap.addAttribute("next", next);
            modelMap.addAttribute("last", last);
        }

        List pages = new LinkedList<>();
        for (int i = 0; i < page.getTotalPages(); i++) {
            pages.add(i);
        }
        modelMap.addAttribute("pages", pages);
        modelMap.addAttribute("offset", offset);
        modelMap.addAttribute("hasNext", page.hasNext());
        modelMap.addAttribute("hasLast", page.hasPrevious());
        modelMap.addAttribute("pageSize", pageSize);

    }
}
