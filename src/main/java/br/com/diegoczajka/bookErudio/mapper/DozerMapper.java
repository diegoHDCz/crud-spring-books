package br.com.diegoczajka.bookErudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    //    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
//        List<D> destinationObjects = new ArrayList<D>();
//        for (O o : origin) {
//            destinationObjects.add(mapper.map(origin, destination));
//        }
//        return destinationObjects;
//    }
    public static <T, S> List<T> mapListObjectToListNewObject(List<S> objects, Class<T> newObjectClass) {
        final List<T> newObjects = new ArrayList<T>();
        for (S s : objects) {
            newObjects.add(mapper.map(s, newObjectClass));
        }
        return newObjects;
    }
}
