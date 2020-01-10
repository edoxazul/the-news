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

package cl.ucn.disc.dsm.thenews;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jakewharton.threetenabp.AndroidThreeTen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Main Application
 *
 * @author Eduardo Alvarez S.
 */


public class MainApplication extends Application {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

  /**
   * Called when the application is starting, before any activity, service, or receiver objects (excluding content
   * providers) have been created.
   */
  @Override
  public void onCreate() {

    super.onCreate();
    log.debug("Initializing ..");

    // Day and Night support
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

    // Facebook fresco
    Fresco.initialize(this);
    AndroidThreeTen.init(this);

    log.debug("Initializing: Done.");
  }





}