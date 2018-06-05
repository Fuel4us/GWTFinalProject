package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

/**
 * The Chart Service interface
 * @author pedromonteiro
 */
@RemoteServiceRelativePath("chartsService")
public interface ChartsService extends RemoteService{
    
    ArrayList<ChartDTO> getCharts();
    ChartDTO addChart(ChartDTO chartDTO, SpreadsheetDTO s) throws DataException;
    String [][] getChartContent(ChartDTO dto, SpreadsheetDTO s);
    
    
}
