/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.repository.jpa;

import org.eclipse.hawkbit.repository.jpa.model.DsMetadataCompositeKey;
import org.eclipse.hawkbit.repository.jpa.model.JpaDistributionSetMetadata;
import org.eclipse.hawkbit.repository.model.DistributionSetMetadata;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link DistributionSetMetadata} repository.
 */
@Transactional(readOnly = true)
public interface DistributionSetMetadataRepository
        extends PagingAndSortingRepository<JpaDistributionSetMetadata, DsMetadataCompositeKey>,
        CrudRepository<JpaDistributionSetMetadata, DsMetadataCompositeKey>,
        JpaSpecificationExecutor<JpaDistributionSetMetadata> {

    /**
     * Counts the meta data entries that match the given distribution set ID.
     * 
     * @param id
     *            of the distribution set.
     * 
     * @return The number of matching meta data entries.
     */
    long countByDistributionSetId(@Param("id") Long id);

}
