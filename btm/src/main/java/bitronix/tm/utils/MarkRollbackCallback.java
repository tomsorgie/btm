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
package bitronix.tm.utils;

import javax.transaction.xa.XAException;

/**
 * Mark Rollback Only Callbacks can be used to log the stack of a MarkRollback
 *
 * @author Tom Sorgie
 */
public interface MarkRollbackCallback extends Service {

    /**
     * Handle the markRollback condition
     */
    public void onMarkRollbackOnly();

    
    public static final class NoOpImpl implements MarkRollbackCallback {
    	public static final NoOpImpl INSTANCE = new NoOpImpl();
        @Override public void onMarkRollbackOnly() {
        	//no-op
        }
        @Override public void shutdown() {
        	//no-op
        }

    }
}
