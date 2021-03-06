/*
 * Copyright (c) 2015 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.novaordis.gld.service.jms;

import javax.jms.MessageConsumer;
import javax.jms.Session;

public class Consumer implements JmsEndpoint
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private Session session;
    private MessageConsumer consumer;

    // Constructors ----------------------------------------------------------------------------------------------------

    public Consumer(MessageConsumer consumer, Session session)
    {
        this.consumer = consumer;
        this.session = session;
    }

    // JmsEndpoint implementation --------------------------------------------------------------------------------------

    /**
     * @see com.novaordis.gld.service.jms.JmsEndpoint#close()
     */
    @Override
    public void close() throws Exception
    {
        // do not close the session, it may be reused

        consumer.close();
    }

    @Override
    public Session getSession()
    {
        return session;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    public MessageConsumer getConsumer()
    {
        return consumer;
    }

    @Override
    public String toString()
    {
        return "Consumer[" + consumer + ", " + session + "]";
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
