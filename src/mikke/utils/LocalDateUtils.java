package mikke.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LocalDateUtils {
	
	final static Logger logger = Logger.getLogger(LocalDateUtils.class);
	
	public LocalDateUtils ()
	{
		BasicConfigurator.configure();
	}
	
	public void nowLocalDate (int annios)
	{
		LocalDate date = LocalDate.now();
		logger.info("Fecha actual con LocalDate: " + date);
		
		LocalDate date2 = LocalDate.of(Year.now().getValue() + annios, 1, 1);
		logger.info("Fecha nueva con LocalDate: " + date2);
		
		Date date1 = Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        logger.info("Date      = " + date1);
        
	}
	
	public void nowLocalDateTime ()
	{
		LocalDateTime date = LocalDateTime.now();
		logger.info("Fecha y Hora actual con LocalDateTime: " + date);
	}
	
	public List <LocalDateTime>  daysList ()
	{
		List <LocalDateTime> myList = new ArrayList<>();
		
		myList.add(LocalDateTime.of(2018, 10, 24, 18, 10, 2));
		myList.add(LocalDateTime.of(2018, 10, 14, 13, 10, 2));
		myList.add(LocalDateTime.of(2018, 9, 30, 18, 10, 02));
		myList.add(LocalDateTime.of(2018, 9, 29, 18, 10, 02));
		myList.add(LocalDateTime.of(2018, 8, 24, 18, 10, 02));
		myList.add(LocalDateTime.of(2018, 7, 24, 18, 10, 02));
		myList.add(LocalDateTime.of(2018, 8, 24, 18, 10, 02));
		
		return myList;
	}
	
	public void Restar10dias ()
	{
		LocalDateTime now = LocalDateTime.now();
		
		LocalDateTime day = now.minusDays(10);
		
		logger.info("Diez dias antes: " + day);
	}
	
	public int deceroadiez ()
	{
		int count = 0;
		List <LocalDateTime> lista = daysList();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime day = now.minusDays(10);
		
		for (LocalDateTime date: lista){
			if (date >= day){
				
			}
		}
		
		logger.info("De CERO A DIEZ DIAS HAY: " + count);
		return count;
	}
	
	
}
