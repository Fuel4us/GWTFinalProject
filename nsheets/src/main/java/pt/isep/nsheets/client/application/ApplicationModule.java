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
package pt.isep.nsheets.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import pt.isep.nsheets.client.application.about.AboutModule;
import pt.isep.nsheets.client.application.agenda.AgendaModule;
//import pt.isep.nsheets.client.application.agenda.AgendaModule;
import pt.isep.nsheets.client.application.calendar.CalendarModule;
import pt.isep.nsheets.client.application.chart.ChartModule;
import pt.isep.nsheets.client.application.chat.ChatModule;
import pt.isep.nsheets.client.application.code.CodeModule;
import pt.isep.nsheets.client.application.contacts.ContactsModule;
import pt.isep.nsheets.client.application.code_js.Code_JavaScriptModule;
import pt.isep.nsheets.client.application.export.ExportModule;
import pt.isep.nsheets.client.application.profile.ProfileModule;
import pt.isep.nsheets.client.lapr4.blue.s2.core.n1150478.application.extensions.ExtensionsModule;
import pt.isep.nsheets.client.application.form.FormModule;
import pt.isep.nsheets.client.application.home.HomeModule;
import pt.isep.nsheets.client.application.imports.ImportModule;
import pt.isep.nsheets.client.application.listNotes.ListNotesModule;
import pt.isep.nsheets.client.application.login.LoginModule;
import pt.isep.nsheets.client.application.menu.MenuModule;
import pt.isep.nsheets.client.application.notes.NotesModule;
import pt.isep.nsheets.client.application.tasks.TasksModule;
import pt.isep.nsheets.client.application.workbook.WorkbookModule;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup.SignupModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {

        install(new HomeModule());
        install(new MenuModule());
        install(new CalendarModule());
        install(new AboutModule());
        install(new WorkbookModule());
        install(new NotesModule());
        install(new LoginModule());
        install(new SignupModule());
        install(new ChartModule());
        install(new ExportModule());
        install(new ImportModule());
        install(new ChatModule());
        install(new FormModule());
        install(new CodeModule());
        install(new Code_JavaScriptModule());
        install(new ExtensionsModule());
        install(new ContactsModule());
        install(new TasksModule());
        install(new AgendaModule());
        install(new ListNotesModule());
        install(new ProfileModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
    }
}
