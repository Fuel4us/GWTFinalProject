/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.application.AddPrivateChatController;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.application.ListPrivateChatsController;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain.PrivateChat;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.PrivateChatDTO;
import pt.isep.nsheets.shared.services.PrivateChatService;

/**
 *
 * @author Pedro Marques Vieira
 */
public class PrivateChatServiceImpl extends RemoteServiceServlet implements PrivateChatService {

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
    public PrivateChatDTO addPrivateChat(PrivateChatDTO pcDTO) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddPrivateChatController ctrl = new AddPrivateChatController();

        PrivateChat pc = null;

        try {
            pc = ctrl.addPrivateChat(pcDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

        return pc.toDTO();
    }

    @Override
    public ArrayList<PrivateChatDTO> getPrivateChats() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<PrivateChatDTO> pc = new ArrayList<PrivateChatDTO>();

        ListPrivateChatsController ctrl = new ListPrivateChatsController();

        Iterable<PrivateChat> ms = ctrl.listPrivateChats();

        ms.forEach(wb -> pc.add(wb.toDTO()));

        return pc;

    }

}
