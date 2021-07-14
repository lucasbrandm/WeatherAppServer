package com.example.Final;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Servlet", value = "/servlet")
public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Setting Everything up.
        PrintWriter out = response.getWriter();
        String location = request.getParameter("city");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            //get data from the openweathermap api
            HTTP persistence = new HTTP();
            String result = persistence.readHTTP("https://api.openweathermap.org/data/2.5/weather?q=" + location + "&units=imperial&apiKey=77b87ca303e14f319d3a5d4a56dbfcd7");
            WeatherCondition wc = mapper.readValue(result, WeatherCondition.class);

            //creates a weather object with the data from the API
            Weather weather = new Weather(wc.getId(), wc.getWeatherMain(), wc.getWeatherDesc(), wc.getTemp(), wc.getTempMin(), wc.getTempMax());

            //Returns that Weather object to the Client
            String s = null;
            s = mapper.writeValueAsString(weather);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(s);
            out.flush();

            //Adds the Weather Object to the Database
            persistence.insertWeather(weather);

        } catch (IOException var18) {
            var18.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}