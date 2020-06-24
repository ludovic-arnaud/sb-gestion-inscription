package fr.afpa.sb.gestion.inscription.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
public class MapperWithLink<T extends RepresentationModel<T>> extends Mapper<T> {

	public static <T, E> T map(E source, Class<T> destinationType, LinkCreator<T> linkCreator) {
		T t = destinationType.cast(map(source, destinationType));
		if (t instanceof RepresentationModel)
			((RepresentationModel) t).add(linkCreator.getSelfLink(t), linkCreator.getLinks());
		return t;
	}

	public static <T, E> List<T> map(List<E> source, Class<T> destinationType, LinkCreator<T> linkCreator) {
		List<T> listDestination = new ArrayList<T>();
		for (E e : source) {
			listDestination.add(map(e, destinationType, linkCreator));
		}
		return listDestination;
	}

}
