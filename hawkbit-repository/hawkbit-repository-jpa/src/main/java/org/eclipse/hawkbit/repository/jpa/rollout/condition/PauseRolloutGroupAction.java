/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.repository.jpa.rollout.condition;

import org.eclipse.hawkbit.repository.RolloutManagement;
import org.eclipse.hawkbit.repository.jpa.RolloutGroupRepository;
import org.eclipse.hawkbit.repository.jpa.model.JpaRolloutGroup;
import org.eclipse.hawkbit.repository.model.Rollout;
import org.eclipse.hawkbit.repository.model.RolloutGroup;
import org.eclipse.hawkbit.repository.model.RolloutGroup.RolloutGroupStatus;
import org.eclipse.hawkbit.security.SystemSecurityContext;

/**
 * Error action evaluator which pauses the whole {@link Rollout} and sets the
 * current {@link RolloutGroup} to error.
 */
public class PauseRolloutGroupAction implements RolloutGroupActionEvaluator<RolloutGroup.RolloutGroupErrorAction> {

    private final RolloutManagement rolloutManagement;

    private final RolloutGroupRepository rolloutGroupRepository;

    private final SystemSecurityContext systemSecurityContext;

    public PauseRolloutGroupAction(final RolloutManagement rolloutManagement,
            final RolloutGroupRepository rolloutGroupRepository, final SystemSecurityContext systemSecurityContext) {
        this.rolloutManagement = rolloutManagement;
        this.rolloutGroupRepository = rolloutGroupRepository;
        this.systemSecurityContext = systemSecurityContext;
    }

    @Override
    public RolloutGroup.RolloutGroupErrorAction getAction() {
        return RolloutGroup.RolloutGroupErrorAction.PAUSE;
    }

    @Override
    public void exec(final Rollout rollout, final RolloutGroup rolloutG) {
        final JpaRolloutGroup rolloutGroup = (JpaRolloutGroup) rolloutG;

        systemSecurityContext.runAsSystem(() -> {
            rolloutGroup.setStatus(RolloutGroupStatus.ERROR);
            rolloutGroupRepository.save(rolloutGroup);
            rolloutManagement.pauseRollout(rollout.getId());
            return null;
        });
    }
}
