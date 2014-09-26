/*
 * Copyright 2014 JBoss Inc
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

package org.guvnor.asset.management.backend.social;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.guvnor.asset.management.social.ProcessEndEvent;
=======
import org.guvnor.asset.management.social.AssetManagementEventTypes;
import org.guvnor.asset.management.social.ProcessStartEvent;
>>>>>>> Stashed changes
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent;
import org.kie.uberfire.social.activities.model.SocialEventType;
import org.kie.uberfire.social.activities.repository.SocialUserRepository;
import org.kie.uberfire.social.activities.service.SocialAdapter;
import org.kie.uberfire.social.activities.service.SocialCommandTypeFilter;

<<<<<<< Updated upstream
public class ProcessEndEventAdapter implements SocialAdapter<ProcessEndEvent> {
=======
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ProcessEndEventAdapter implements SocialAdapter<ProcessStartEvent> {
>>>>>>> Stashed changes

    @Inject
    private SocialUserRepository socialUserRepository;

    @Override
    public Class<ProcessEndEvent> eventToIntercept() {
        return ProcessEndEvent.class;
    }

    @Override
    public SocialEventType socialEventType() {
        return AssetManagementEventTypes.PROCESS_END;
    }

    @Override
    public boolean shouldInterceptThisEvent(Object event) {
        if (event.getClass().getSimpleName().equals(eventToIntercept().getSimpleName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SocialActivitiesEvent toSocial(Object object) {
<<<<<<< Updated upstream
        ProcessEndEvent event = (ProcessEndEvent ) object;
=======
        ProcessStartEvent event = (ProcessStartEvent) object;
>>>>>>> Stashed changes

        return new SocialActivitiesEvent(
<<<<<<< Updated upstream
                new SocialUser(event.getUser()),
=======
                socialUserRepository.systemUser(),
>>>>>>> Stashed changes
                AssetManagementEventTypes.PROCESS_END.name(),
                new Date(event.getTimestamp())
        )
                .withAdicionalInfo("Process: " + event.getProcessName() + " finished on: " + event.getRepositoryAlias());
    }

    @Override
    public List<SocialCommandTypeFilter> getTimelineFilters() {
        return new ArrayList<SocialCommandTypeFilter>();
    }

    @Override
    public List<String> getTimelineFiltersNames() {
        return new ArrayList<String>();
    }
}