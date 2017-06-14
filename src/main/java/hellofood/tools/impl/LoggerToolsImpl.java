package hellofood.tools.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Messages;

import hellofood.tools.LoggerTools;

public class LoggerToolsImpl implements LoggerTools {

	@Override
	public void addBox(final Log log,String message) {
		
		int l=0;
		l=(message.length()%2==0)?66:65;
			
		
		int a = (l-message.length())/2;
		String str="";
		String s1="";
		String s2="";
		String s3="";
		int b=0;
		for(int i=0 ; i<l;i++){
			if(i==0 || i==l-1){
				str+="|";
				s1+=(i==0)?" ":"";
				s2+="|";
				s3+="|";
				
			}	
			else if(i<a || i>=a+message.length() ){
				str+=" ";
				s1+="_";
				s2+=" ";
				s3+="_";
			}
			else{
				str+=(b==0)?message:"";
				b+=1;
				s1+="_";
				s2+=" ";
				s3+="_";
			}
		}
		
		
		
		

		log.debug(s1);
		log.debug(s2);
		log.debug(str);
		log.debug(s3);
		
	}

	
	
	

}
