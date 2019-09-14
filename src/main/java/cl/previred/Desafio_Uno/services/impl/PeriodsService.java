package cl.previred.Desafio_Uno.services.impl;

import cl.previred.Desafio_Uno.exception.PeriodException;
import cl.previred.Desafio_Uno.services.PeriodsServiceInterface;
import cl.previred.Desafio_Uno.vo.PeriodsIn;
import cl.previred.Desafio_Uno.vo.PeriodsOut;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JI Ramirez
 */
@Service
public class PeriodsService implements PeriodsServiceInterface {
    /**
     * metodo que genera las fechas faltantes en base a lo que recibe en el api generador de periodos
     * @return
     * @throws PeriodException
     */
    public PeriodsOut completePeriods() throws PeriodException {
        PeriodsOut periodsOut = new PeriodsOut();
        try{
            PeriodsIn periods = apiConnection();
            LocalDate date = LocalDate.parse( periods.getFechaCreacion());
            LocalDate endDate = LocalDate.parse( periods.getFechaFin());
            periodsOut.setFechaCreacion(LocalDate.parse( periods.getFechaCreacion()));
            periodsOut.setFechaFin(endDate);
            periodsOut.setId(periods.getId());
            List<LocalDate> fechas = new ArrayList<>();
            for(String fecha : periods.getFechas()){
                fechas.add(LocalDate.parse(fecha));
            }
            periodsOut.setFechas(fechas);
            List<LocalDate> missingDates = new ArrayList<>();
            while (!date.isAfter(endDate)){
                if(periodsOut.getFechas().contains(date)){
                    date = date.plusMonths(1);
                    continue;
                }
                else{
                    missingDates.add(date);
                    date = date.plusMonths(1);
                }

            }
            periodsOut.setFechasFaltantes(missingDates);
        }catch (Exception e){
            throw new PeriodException("error en generacion de periodos faltantes",e);
        }


        return periodsOut;
    }

    /**
     * metodo que se conecta con api generadora de periodos
     * @return
     * @throws IOException
     * @throws PeriodException
     */
    public PeriodsIn apiConnection() throws IOException, PeriodException {
        PeriodsIn periods = new PeriodsIn();
        try {
            // supposed this is your FirstController url.
            String url = "http://127.0.0.1:8080/periodos/api";
            // create request.
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            request.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
            // execute your request.
            HttpResponse response = client.execute(request);


            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";

            while ((line = rd.readLine()) != null) {
                periods = new Gson().fromJson(result.append(line).toString(), PeriodsIn.class);
            }

        }
        catch (IOException e){
            e.getMessage();
        }
        catch (Exception e){
            throw new PeriodException("error en la conexion con el servicio",e);
        }
        return periods;
    }
}
