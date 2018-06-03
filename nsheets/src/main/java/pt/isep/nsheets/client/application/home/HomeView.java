package pt.isep.nsheets.client.application.home;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

class HomeView extends ViewImpl implements HomePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomeView> {
	}
	
	@UiField
	HTMLPanel htmlPanel;

	@UiField
	MaterialButton newWorkbookButton, saveButton;
        
        @UiField
	MaterialModal modal;
        
        @UiField
        MaterialTextBox name, description;
        
	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));		
	}
	
	private MaterialCard createCard(WorkbookDTO wb) {
	    MaterialCard card=new MaterialCard();
	    card.setBackgroundColor(Color.BLUE_DARKEN_1);
	    
            MaterialCardContent cardContent=new MaterialCardContent();
            cardContent.setTextColor(Color.WHITE);

            MaterialCardTitle cardTitle=new MaterialCardTitle();
            cardTitle.setText(wb.name);
            cardTitle.setIconType(IconType.INSERT_DRIVE_FILE);
            cardTitle.setIconPosition(IconPosition.RIGHT);

            MaterialLabel label=new MaterialLabel();
            label.setText(wb.description);

            cardContent.add(cardTitle);
            cardContent.add(label);

            card.add(cardContent);
            
            card.addClickHandler(e -> {
                WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

                // Set up the callback object.
                AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                        public void onFailure(Throwable caught) {
                                MaterialToast.fireToast("Error! " + caught.getMessage());
                        }

                        public void onSuccess(WorkbookDTO result) {
                                MaterialToast.fireToast(result.name);
                        }
                };
                
                workbooksSvc.findByName(wb.name, callback);
            });
            
            return card;
	}

	@Override
	public void setContents(ArrayList<WorkbookDTO> contents) {
		int colCount=1;
		
		MaterialRow row=null;
		
		htmlPanel.clear();
		
		for (WorkbookDTO wb: contents) {
			MaterialCard card=createCard(wb);
			
			if (colCount==1) {
				row=new MaterialRow();
				htmlPanel.add(row);
				++colCount;
				if (colCount>=4) colCount=1;
			}

			MaterialColumn col=new MaterialColumn();
		    col.setGrid("l4");
		    row.add(col);
	
		    col.add(card); 		    
		}
		
	}
	
        @Override
        public void buttonClickHandler(ClickHandler ch) {
            saveButton.addClickHandler(ch);
        }
        
	@Override
	public void addClickHandler(ClickHandler ch) {
		// TODO Auto-generated method stub
		
		newWorkbookButton.addClickHandler( ch );
	}
        
        @Override
        public void openModal() {
            this.modal.open();
        }
        
        @Override
        public void closeModal() {
            this.modal.close();
        }
        
        @Override
        public String title(){
            return this.name.getValue();
        }
        
        @Override
        public String description(){
            return this.description.getValue();
        }
}