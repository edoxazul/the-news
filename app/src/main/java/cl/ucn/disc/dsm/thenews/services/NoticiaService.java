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

  /**
   * Get the TopHeadLines from the backend.
   * @param pageSize - how many News
   * @return - The {@link List} of {@link Noticia}
   */
  List<Noticia> getTopHeadLines(final int pageSize);

}