/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package pt.isep.nsheets.client.application.workbook;

import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.application.workbook.WorkbookView.SheetCell;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.services.ChartDTO;

public class WorkbookPresenter extends Presenter<WorkbookPresenter.MyView, WorkbookPresenter.MyProxy> {

    public static ChartDTO selectedChart;
    
    interface MyView extends View {

        public MaterialTextBox getFirstBox();

        public MaterialIcon getFirstButton();

        public MaterialDataTable<SheetCell> getTable();

        public Cell getActiveCell();

        public MaterialDropDown getChartDropDown();

        public MaterialPopupMenu getPopChart();
    }

    @ProxyStandard
    @NameToken(NameTokens.workbook)
    interface MyProxy extends ProxyPlace<WorkbookPresenter> {
    }

    @Inject
    WorkbookPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.placeManager = placeManager;
    }

    PlaceManager placeManager;

    @Override
    protected void onReset() {
        super.onReset();

        getView().getFirstButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                // Let's test formulas...
//				String source=getView().getFirstBox().getText();
//				
//				// Fetches a cell
//				Workbook workbook = new Workbook(1);
//				Spreadsheet sheet = workbook.getSpreadsheet(0);
//				Cell cell = sheet.getCell(new Address(0, 0));
//
//				Formula formula;
//				String result="";
//				try {
//					formula = FormulaCompiler.getInstance().compile(cell, source);
//					
//					Expression expression = formula.getExpression();
//					result="Formula: " + expression + " = " + expression.evaluate();
//					
//				} catch (FormulaCompilationException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					result=e.getMessage();
//				} catch (IllegalValueTypeException e) {
//					// TODO Auto-generated catch block
//					// e.printStackTrace();
//					result=e.getMessage();
//				} finally {
//					getView().getResultLabel().setText(result);
//				}

                // Example on how to jump to another place
//				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.about)
//						.with("name", result).build();
//
//				placeManager.revealPlace(request);
            }
        });

        getView().getTable().addClickHandler(handler -> {
            if (getView().getActiveCell().hasChart()) {
                updateCellCharts(getView().getActiveCell());
                getView().getPopChart().setPopupPosition(handler.getClientX(), handler.getClientY());
                getView().getPopChart().open();
            }else{
                selectedChart = null;
            }
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Workbook", "The current Workbook", "", "", this);
    }

    private void redirectToChartPage() {
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.getChart());
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

        placeManager.revealPlace(placeRequest);
    }

    protected void updateCellCharts(Cell cell) {
        getView().getChartDropDown().clear();
        for (ChartDTO chart : cell.chartList()) {
            MaterialLink link = new MaterialLink(chart.getGraph_name(), null, IconType.INSERT_CHART);
            link.setTextColor(Color.BLACK);
            link.addClickHandler(handler ->{
                selectedChart = chart;
                MaterialToast.fireToast(selectedChart.getGraph_name());
                redirectToChartPage();
            });
            getView().getChartDropDown().add(link);
        }
    }

}
