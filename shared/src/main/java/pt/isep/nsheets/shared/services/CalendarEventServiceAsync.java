package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface CalendarEventServiceAsync {

    void getWorkbooks(AsyncCallback<ArrayList<CalendarEventDTO>> callback);
}
