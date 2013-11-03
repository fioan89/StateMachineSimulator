package org.faur.statemachine.model;

import org.faur.statemachine.api.State;
import org.faur.statemachine.api.Transition;

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
public class GeneralState implements State {
    private Transition nextTransition;
    private static final int SM = 1500;
    @Override
    public void addNextState(State state) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public State getNextState() {
        return this;
    }

    @Override
    public void addNextTransition(Transition transition) {
        nextTransition = transition;
    }

    @Override
    public Transition getNextTransition() {
        return nextTransition;
    }

    @Override
    public void executeState() {
        System.out.println("GeneralState.executeState");
        try {
            Thread.sleep(SM);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outOfState() {
        System.out.println("GeneralState.outOfState");
    }
}
