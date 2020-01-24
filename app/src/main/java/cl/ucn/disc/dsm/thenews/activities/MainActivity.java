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

package cl.ucn.disc.dsm.thenews.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import cl.ucn.disc.dsm.thenews.R;
import cl.ucn.disc.dsm.thenews.activities.adapters.NoticiaAdapter;
import cl.ucn.disc.dsm.thenews.activities.adapters.NoticiaViewModel;
import cl.ucn.disc.dsm.thenews.databinding.ActivityMainBinding;
import cl.ucn.disc.dsm.thenews.services.NoticiaService;
import es.dmoral.toasty.Toasty;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {


  /**
   * The Logger
   */
  private static final Logger log = LoggerFactory.getLogger(MainActivity.class);

  /**
   * The bindings.
   */
  private ActivityMainBinding binding;

  /**
   * The Adapter
   */
  private NoticiaAdapter noticiaAdapter;


  /**
   * The ViewModel of Noticia.
   */
  private NoticiaViewModel noticiaViewModel;

  //  /**
//   * The NoticiaService
//   */
  //private NoticiaService noticiaService;


  /**
   * @param savedInstanceState to use.
   */
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);

    // Inflate the layout
    this.binding = ActivityMainBinding.inflate(getLayoutInflater());

    // Assign to the main view.
    setContentView(binding.getRoot());

    // Set the toolbar
    {
      this.setSupportActionBar(binding.toolbar);
    }

    // The Adapter + RecyclerView
    {
      // The Adapter
      this.noticiaAdapter = new NoticiaAdapter();

      // The Adapter
      this.binding.rvNoticias.setAdapter(this.noticiaAdapter);

      // The layout (ListView)
      this.binding.rvNoticias.setLayoutManager(new LinearLayoutManager(this));

      // The separator (line)
      this.binding.rvNoticias
          .addItemDecoration(new DividerItemDecoration
              (this, DividerItemDecoration.VERTICAL));
    }

    // The ViewModel
    {
      // Build the NoticiaViewModel.
      this.noticiaViewModel = new ViewModelProvider(this).get(NoticiaViewModel.class);

      // Observe the list of noticia
      this.noticiaViewModel.getNoticias().observe(this,
          noticias -> this.noticiaAdapter.setNoticias(noticias));

      // Observe the exception
      this.noticiaViewModel.getException().observe(this, this :: showException);

    }

    // The refresh
    {
      this.binding.swlRefresh.setOnRefreshListener(( ) -> {
        log.debug("Refreshing ..");

        // Run in background
        AsyncTask.execute(( ) -> {

          // All ok
          final int size = this.noticiaViewModel.refresh();
          if (size != -1) {

            // In the UI
            runOnUiThread(( ) -> {

              // Hide the loading
              this.binding.swlRefresh.setRefreshing(false);

              // Show a message.
              Toasty.success(this, "Noticias fetched: "
                  + size, Toast.LENGTH_SHORT, true).show();

            });
          }

        });

      });
    }


  }

  /**
   * Show the exception.
   *
   * @param exception to use.
   */
  private void showException (final Exception exception) {

    // Hide the loading
    this.binding.swlRefresh.setRefreshing(false);

    // Build the message
    final StringBuilder sb = new StringBuilder("Error: ");
    sb.append(exception.getMessage());
    if (exception.getCause() != null) {
      sb.append(", ");
      sb.append(exception.getCause().getMessage());
    }

    Toasty.error(this, sb.toString(), Toast.LENGTH_LONG, true).show();

  }

}
