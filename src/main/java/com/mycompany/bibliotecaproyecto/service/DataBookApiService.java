package com.mycompany.bibliotecaproyecto.service;

import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.util.ArrayList;

public class DataBookApiService {

    public ArrayList<BookApi> getBooks() {
        
        ArrayList<BookApi> books = null;
        try {
            books = new ArrayList<BookApi>();
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://book-finder1.p.rapidapi.com/api/search?series=Wings%20of%20fire&book_type=Fiction&lexile_min=600&lexile_max=800&results_per_page=25&page=1")
                    .get()
                    .addHeader("X-RapidAPI-Key", "02e2c7be6cmsh1a8ef466d363fe4p1cfa9ajsn7bb9490e5bf0")
                    .addHeader("X-RapidAPI-Host", "book-finder1.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            // Obtener el cuerpo de la respuesta
            ResponseBody responseBody = response.body();
            // Convertir el cuerpo de la respuesta a una cadena JSON
            String jsonString = responseBody.string();

            // Crear un objeto JSON a partir de la cadena JSON
            JSONObject jsonResponse = new JSONObject(jsonString);

            // Acceder a elementos específicos
            JSONArray booksArray = jsonResponse.getJSONArray("results");

            // Iterar sobre los libros
            int isbn = 652365214;
            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject book = booksArray.getJSONObject(i);
                String title = book.getString("title");
                Integer pages = book.getInt("page_count");
                String summary = book.getString("summary");
                Integer copyright = book.getInt("copyright");
                //category
                String category = "";
                JSONArray categories = book.getJSONArray("categories");
                for (int u = 0; u < categories.length(); u++) {
                    category = categories.getString(u);
                }
                
                String author = "";
                JSONArray authorJson = book.getJSONArray("authors");
                for (int u = 0; u < authorJson.length(); u++) {
                    author = authorJson.getString(u);
                }
                
                //imagen
                String img = "";
                JSONArray dataImagen = book.getJSONArray("published_works");
                for (int z = 0; z < dataImagen.length(); z++) {
                    JSONObject prueba2 = dataImagen.getJSONObject(z);
                    img = prueba2.getString("cover_art_url");
                }
                
                books.add(new BookApi(img,author,title,copyright,pages,category,isbn,summary));
                isbn++;
            }
            return books;
            //la foto del libro esta en el indice 0,0,3
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

}
