/*
 * Copyright [2020] [Eduardo Alvarez S]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cl.ucn.disc.dsm.thenews.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZonedDateTime;

/**
 * Test of {@link cl.ucn.disc.dsm.thenews.model.Noticia}.
 *
 */
public class NoticiaTest {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(NoticiaTest.class);

  /**
   * The Test of Constructor.
   */
  @Test
  public void testConstructor() {

    log.debug("Testing the Constructor ..");

    // The values
    final Long id = 1L;
    final String titulo = "The Titulo";
    final String fuente = "The Fuente";
    final String autor = "The Author";
    final String url = "The URL";
    final String urlFoto = "The URL of Foto";
    final String resumen = "The Resumen";
    final String contenido = "The Contenido";
    final ZonedDateTime fecha = ZonedDateTime.now(Noticia.ZONE_ID);

    // The Constructor
    final Noticia noticia = new Noticia(id, titulo, fuente, autor, url, urlFoto, resumen, contenido, fecha);

    // Testing
    Assertions.assertEquals(id, noticia.getId());
    Assertions.assertEquals(titulo, noticia.getTitulo());
    Assertions.assertEquals(fuente, noticia.getFuente());
    Assertions.assertEquals(autor, noticia.getAutor());
    Assertions.assertEquals(url, noticia.getUrl());
    Assertions.assertEquals(urlFoto, noticia.getUrlFoto());
    Assertions.assertEquals(resumen, noticia.getResumen());
    Assertions.assertEquals(contenido, noticia.getContenido());
    Assertions.assertEquals(fecha, noticia.getFecha());

    log.debug("Done.");

  }

}