package testing.modal;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModalProfile {

	
	private Integer id;
	
	private String name;
	
	@Builder.Default
	private List< String > tags = new ArrayList< String >();
	
	
	
	
	
	
	
	
	public List< String > matchTag( List< String > pTags ) {
		
		List< String > sTag = new ArrayList< String >();
		
		for ( String t : pTags ) {
			if ( this.tags.contains( t ) ) {
				sTag.add( t );
			}
		}
		
		return ( sTag );
		
	}
	
}



