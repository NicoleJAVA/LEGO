 
package test;

import java.io.*; 
import java.util.*;


public class test {
	   static String fileName = "to_convert_to_1x6";
	   static String xx= "";
	   static String yy ="";
	   static String zz ="";
	   public static void main(String[] args) throws IOException{
		   System.out.println("CUTE");
		   clearOldLDR();
		   String filePath = "src/test/"+ fileName +".txt";
		   InputStream theIS	= new FileInputStream ( filePath );
		   BufferedInputStream theBIS = new BufferedInputStream( theIS );
		   BufferedReader br = new BufferedReader(new InputStreamReader( theBIS));
		   String theLine = null;
		   while((theLine = br.readLine()) != null){
		       System.out.println(theLine);
		       convert( theLine );
		   }
		   br.close();
	   }
	   public static void convert( String origLine) //original line
	   {
		   
		   
		   if( checkLineType(origLine)==1 ){
			  int i = 0;
			  int x = 0;
			  int y = 0;
			  int z = 0;
			  String brickType = "";
		      String tempLine = origLine.replace( "LEGO", "1" );
		      tempLine = tempLine.substring( 0, tempLine.length()-8 ); 
		      
		      /****/
		      StringTokenizer token = new StringTokenizer(tempLine);
		      /****/	
		      while (token.hasMoreTokens()){ 
		    	  String currToken = token.nextToken();
                  //System.out.print( " "+i+": "+ currToken + "---");
		    	  if ( i==1 ){ brickType= currToken;}
		    	  else if( i==2 ){ x = Integer.parseInt(currToken); }
                  else if( i==3 ){ y = Integer.parseInt(currToken); }
                  else if( i==4 ){ z = Integer.parseInt(currToken); }
                  i++;
          }
		      
		      System.out.println("x is "+x+". "+" y is "+y+". "+"z is "+z+". "+tempLine); 
		      x = 20*x;
		      y = 24*y;
		      z = 20*z;       
		      String resultStr="";
		      String alongXpi = "1 0 0 0 -1 0 0 0 -1";
		      String alongXpiY90 = "0 0 1 0 -1 0 -1 0 0";
		      String xx = Integer.toString(x);
		      String yy = Integer.toString(y);
		      String zz = Integer.toString(z);	
		      if( brickType.equals("2x1x1")){resultStr=convert_2x1x1(xx,yy,zz,alongXpi);}
              else if( brickType.equals("1x1x2")){
            	  resultStr=convert_1x1x2(xx,yy,zz,alongXpiY90);
              }
              else if( brickType.equals("3x1x1")){resultStr=convert_3x1x1(xx,yy,zz,alongXpi);}
              else if( brickType.equals("1x1x3")){
            	  resultStr=convert_1x1x3(xx,yy,zz,alongXpiY90);
              }
              else if( brickType.equals("4x1x1")){resultStr=convert_4x1x1(xx,yy,zz,alongXpi);}
              else if( brickType.equals("1x1x4")){resultStr=convert_1x1x4(xx,yy,zz,alongXpiY90);}
              else if( brickType.equals("6x1x1")){resultStr=convert_6x1x1(xx,yy,zz,alongXpi);}
              else if( brickType.equals("1x1x6")){resultStr=convert_1x1x6(xx,yy,zz,alongXpiY90);}
              else if( brickType.equals("8x1x1")){resultStr=convert_8x1x1(xx,yy,zz,alongXpi);}
              else if( brickType.equals("1x1x8")){resultStr=convert_1x1x8(xx,yy,zz,alongXpiY90);}
              System.out.println("resultStr is "+resultStr);
		      
		      /*****/
		      writeToLDR(resultStr);
		      /*****/
		      
		   }   // End if isLEGOline  
	   } 
	   public static String convert_2x1x1(String xx, String yy, String zz, String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3004.dat along x  axis by pi*/

		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3004.dat";
		      System.out.println( "convertStr is "+convertStr );	
		      return convertStr;
		   
	   }	   
	   public static String convert_1x1x2(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3004.dat along x  axis by pi, along y bi pi/2 */
		      xx = Integer.toString(Integer.parseInt(xx)-10);
		      zz = Integer.toString(Integer.parseInt(zz)+10);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3004.dat";
		      return convertStr;
	   }
	   public static String convert_3x1x1(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3622.dat along x  axis by pi*/
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3622.dat"; /*System.out.println( "convertStr is "+convertStr );*/
		      return convertStr;	   
	   }
	   public static String convert_1x1x3(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3622.dat along x  axis by pi, along y bi pi/2 */
		      xx = Integer.toString(Integer.parseInt(xx)-20);
		      zz = Integer.toString(Integer.parseInt(zz)+20);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3622.dat";/*System.out.println( "convertStr is "+convertStr );*/
			      return convertStr;
	   }
	   public static String convert_4x1x1(String xx, String yy, String zz, String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3010.dat along x  axis by pi*/

		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3010.dat";
		      System.out.println( "convertStr is "+convertStr );	
		      return convertStr;
		   
	   }	   
	   public static String convert_1x1x4(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3010.dat along x  axis by pi, along y bi pi/2 */
		      xx = Integer.toString(Integer.parseInt(xx)-30);
		      zz = Integer.toString(Integer.parseInt(zz)+30);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3010.dat";
		      return convertStr;
	   }
	   public static String convert_6x1x1(String xx, String yy, String zz, String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3009.dat along x  axis by pi*/

		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3009.dat";
		      System.out.println( "convertStr is "+convertStr );	
		      return convertStr;
		   
	   }	   
	   public static String convert_1x1x6(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3009.dat along x  axis by pi, along y bi pi/2 */
		      xx = Integer.toString(Integer.parseInt(xx)-50);
		      zz = Integer.toString(Integer.parseInt(zz)+50);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3009.dat";
		      return convertStr;
	   }	   
	   public static String convert_8x1x1(String xx, String yy, String zz, String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3008.dat along x  axis by pi*/

		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3008.dat";
		      System.out.println( "convertStr is "+convertStr );	
		      return convertStr;
		   
	   }	   
	   public static String convert_1x1x8(String xx, String yy, String zz,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3008.dat along x  axis by pi, along y bi pi/2 */
		      xx = Integer.toString(Integer.parseInt(xx)-70);
		      zz = Integer.toString(Integer.parseInt(zz)+70);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3008.dat";
		      return convertStr;
	   }	   
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */	   
	   
