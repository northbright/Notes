
# Disable Keyguard During SetupWizard when SIM is absent

set `keyguard.no_require_sim` to `true` in `build.prop`(xx.mk) to disable Keyguard during SetupWizard when SIM is absent.  
It's set to `true` in Nexus 7 Celluar and it's not set(false) in AOSP by default.

    boolean isLockedOrMissing(IccCardConstants.State state) {
        final boolean requireSim = !SystemProperties.getBoolean("keyguard.no_require_sim",  // read prop
                false);
        return (state.isPinLocked()
                || ((state == IccCardConstants.State.ABSENT
                        || state == IccCardConstants.State.PERM_DISABLED)
                    && requireSim));  // will return false if "keyguard.no_require_sim" == true
    }


    private void doKeyguardLocked(Bundle options) {
        ......
        // if the setup wizard hasn't run yet, don't show
        final boolean provisioned = mUpdateMonitor.isDeviceProvisioned();
        int numPhones = MSimTelephonyManager.getDefault().getPhoneCount();
        final IccCardConstants.State []state = new IccCardConstants.State[numPhones];
        boolean lockedOrMissing = false;
        for (int i = 0; i < numPhones; i++) {
            state[i] = mUpdateMonitor.getSimState(i);
            lockedOrMissing = lockedOrMissing || isLockedOrMissing(state[i]);
            if (lockedOrMissing) break;
        }

        if (!lockedOrMissing && !provisioned) {
            if (DEBUG) Log.d(TAG, "doKeyguard: not showing because device isn't provisioned"
                    + " and the sim is not locked or missing");
            return;  // isLockedOrMissing() return false
        }

        showLocked(options);  // isLockedOrMissing() return true, keyguard.no_require_sim is not set or false
    }
