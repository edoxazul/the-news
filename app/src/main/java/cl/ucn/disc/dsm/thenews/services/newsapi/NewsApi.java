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

package cl.ucn.disc.dsm.thenews.services.newsapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Interface de acceso a los endpoints the NewsApi.org
 *
 * @author Eduardo Alvarez S.
 */
interface NewsApi {

  /**
   * The URL
   */
  String BASE_URL = "https://newsapi.org/v2/";


  /**
   * The API Key
   */
  String API_KEY = "e14b8cc292b84b6a969bc841d1b14df5";

  /**
   * https://newsapi.org/docs/endpoints/top-headlines
   *
   * @param category to use as filter.
   * @param country  of the news.
   * @param pageSize the number of results to get.
   * @return the call of {@link NewsApiResult}.
   */
  @Headers({"X-Api-Key: " + API_KEY})
  @GET("top-headlines")
  Call<NewsApiResult> getTopHeadLines (
      @Query("category") final String category,
      @Query(("country")) final String country,
      @Query("pageSize") final int pageSize);

  /**
   * https://newsapi.org/docs/endpoints/everything
   *
   * @return the call of {@link NewsApiResult}.
   */
  @Headers({"X-Api-Key: " + API_KEY, "X-No-Cache: true"})
  // TODO: Change the list of sources.
  @GET("everything?sources=ars-technica,wired,hacker-news,recode")
  Call<NewsApiResult> getEverything (@Query("pageSize") final int pageSize);

}