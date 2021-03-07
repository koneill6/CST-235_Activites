package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {

	private SessionContext context;
	
	@Resource
	TimerService timerService;
	
	private static final Logger logger = Logger.getLogger("business.MyTimerService");
	
	public MyTimerService() {
		
	}
	
	public void setTimer(long interval) {
		context.getTimerService().createTimer(interval, "Setting a timer");
	}
	
	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("@Timeout in programmatic at "+new java.util.Date());
	}
	
	@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri")
	private void scheduleTimeout(final Timer t) {
		logger.info("@scheduled "+new java.util.Date());
	}
}
