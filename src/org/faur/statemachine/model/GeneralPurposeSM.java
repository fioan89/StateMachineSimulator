package org.faur.statemachine.model;

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

import org.faur.statemachine.api.StateMachine;

public class GeneralPurposeSM extends Thread implements StateMachine {
    private org.faur.statemachine.api.State firstState;
    private volatile boolean threadStopped = false;

    public GeneralPurposeSM() {

    }

    @Override
    public void addFirstState(org.faur.statemachine.api.State state) {
        firstState = state;
    }

    @Override
    public void runStateMachine() {
        threadStopped = false;
        this.start();
    }

    @Override
    public void stopStateMachine() {
        threadStopped = true;
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    public void run() {
        org.faur.statemachine.api.State st = firstState;
        while (!threadStopped && !(Thread.currentThread().isInterrupted())) {
            st.executeState();
            st.outOfState();
            st.getNextTransition().fireTransition();
            st = st.getNextState();
        }

    }
}
