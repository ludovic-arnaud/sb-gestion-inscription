package fr.afpa.sb.gestion.inscription.service.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    private static final ModelMapper mapper = new ModelMapper();

    private Mapper() {
    }

    public static  <T, E> T map(E source, Class<T> destinationType) {
        return destinationType.cast(mapper.map(source, destinationType));
    }
    
    public  static <T,E> List<T> map(List<E> source, Class<T> destinationType) {
    	List<T> listDestination = new ArrayList<T>();
    	for (E e : source) {
			listDestination.add(map(e, destinationType));
		}
        return listDestination;
    } 
    
}
