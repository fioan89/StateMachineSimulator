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
import org.faur.statemachine.api.InputPort;
import org.faur.statemachine.api.State;
import org.faur.statemachine.api.Transition;
import org.faur.statemachine.model.*;

/**
 * A simple model of the turnstile state machine where
 * there are 2 states: the Locked state and the Unlocked state. The machine starts in the first
 * state and if a user inputs coins then the machine goes in to the second state which is the Unlocked state.
 * The transition between the unlocked and locked takes place only if the user pushes the machines arms.
 *
 * More info can be found at: http://en.wikipedia.org/wiki/Finite-state_machine
 */

public class TurnstileFactory {
    private static final TurnstileFactory turnstileFactory = new TurnstileFactory();
    private GeneralPurposeSM turnstileSM;
    private State lockedSate;
    private State unlockedState;

    private Transition lockedTransition;
    private Transition unlockedTransition;

    private InputPort coinInput;
    private InputPort armInput;


    private TurnstileFactory() {
        turnstileSM = new GeneralPurposeSM();
        coinInput = new CoinInputPort();
        coinInput.addSyncObject(Constants.SYNC_OBJECT);
        armInput = new ArmInputPort();
        armInput.addSyncObject(Constants.SYNC_OBJECT);

        lockedSate = new LockedState();
        unlockedState = new UnlockedState();
        lockedTransition = new GeneralPurposeTransition();
        unlockedTransition = new GeneralPurposeTransition();

        lockedTransition.setInputPort(coinInput);
        unlockedTransition.setInputPort(armInput);

        lockedSate.addNextState(unlockedState);
        lockedSate.addNextTransition(lockedTransition);
        unlockedState.addNextState(lockedSate);
        unlockedState.addNextTransition(unlockedTransition);

        turnstileSM.addFirstState(lockedSate);
    }

    public static TurnstileFactory getInstance() {
        return turnstileFactory;
    }

    public GeneralPurposeSM getTurnstileSM() {
        return turnstileSM;
    }
}
