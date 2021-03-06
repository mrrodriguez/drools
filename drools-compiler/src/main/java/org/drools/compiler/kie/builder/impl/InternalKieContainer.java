/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.drools.compiler.kie.builder.impl;

import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import java.io.InputStream;

public interface InternalKieContainer extends KieContainer {

    /**
     * Returns an already created defualt KieSession for this KieContainer or creates a new one
     * @throws a RuntimeException if this KieContainer doesn't have any defualt KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession getKieSession();

    /**
     * Returns an already created KieSession with the given name for this KieContainer or creates a new one
     * @throws a RuntimeException if this KieContainer doesn't have any defualt KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession getKieSession(String kSessionName);

    StatelessKieSession getStatelessKieSession();

    StatelessKieSession getStatelessKieSession(String kSessionName);

    /**
     * Disposes all the KieSessions created in this KieContainer
     */
    void dispose();

    /**
     * Returns the KieBaseModel for the KieBase with the given name
     */
    KieBaseModel getKieBaseModel(String kBaseName);

    /**
     * Returns the KieSessionModel for the KieSession with the given name
     */
    KieSessionModel getKieSessionModel(String kSessionName);

    ReleaseId getContainerReleaseId();

    long getCreationTimestamp();

    Results updateDependencyToVersion(ReleaseId currentReleaseId, ReleaseId newReleaseId);

    InputStream getPomAsStream();
}