	   public static int checkLineType( String lineInput ){
		   if( lineInput.length() >= 4 ){
			   //   System.out.println( lineInput.substring( 0, 4 ) );
			   String first4char = lineInput.substring( 0, 4 );
			   String LEGOstr = "LEGO";
		       if( first4char.equals(LEGOstr) ){   
		    	   return 1;
		       }
		       else{
		    	   return 0; //   System.out.println( "000" );
		       }
	  	   }
		   return 0;
	   }     //   End checkLineType()
	   
	   
	   public static void writeToLDR(String inputResultStr ) // origLine is original line
	   {

		   try{
			   
			   String newLDRfileName ="src/test/" +fileName+"_ldraw.ldr";// theFW was named fstream originally  
 			   FileWriter theFW = new FileWriter(newLDRfileName,true); /* <-- DO use 'true' as param*/
			   BufferedWriter outBW = new BufferedWriter( theFW );
			   outBW.write( inputResultStr );
			   outBW.newLine(); //
			   /* Nicole Ha ha s.o.f This should be the accepted answer. �V  wassup */
			   outBW.close();   //Close the output stream
			   }
		   catch (Exception e){   //Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
	   }
	   public static void clearOldLDR(){
		   try{
				 
			   String newLDRfileName ="src/test/" +fileName+"_ldraw.ldr";
 			   FileWriter theFW = new FileWriter(newLDRfileName); /* <-- do NOT use 'true' as param*/

			   BufferedWriter outBW = new BufferedWriter( theFW );
			   outBW.write( "" ); /* <-- write empty string to clear the content*/ 

			   /* Nicole Ha ha s.o.f This should be the accepted answer. �V  wassup */		   
			   outBW.close();   //Close the output stream
			   }
		   catch (Exception e){   //Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
	   }
}
