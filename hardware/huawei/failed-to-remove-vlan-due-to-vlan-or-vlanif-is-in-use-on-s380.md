# Failed to Remove Vlan due to Vlan or Vlanif is in Use on Huawei S380

## Problem
* Created VLAN10 on S380
* Failed to remove VLAN10 and prompt error message:

  > The 'must' constraint is not satisfied.

## Root Cause
VLAN10 is in use.
VLAN10 is bound to access HTTPS service of S380.

## Solution
* Method A: Delete rules or settings which use VLAN10
* Method B: Restore factory settings(which will NOT affect upgraded firmware)
