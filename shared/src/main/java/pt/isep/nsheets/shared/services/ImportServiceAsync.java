package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ImportServiceAsync {

    void importXmlFile(String fileLocation, AsyncCallback<Void> async);
}
