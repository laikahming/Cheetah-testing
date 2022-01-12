package testing;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testing.helper.HelperFile;
import testing.modal.ModalProfile;
import testing.modal.ModalRecipients;

public class MainClass {
	
	
	
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	
	
	
	
	
	
	public void execute() throws JsonParseException, JsonMappingException, IOException {

		
		
		
		
		/*
		 *		convert file content to string 
		 */
		String jsonString = "";
		
		InputStream inputStream = MainClass.class.getClassLoader().getResourceAsStream( "data.json" );
		
		try {
			
			jsonString = HelperFile.fileContent( 
					HelperFile.inputStreamToFile( inputStream ) 
			);
			
		} catch( Exception ex ) {
			ex.printStackTrace( );
		}
		
		
		
		
		
		
		
		
		
		/*
		 *		convert json string to java class object
		 */
		
		ModalRecipients mRecipient = objectMapper.readValue( jsonString , ModalRecipients.class );
		
		
		
		
		
		
		
		
		
		
		
		

		/*
		 *		compare tags value
		 */
		
		List< List< Integer > > matchProfile = new ArrayList< List< Integer > >();
		
		for ( ModalProfile mProfile : mRecipient.getRecipients( ) ) {
			
			for ( ModalProfile mProfile2 : mRecipient.getRecipients( ) ) {
			
				
				/* ---   if same profile will skip  --- */
				if ( mProfile.getId( ) == mProfile2.getId( ) ) {
					continue;
				}
				
				
				
				
				/* 
				 * ---   
				 * 		compare same tag   
				 * --- 
				 */				
				List< String > mTags = mProfile.matchTag( mProfile2.getTags( ) );

				if ( mTags.size( ) >= 2 ) {
					
					
					
					/* 
					 * ---    
					 * 		record down profile is match , to prevent duplicate record come out
					 * --- 
					 */				
					List< Integer > tmp = Arrays.asList( mProfile.getId( ) , mProfile2.getId( ) );
					Collections.sort( tmp );
					
					if ( matchProfile.contains( tmp ) ) {
						continue;
					}
					
					
					matchProfile.add( tmp );
					
					
					
					
					
					
					/* 
					 * ---
					 * 		print result 
					 * ---
					 */
					System.out.println( mProfile.getName( ) + ", " + mProfile2.getName( ) + " - " + mTags );
					
				}
				

			}
			
		}
		
		
		
		
		
		/*
		 * 
		 * result :
		 * 
		 * 		- Maura Hickman, Fern Wise - [promo, clicker, non-clicker]
		 *	    - Maura Hickman, Elena Vega - [buyer, clicker]
		 *		- Maura Hickman, Alexandra Jacobson - [promo, non-clicker]
		 *		- Maura Hickman, Burt Hampton - [promo, non-clicker]
		 *		- Maura Hickman, Sylvia Norman - [buyer, clicker]
		 *		- Maura Hickman, Colon Reynolds - [promo, buyer, clicker]
		 *		- Luisa Rutledge, Sylvia Norman - [shopping, clicker]
		 *		- Luisa Rutledge, Colon Reynolds - [shopping, clicker]
		 *		- Fern Wise, Alexandra Jacobson - [promo, non-clicker]
		 *		- Fern Wise, Burt Hampton - [promo, non-clicker]
		 *		- Fern Wise, Colon Reynolds - [promo, clicker]
		 *		- Elena Vega, Sylvia Norman - [buyer, clicker]
		 *		- Elena Vega, Colon Reynolds - [buyer, clicker]
		 *		- Alexandra Jacobson, Burt Hampton - [promo, non-clicker]
		 *		- Sylvia Norman, Jana Stevenson - [shopping, buyer]
		 *		- Sylvia Norman, Colon Reynolds - [shopping, buyer, clicker]
		 *		- Jana Stevenson, Colon Reynolds - [shopping, buyer]
 		 *
		 */
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main( String[] args ) {
		
		MainClass newCls = new MainClass();
		try {
			
			newCls.execute( );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			
		}
		
	}
	
}
