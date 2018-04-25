package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

	private MyView view;
	
	interface MyView extends View {
		void setContents(ArrayList<WorkbookDescriptionDTO> contents);
	}

	@NameToken(NameTokens.home)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
		
		this.view=view;
	}
	
	private void refreshView(ArrayList<WorkbookDescriptionDTO> contents) {
		this.view.setContents(contents);
	}

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);
        
        // Test if we can access the server...
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
        
        // Set up the callback object.
        AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback = new AsyncCallback<ArrayList<WorkbookDescriptionDTO>>() {
          public void onFailure(Throwable caught) {
            // TODO: Do something with errors.
          }

          public void onSuccess(ArrayList<WorkbookDescriptionDTO> result) {
            //updateTable(result);
        	  	refreshView(result);
          }
        };

        // Make the call to the stock price service.
        workbooksSvc.getWorkbooks(callback);
    }	
}