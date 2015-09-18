/*
 * Copyright (C) 2006-2013 Bitronix Software (http://www.bitronix.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bitronix.tm.resource.jdbc;

import java.sql.Connection;

/**
 * Listener of connections created by a PoolingDataSource. Implementations of this class must be serializable
 * and are handed raw, physical database Connections
 *
 * @author Ludovic Orban
 */
public interface ConnectionCustomizer {

    /**
     * Called when the physical connection is created.
     * @param connection the physical connection.
     * @param uniqueName the PoolingDataSource unique name.
     */
    public void onAcquire(Connection connection, String uniqueName);
    
    /**
     * Called when the physical connection is leased from the pool.
     * @param connection the physical connection.
     * @param uniqueName the PoolingDataSource unique name.
     */
    public void onLease(Connection connection, String uniqueName);
    
    /**
     * Called when the physical connection is returned to the pool.
     * @param connection the physical connection.
     * @param uniqueName the PoolingDataSource unique name.
     */
    public void onRelease(Connection connection, String uniqueName);

    /**
     * Called when the physical connection is destroyed.
     * @param connection the physical connection.
     * @param uniqueName the PoolingDataSource unique name.
     */
    public void onDestroy(Connection connection, String uniqueName);

}
