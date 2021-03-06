package pt.isep.nsheets.client.application.about;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AboutModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(AboutPresenter.class, AboutPresenter.MyView.class, AboutView.class, AboutPresenter.MyProxy.class);
    }
}