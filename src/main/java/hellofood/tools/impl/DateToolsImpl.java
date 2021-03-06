package hellofood.tools.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hellofood.tools.DateTools;

public class DateToolsImpl implements DateTools {

	@Override
	public Date toDate(String input) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
		Date date=new Date();
		try {

             date = formatter.parse(input);
           

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return date;
	}

	@Override
	public boolean isValideDateBeginEnd(Date start,Date end ) {

		
		if (start.compareTo(end) > 0) {
            return false;
        } else if (start.compareTo(end) < 0) {
            return true;
        } else if (start.compareTo(end) == 0) {
        	 return false;
        } else {
            return false;
        }
		
	}

	@Override
	public boolean isFutureDate(Date date) {
		return !isValideDateBeginEnd(date,new Date());
	}

	@Override
	public boolean isBetween(Date x,Date start, Date end) {
		
		if(x.after(start) && x.before(end)){
			
			return true;
		}
		else
			
		return false;
	}
	
	
	

}
