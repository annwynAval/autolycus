package com.annwyn.autolycus.common.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class BeanUtils {

    private BeanUtils() {
        throw new IllegalArgumentException("can't initialize BeanUtils.class");
    }

    private static final Map<String, BeanCopier> CACHE_BEAN_COPIER = new ConcurrentHashMap<>(16);

    public static <T, X> List<T> copyBeans(List<X> source, Supplier<T> supplier) {
        return source.stream().map(item -> BeanUtils.copyBean(item, supplier)).collect(Collectors.toList());
    }

    public static <T, X> T copyBean(X source, T target) {
        BeanCopier beanCopier = BeanUtils.newInstance(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
        return target;
    }

    public static <T, X> T copyBean(X source, Supplier<T> supplier) {
        return BeanUtils.copyBean(source, supplier.get());
    }

    private static BeanCopier newInstance(Class<?> source, Class<?> target) {
        final String cacheKey = source.getName() + target.getName();
        BeanCopier beanCopier = BeanUtils.CACHE_BEAN_COPIER.get(cacheKey);

        if(beanCopier != null) {
            return beanCopier;
        }

        synchronized(BeanUtils.class) {
            beanCopier = BeanUtils.CACHE_BEAN_COPIER.get(cacheKey);
            if(beanCopier != null) {
                return beanCopier;
            }
            BeanUtils.CACHE_BEAN_COPIER.put(cacheKey, beanCopier = BeanCopier.create(source, target, false));
        }
        return beanCopier;
    }

}
