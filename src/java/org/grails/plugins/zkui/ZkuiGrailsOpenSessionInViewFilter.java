/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.zkui;

import org.codehaus.groovy.grails.commons.ApplicationAttributes;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ZkuiGrailsOpenSessionInViewFilter extends OpenSessionInViewFilter {

    @Override
    protected SessionFactory lookupSessionFactory() {
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(ApplicationAttributes.APPLICATION_CONTEXT);

        if (context != null) {
            return context.getBean(getSessionFactoryBeanName(), SessionFactory.class);
        }
        return null;
    }

    @Override
    protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        session.setFlushMode(FlushMode.AUTO);
        return session;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SessionFactory sessionFactory = lookupSessionFactory(request);
        boolean participate = false;

        if (isSingleSession()) {
            // single session mode
            if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
                // Do not modify the Session: just set the participate flag.
                participate = true;
            } else {
                logger.debug("Opening single Hibernate Session in OpenSessionInViewFilter");
                Session session = getSession(sessionFactory);
                TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
            }
        } else {
            // deferred close mode
            if (SessionFactoryUtils.isDeferredCloseActive(sessionFactory)) {
                // Do not modify deferred close: just set the participate flag.
                participate = true;
            } else {
                SessionFactoryUtils.initDeferredClose(sessionFactory);
            }
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            if (!participate) {
                if (isSingleSession()) {
                    if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
                        // single session mode
                        SessionHolder sessionHolder =
                                (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
                        logger.debug("Closing single Hibernate Session in OpenSessionInViewFilter");
                        closeSession(sessionHolder.getSession(), sessionFactory);
                    }

                } else {
                    // deferred close mode
                    SessionFactoryUtils.processDeferredClose(sessionFactory);
                }
            }
        }
    }

    @Override
    protected void closeSession(Session session, SessionFactory sessionFactory) {
        if (!FlushMode.MANUAL.equals(session.getFlushMode())) {
            session.flush();
        }
        super.closeSession(session, sessionFactory);
    }
}
