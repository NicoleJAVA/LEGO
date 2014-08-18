 
package test;

import java.io.*; 
import java.util.*;


public class test {
	   static String fileName = "to_convert_to_1x2";
	   
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
		       // do convert() for every line 
		       // do writeToLDR() for every line 

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
			  //String xx;
			  //String yy;
			  //String zz;
			  //String spaceStr = " ";
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
		      
		      if( brickType.equals("2x1x1")){resultStr=convert_2x1x1(x,y,z,alongXpi);}
              else if( brickType.equals("1x1x2")){resultStr=convert_1x1x2(x,y,z,alongXpiY90);}
              else if( brickType.equals("3x1x1")){resultStr=convert_3x1x1(x,y,z,alongXpi);}
              else if( brickType.equals("1x1x3")){resultStr=convert_1x1x3(x,y,z,alongXpiY90);}
              System.out.println("resultStr is "+resultStr);
		      
		      /*****/
		      writeToLDR(resultStr);
		      /*****/
		      
		   }   // End if isLEGOline  
	   }
	   
	   public static String convert_2x1x1(int x, int y, int z,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3004.dat along x  axis by pi*/
		      String xx = Integer.toString(x);
		      String yy = Integer.toString(y);
		      String zz = Integer.toString(z);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3004.dat";
		      System.out.println( "convertStr is "+convertStr );
	
		      return convertStr;
		   
	   }	   
	   public static String convert_1x1x2(int x, int y, int z,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3004.dat along x  axis by pi*/
		      x = x - 10;
		      z = z + 10;
		      String xx = Integer.toString(x);
		      String yy = Integer.toString(y);
		      String zz = Integer.toString(z);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3004.dat";
		      System.out.println( "convertStr is "+convertStr );
	
		      return convertStr;
		   
	   }
	   
	   
	   public static String convert_3x1x1(int x, int y, int z,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3622.dat along x  axis by pi*/
		      String xx = Integer.toString(x);
		      String yy = Integer.toString(y);
		      String zz = Integer.toString(z);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3622.dat";
		      System.out.println( "convertStr is "+convertStr );
	
		      return convertStr;
		   
	   }

	   public static String convert_1x1x3(int x, int y, int z,String rotateMat){ /*rotateMat is rotaion Matrix*/
		   /*convert 3x1x1 by rotate MLCAD 3622.dat along x  axis by pi*/
		      x = x - 20; // move back along X
		      z = z + 20; // move back along Z
		      String xx = Integer.toString(x);
		      String yy = Integer.toString(y);
		      String zz = Integer.toString(z);	
		      String spaceStr = " ";
		      String convertStr = "1 7 "+xx+spaceStr+yy+spaceStr+zz+spaceStr;
		      convertStr = convertStr + rotateMat + spaceStr+"3622.dat";
		      System.out.println( "convertStr is "+convertStr );
	
		      return convertStr;
		   
	   }
	   
	   
	   public static int checkLineType( String lineInput ){
		   
		   /****/
		   if( lineInput.length() >= 4 ){
			   //   System.out.println( lineInput.substring( 0, 4 ) );
			   String first4char = lineInput.substring( 0, 4 );
			   String LEGOstr = "LEGO";
		       if( first4char.equals(LEGOstr) ){
		    	   
		    	   return 1;
		       }
		       else{
		    	   //   System.out.println( "000" );
		       }
	  	   }
		   /****/
		   return 0;
		   
	   }   // End checkLineType()
	   
	   
	   public static void writeToLDR(String inputResultStr ) // origLine is original line
	   {

		   try{
			   
			   String newLDRfileName ="src/test/" +fileName+"_ldraw.ldr";// theFW was named fstream originally  
 			   FileWriter theFW = new FileWriter(newLDRfileName,true); /* <-- DO use 'true' as param*/
			   BufferedWriter outBW = new BufferedWriter( theFW );
			   outBW.write( inputResultStr );
			   outBW.newLine(); //
			   /* Nicole Ha ha s.o.f This should be the accepted answer. ¡V  wassup */
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

			   /* Nicole Ha ha s.o.f This should be the accepted answer. ¡V  wassup */		   
			   outBW.close();   //Close the output stream
			   }
		   catch (Exception e){   //Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
	   }
}
