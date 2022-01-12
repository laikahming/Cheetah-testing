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
public class ModalRecipients {

	
	@Builder.Default
	private List< ModalProfile > recipients = new ArrayList< ModalProfile >();
	
	
}



