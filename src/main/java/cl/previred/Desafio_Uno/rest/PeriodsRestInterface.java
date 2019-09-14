package cl.previred.Desafio_Uno.rest;

import cl.previred.Desafio_Uno.vo.PeriodsOut;
import org.springframework.http.ResponseEntity;

public interface PeriodsRestInterface {

    ResponseEntity<PeriodsOut> getFixedPeriods();
}
