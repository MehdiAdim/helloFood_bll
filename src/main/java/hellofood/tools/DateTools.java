package hellofood.tools;

import java.util.Date;

public interface DateTools {
	
	
	public Date toDate(String input);
	
	public boolean isValideDateBeginEnd(Date start,Date end) ;
	
	public boolean isFutureDate(Date date);
	
	public boolean isBetween(Date x,Date start,Date end);
	
	
		
	
	
	

}
