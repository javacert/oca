# oca
Examples for the OCA Certification

General Tips:

- Watch for missing imports when the first shows line numbers and they start with 1
- Check where variable is defined and whether it is in scope
- Watch for key words used in naming things (e.g. switch as a class name)
- GC - watch for incoming object reference parameters and remember the caller still has a reference to that object.
- GC - primitives though are copies, but cannot be set to null so go out of scope when the method returns
- Watch for questions on Cohesion vs Coupling
    --> Cohesion measures the strength of relationship between pieces of functionality within a given module.
        For example, in highly cohesive systems functionality is strongly related.
    --> Coupling - how much change in one class would bring about a change in another class. Watch for access modifier
        and composition - reliance on another class which have not been declared private, not using an interface.
- static and instance class member variables get initialized with reasonable default values as determined by the compiler.
- Method local variables need to be initialized before using them.
- The signature of a method is used to uniquely identify a method - it consists of:
    --> Method Name
    --> Number of parameters
    --> Type of Parameters
    --> Order of the parameters
- Return types and thrown exceptions are not considered to be a part of the method signature.

Interesting discussions:
__________________________________________________________________
When a method is returned, the variables on its stack are always immediately freed(Of course, by freed I mean that the
stack frame gets destroyed, and so does all memory attached to it like local variables).
However, if that variable is an object, then its value is a pointer. The actual memory containing the object
(which may have pointers to other objects as well) would be on the heap. When the reference on the stack gets freed,
the object is just sitting around without anybody referencing it(unless you put a reference somewhere else).
That is when java may come in and garbage collect. That is the object gets flagged for collection,
and the next time the collector runs it will clean up this object.
Primitives have a raw value, and are not pointers. So there is no need to GC them.
This is very much analogous to malloc and free in C.
When you malloc some memory in to a variable in C and your function returns, the memory for that pointer is freed
but not the memory it was pointing to.
When you create an object in java (presumably with the new keyword) you are allocating memory for it.
However, you never explicitly call free in java. The JVM will detect when the freeing needs to be done.
You can set references to null to tell the JVM that you don't need it anymore, but it's often better to just use minimal scope.
__________________________________________________________________