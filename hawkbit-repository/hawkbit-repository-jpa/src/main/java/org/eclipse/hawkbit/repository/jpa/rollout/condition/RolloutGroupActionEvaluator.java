/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.repository.jpa.rollout.condition;

import org.eclipse.hawkbit.repository.model.Rollout;
import org.eclipse.hawkbit.repository.model.RolloutGroup;

/**
 * Interface to define a specific execution for an action
 */
public interface RolloutGroupActionEvaluator<T> {

    T getAction();

    void exec(Rollout rollout, RolloutGroup rolloutGroup);
}
