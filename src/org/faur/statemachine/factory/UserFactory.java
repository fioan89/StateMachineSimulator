package org.faur.statemachine.factory;

/**
 * ****************************************************************************
 * Copyright (c) 2005-2013 Faur Ioan-Aurel.                                     *
 * All rights reserved. This program and the accompanying materials             *
 * are made available under the terms of the MIT License                        *
 * which accompanies this distribution, and is available at                     *
 * http://opensource.org/licenses/MIT                                           *
 * *
 * For any issues or questions send an email at: fioan89@gmail.com              *
 * *****************************************************************************
 */

import org.faur.statemachine.api.Constants;
import org.faur.statemachine.api.OutputPort;
import org.faur.statemachine.api.State;
import org.faur.statemachine.api.Transition;
import org.faur.statemachine.model.GeneralOutputPort;
import org.faur.statemachine.model.GeneralPurposeSM;
import org.faur.statemachine.model.GeneralPurposeTransition;
import org.faur.statemachine.model.GeneralState;

/**
 * Provides output for the turnstile state machine. It consists on outputing coins and
 * enabling the arm machine.
 */
public class UserFactory {
    private static final UserFactory userFactory= new UserFactory();
    private GeneralPurposeSM sm;
    private UserFactory() {
        sm = new GeneralPurposeSM();
        State s = new GeneralState();
        Transition t = new GeneralPurposeTransition();
        OutputPort op = new GeneralOutputPort();
        op.addSyncObject(Constants.SYNC_OBJECT);
        t.setOutputPort(op);
        s.addNextTransition(t);
        sm.addFirstState(s);
    }

    public static UserFactory getInstance() {
        return userFactory;
    }

    public GeneralPurposeSM getUserStateMachine() {
        return sm;
    }
}
