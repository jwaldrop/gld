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

package com.novaordis.gld.service.jms.embedded;

import com.novaordis.gld.service.jms.activemq.ActiveMQService;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class EmbeddedConnectionFactory implements ConnectionFactory
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    public EmbeddedConnectionFactory(String clientUrl)
    {
        if (!ActiveMQService.isEmbedded(clientUrl))
        {
            throw new IllegalArgumentException(clientUrl + " is not an embedded client URL");
        }
    }

    // ConnectionFactory implementation --------------------------------------------------------------------------------

    @Override
    public Connection createConnection() throws JMSException
    {
        return new EmbeddedConnection();
    }

    @Override
    public Connection createConnection(String s, String s1) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return "EmbeddedJMSConnectionFactory[" + "]";
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
