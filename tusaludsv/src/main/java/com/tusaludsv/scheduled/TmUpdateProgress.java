/**
 * 
 */
package com.tusaludsv.scheduled;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tusaludsv.model.dao.TmTaskDao;
import com.tusaludsv.model.entity.TmTask;

/**
 * @Autor Pablo.Portillo
 * @FechaCreacion 07/07/2015.07:53:51
 * @Empresa Grupo.GD
 */
@Component
public class  TmUpdateProgress
{
	private static final Logger log = LoggerFactory.getLogger(TmUpdateProgress.class);
	
	@Autowired
	private TmTaskDao tmTaskDao;
	
	@Scheduled(cron="0 0/5 * * * *") 
	private void Process() throws SQLException, ParseException
	{
		log.info("Proceso de actualización de estado estimado de tareas "+new Date());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<TmTask> list = tmTaskDao.findAllByDate(format.format(new Date()));
		//List<TmTask> list = tmTaskDao.findAllByDate("2015/07/07 20:21:00");
		
		for (TmTask tmTask : list) 
		{
			if(tmTask.getTskEstimatedPercent()!=100)
			{
				log.debug(tmTask.toString());
				Date start = format.parse(tmTask.getTskEstimatedStartTime());
				Date end = format.parse(tmTask.getTskEstimatedEndTime());
				log.debug(start.toString());
				log.debug(end.toString());
				
				long timeInms = end.getTime()-start.getTime();
				long timeInM = timeInms/(1000*60);
				log.debug("Diferencia en minutos "+timeInM);
				long timeInms2 = new Date().getTime() - start.getTime();
				long timeInM2 = timeInms2/(1000*60);
				log.debug("Diferencia en minutos desde que inicio el proceso hasta este momento "+timeInM2);
				
				Long total;
				
				if(timeInM2>timeInM)
				{
					total = (long) 100;
				}
				else
				{
					total = (timeInM2*100)/timeInM;
				}
				log.info("Actualizando el progreso de la tarea "+tmTask.getPkTmTsk()+", Porcentaje: "+total);
				
				tmTaskDao.updateEstimatedProgress(total.intValue(),tmTask.getPkTmTsk());
			}
		}
		
	}

}
