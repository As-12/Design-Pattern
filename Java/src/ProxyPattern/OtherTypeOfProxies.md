
# Proxy Pattern

Proxy provides a surrogate object or a placeholder for another to control access to it.

Though implementation is similar, this is different than a decorator in a sense that proxy does not add responsibility to the class.

## Usages of Proxies

#### Firewall Proxy
Firewall proxy controls access to a set of network resources, protecting the subject from "bad" clients.

#### Smart Reference Proxy
Smart reference proxy provides additional actions whenever a subject is referenced. An example is smart pointer in C++.

#### Caching Proxy
Caching proxy provides temporary storage for operations that are expensive. It can also allow multiple client to share the results to reduce computation or network latency.

#### Synchornization Proxy
Synchronization Proxy provides safe access to an object from multiple thread. This is an access control to provide synchronized access to object in a distributed environment.

#### Copy-On-Write-Proxy
Copy-On-Write-Proxy controls the copying ob the object by deferring the copying of an object until it is absolutely required by a client. 

#### Complexity Hiding Proxy
Complexity hiding proxy hides the complexity of and contains access to complex set of objects. This is often referred to as the Facade Proxy. 

The only different from Facade Pattern is the added access control in the Proxy Pattern.


## Java Dynamic Proxy

Dynamic proxies is a Java language feature that allow one single class with one single method to service multiple method calls to arbitrary classes with an arbitrary number of methods. A dynamic proxy can be thought of as a kind of Facade, but one that can pretend to be an implementation of any interface. Under the cover, it routes all method invocations to a single handler – the invoke() method.

While it's not a tool meant for everyday programming tasks, dynamic proxies can be quite useful for framework writers. It may also be used in those cases where concrete class implementations won't be known until run-time.

This feature is built into the standard JDK, hence no additional dependencies are required.