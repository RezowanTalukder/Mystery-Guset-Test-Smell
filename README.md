Test Smell: Mystery Guest

The “Mystery Guest Smell” is test data from outside the test method. This can be some external resource like a file or a database record, or data from external website or data from a general fixture, which is centralized test setup for multiple tests. As such, this test data is disconnected from the rest of the test.


A bigger problem is when this external resource is shared by several tests. Now there is the risk of somebody else editing it without knowing how it’s used, and break our tests. Actually, it doesn’t have to be somebody else, just you working on another feature that uses the same resource. This is a tool for finding mystery guest smell.
