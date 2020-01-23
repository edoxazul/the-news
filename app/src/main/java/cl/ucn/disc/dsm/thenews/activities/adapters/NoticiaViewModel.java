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

package cl.ucn.disc.dsm.thenews.activities.adapters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cl.ucn.disc.dsm.thenews.model.Noticia;
import cl.ucn.disc.dsm.thenews.services.NoticiaService;
import cl.ucn.disc.dsm.thenews.services.newsapi.NewsApiNoticiaService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NoticiaViewModel extends ViewModel {

  private static final Logger log = LoggerFactory.getLogger(NoticiaViewModel.class);
  private static final int PAGE_SIZE = 50;

  /**
   * The {@link List} of {@link Noticia} to provide.
   */
  private final MutableLiveData<List<Noticia>> theNoticias = new MutableLiveData<>();

  /**
   * The Exception in case of error.
   */
  private final MutableLiveData<Exception> theException = new MutableLiveData<>();


  /**
   * The provider of {@link Noticia}.
   */
  private NoticiaService noticiaService = new NewsApiNoticiaService();

  /**
   * LiveData of Noticias to use in the view.
   *
   * @return the List of Noticia inside a LiveData.
   */


  public LiveData<List<Noticia>> getNoticias ( ) {
    return this.theNoticias;
  }

  /**
   * LiveData of Exception to use in the view.
   *
   * @return the Exception in case of error.
   */
  public LiveData<Exception> getException ( ) {
    return this.theException;
  }


  /**
   * Update the internal list of Noticias.
   *
   * <p>NOTE: Need to run in background.</p>
   *
   * @return the number of noticias loaded.
   */
  public int refresh ( ) {

    try {

      // 1. Get the list of noticia from NewsApi
      final List<Noticia> noticias = this.noticiaService.getNoticias(PAGE_SIZE);

      // 2. Set the values (NEED to be in background)
      this.theNoticias.postValue(noticias);

      // 3. All ok!
      return noticias.size();

    } catch (final Exception ex) {

      log.error("Error", ex);

      // 2. Set the exception
      this.theException.postValue(ex);

      // 3. All error!
      return -1;

    }

  }


}
