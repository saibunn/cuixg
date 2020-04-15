package com.pgyhr.core.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CommonTransform {
    /**
     * @param list 实体，即：bo或者po
     * @param t    dto
     * @return
     */
    public static <T, E> List<T> convertToDTOs(List<E> list, Class<T> t) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.stream().map(e -> convertToDTO(e, t)).collect(Collectors.toList());
    }

    /**
     * @param e 实体，即：bo或者po
     * @param t dto
     * @return
     */
    public static <T, E> T convertToDTO(E e, Class<T> t) {
        T dto = BeanUtils.instantiate(t);
        BeanUtils.copyProperties(e, dto);
        return dto;
    }

    public static <E, T> List<E> convertToEntities(List<T> list, Class<E> e) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.stream().map(t -> convertToEntity(t, e)).collect(Collectors.toList());
    }

    public static <E, T> E convertToEntity(T t, Class<E> e) {
        E entity = BeanUtils.instantiate(e);
        BeanUtils.copyProperties(t, entity);
        return entity;
    }
}
