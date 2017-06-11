package hellofood.services;

import java.util.Date;


public interface DateService {
	
	
	public Date toDate(String input);
	
	public boolean isValideDateBeginEnd(Date start,Date end) ;
	
	public boolean isFutureDate(Date date);
	
	
		
	
	
	

}
