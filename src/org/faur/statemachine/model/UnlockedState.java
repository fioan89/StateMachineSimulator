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
public class UnlockedState implements State {
    private State nextState;
    private Transition nextTransition;
    private static final int MS = 1000;

    @Override
    public void addNextState(State state) {
        nextState = state;
    }

    @Override
    public State getNextState() {
        return nextState;
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
        System.out.println("UnlockedState is on");
        try {
            Thread.sleep(MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void outOfState() {
        System.out.println("UnlockedState is off");
        try {
            Thread.sleep(MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
