package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {
    
	ArrayList<WorkbookDTO> getWorkbooks();
        
	WorkbookDTO addWorkbookDescription(WorkbookDTO wdDto) throws DataException;
        
        WorkbookDTO findByName(String name) throws DataException;
        
        WorkbookDTO setName(String name);
        
        WorkbookDTO saveWorkbook(WorkbookDTO wb);
}
