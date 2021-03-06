/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application.AddChartController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application.CreateChartController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application.ListChartsController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartsService;
import pt.isep.nsheets.shared.services.DataException;

/**
 *
 * @author pedromonteiro
 */
public class ChartServiceImp extends RemoteServiceServlet implements ChartsService {

    
    private PersistenceSettings getPersistenceSettings() {
        
        Properties props = new Properties();
        
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<ChartDTO> getCharts() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

		ArrayList<ChartDTO> charts = new ArrayList<>();

		ListChartsController ctrl = new ListChartsController();

		Iterable<Chart> it_charts= ctrl.listAllCharts();

		it_charts.forEach(chart -> charts.add(chart.toDTO()));

		return charts;
    }

    @Override
    public ChartDTO addChart(ChartDTO chartDTO) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

		AddChartController ctrl = new AddChartController();

		Chart chart = ctrl.addChart(chartDTO);
                
		
		return chart.toDTO();
    }

    @Override
    public ChartDTO getChartContent(ChartDTO dto, SpreadsheetDTO s) {
                CreateChartController ctrl = new CreateChartController();
                
                return ctrl.generateChartValues(dto, s);
    }

    
    
}
