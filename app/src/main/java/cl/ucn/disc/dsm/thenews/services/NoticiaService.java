package cl.ucn.disc.dsm.thenews.services;

import cl.ucn.disc.dsm.thenews.model.Noticia;
import java.util.List;

/**
 * The Service Class.
 *
 * @author Eduardo Alvarez S.
 */
public interface NoticiaService {

  /**
   * Get the Noticias from the backend.
   *
   * @param pageSize how many.
   * @return the {@link List} of {@link Noticia}.
   */
  List<Noticia> getNoticias(final int pageSize);

}