package cl.previred.Desafio_Uno.rest.impl;

import cl.previred.Desafio_Uno.rest.PeriodsRestInterface;
import cl.previred.Desafio_Uno.services.impl.PeriodsService;
import cl.previred.Desafio_Uno.vo.PeriodsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
/**
 * @author JI Ramirez
 */
@RestController(value = "/")
public class PeriodsRest implements PeriodsRestInterface {

    @Autowired
    private PeriodsService periodsService;

    @GetMapping(value = "obtenerPeriodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeriodsOut> getFixedPeriods(){
        try{
            PeriodsOut periods = periodsService.completePeriods();
            return new ResponseEntity<>(periods, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
