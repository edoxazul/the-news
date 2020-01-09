package cl.ucn.disc.dsm.thenews.services;

import cl.ucn.disc.dsm.thenews.model.Noticia;
import cl.ucn.disc.dsm.thenews.services.mockup.MockupNoticiaService;
import cl.ucn.disc.dsm.thenews.services.newsapi.NewsApiNoticiaService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Test of NoticiaService.
 *
 * @author Eduardo Alvarez S.
 */
public final class NoticiaServiceTest {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(NoticiaServiceTest.class);

  /**
   * Test {@link NoticiaService#getNoticias(int)}
   */
  @Test
  public void testGetNoticiasMockup() {

    log.debug("Testing the NoticiaService ..");

    // The noticia service
    final NoticiaService noticiaService = new MockupNoticiaService();

    // The List of Noticia.
    final List<Noticia> noticias = noticiaService.getNoticias(2);

    Assertions.assertNotNull(noticias);
    Assertions.assertEquals(noticias.size(), 2, "Error de tamanio");

    for (final Noticia noticia : noticias) {
      log.debug("Noticia: {}.", noticia);
    }

    log.debug("Done.");
  }

  /**
   * Test {@link NoticiaService#getNoticias(int)} with NewsAPI.org
   */
  @Test
  public void testGetNoticiasNewsApi() {

    final int size = 20;

    log.debug("Testing the NewsApiNoticiaService, requesting {} News.", size);

    // The noticia service
    final NoticiaService noticiaService = new NewsApiNoticiaService();

    // The List of Noticia.
    final List<Noticia> noticias = noticiaService.getNoticias(size);

    Assertions.assertNotNull(noticias);
    Assertions.assertEquals(noticias.size(), size, "Error de tamanio");

    for (final Noticia noticia : noticias) {
      log.debug("Noticia: {}.", noticia);
    }

    log.debug("Done.");

  }


}