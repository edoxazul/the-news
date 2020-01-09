/*
 * Copyright 2020
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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