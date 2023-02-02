Feature: Validate MXTransferee Workflow for Transferee-PortionCashout selection, CloningToDifferentClient, Transferee Mobility Journey, PortionCashout and Transferee Submissions ApproveAll Operation

  @CreateOnPointPolicies
  Scenario: CoreFlex - Creating 'OnPoint Enabled' policies in I_R_I_S application
    Given he has created new 'OnPoint Enabled' policies for "13951" client in IRIS application
    