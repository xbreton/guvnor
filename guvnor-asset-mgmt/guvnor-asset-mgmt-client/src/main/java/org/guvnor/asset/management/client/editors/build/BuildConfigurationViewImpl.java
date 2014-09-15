/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.guvnor.asset.management.client.editors.build;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.guvnor.asset.management.client.i18n.Constants;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.security.Identity;
import org.uberfire.workbench.events.NotificationEvent;

@Dependent

public class BuildConfigurationViewImpl extends Composite implements BuildConfigurationPresenter.BuildConfigurationView {

     interface Binder
            extends UiBinder<Widget, BuildConfigurationViewImpl> {

    }

    private static Binder uiBinder = GWT.create(Binder.class);
    
    @Inject
    private Identity identity;

    @Inject
    private PlaceManager placeManager;

    private BuildConfigurationPresenter presenter;

    @UiField
    public ListBox chooseRepositoryBox;

    @UiField
    public ListBox chooseBranchBox;


//    public ListBox chooseProjectBox;
    
    @UiField
    public TextBox chooseProjectBox;
    
    @UiField
    public Button buildButton;

    @UiField
    public TextBox userNameText;
    
  
    @UiField
    public TextBox passwordText;
  
    @UiField
    public TextBox serverURLText;

    @UiField
    public CheckBox deployToRuntimeCheck;

    @Inject
    private Event<NotificationEvent> notification;

    private Constants constants = GWT.create(Constants.class);

    public BuildConfigurationViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    

    @Override
    public void init(final BuildConfigurationPresenter presenter) {
        this.presenter = presenter;
       chooseRepositoryBox.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                String value = chooseRepositoryBox.getValue();

                presenter.loadBranches(value);
            }
        });
        presenter.loadRepositories();
    }

    

    @UiHandler("buildButton")
    public void buildButton(ClickEvent e) {
//        presenter.buildProject(chooseRepositoryBox.getText(), chooseBranchBox.getText(), chooseProjectBox.getText(),
//                            userNameText.getText(), passwordText.getText(), serverURLText.getText(), deployToRuntimeCheck.getValue());
       
    }

   

    @Override
    public void displayNotification(String text) {
        notification.fire(new NotificationEvent(text));
    }

    public ListBox getChooseBranchBox() {
        return chooseBranchBox;
    }


    @Override
    public ListBox getChooseRepositoryBox() {
        return chooseRepositoryBox;
    }

    public Button getBuildButton() {
        return buildButton;
    }

    
   

}
