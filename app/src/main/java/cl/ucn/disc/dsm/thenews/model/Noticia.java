

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

import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/**
 * Domain class.
 *
 */
public final class Noticia {

  /**
   * The Zone
   */
  public static final ZoneId ZONE_ID = ZoneId.of("-3");

  /**
   * The Id
   */
  public final Long id;

  /**
   * The Titulo
   */
  public final String titulo;

  /**
   * The Fuente
   */
  public final String fuente;

  /**
   * The Author
   */
  public final String autor;

  /**
   * The URL
   */
  public final String url;

  /**
   * The URL of Photo
   */
  public final String urlFoto;

  /**
   * The Resumen
   */
  public final String resumen;

  /**
   * The Contenido
   */
  public final String contenido;

  /**
   * The Fecha
   */
  public final ZonedDateTime fecha;

  /**
   * The Constructor.
   *
   * @param id
   * @param titulo
   * @param fuente
   * @param autor
   * @param url
   * @param urlFoto
   * @param resumen
   * @param contenido
   * @param fecha
   */
  public Noticia(Long id, String titulo, String fuente, String autor, String url, String urlFoto,
      String resumen, String contenido, ZonedDateTime fecha) {
    this.id = id;
    this.titulo = titulo;
    this.fuente = fuente;
    this.autor = autor;
    this.url = url;
    this.urlFoto = urlFoto;
    this.resumen = resumen;
    this.contenido = contenido;
    this.fecha = fecha;
  }

  /**
   * @return The id.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @return The titulo.
   */
  public String getTitulo() {
    return this.titulo;
  }

  /**
   * @return The fuente.
   */
  public String getFuente() {
    return this.fuente;
  }

  /**
   * @return The autor.
   */
  public String getAutor() {
    return this.autor;
  }

  /**
   * @return The url.
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * @return The urlFoto.
   */
  public String getUrlFoto() {
    return this.urlFoto;
  }

  /**
   * @return The resumen.
   */
  public String getResumen() {
    return this.resumen;
  }

  /**
   * @return The contenido.
   */
  public String getContenido() {
    return this.contenido;
  }

  /**
   * @return The fecha.
   */
  public ZonedDateTime getFecha() {
    return this.fecha;
  }

}