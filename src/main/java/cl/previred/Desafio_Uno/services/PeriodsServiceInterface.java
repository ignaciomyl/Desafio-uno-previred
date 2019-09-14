package cl.previred.Desafio_Uno.services;

import cl.previred.Desafio_Uno.exception.PeriodException;
import cl.previred.Desafio_Uno.vo.PeriodsIn;
import cl.previred.Desafio_Uno.vo.PeriodsOut;

import java.io.IOException;

public interface PeriodsServiceInterface {

    PeriodsOut completePeriods() throws PeriodException;

    PeriodsIn apiConnection() throws IOException, PeriodException;
}
