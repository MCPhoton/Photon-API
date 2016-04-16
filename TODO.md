# TODO
Here are the tasks to do for the next API version (or a future one). Update this file when you start working on something,
and when you're done.
- [ ] **Implement all the network packets**. You can find a description of each packet [here](http://wiki.vg/Protocol).
The packets are sorted in different subpackages of `org.mcphoton.network`. A packet's class must have public fields that defines
the data that will be sent or that has been received. For this task, you don't have to implement all the packets at once. You can
implement some packets, make a pull request, implement more and so on.
- [ ] Remove `EventsManager.unregister(Class<E>, EventHandler<? super E>)` and `EventsManager.unregisterAll(Object)`
- [ ] Add `EventsManager.unregisterAll(Plugin)`
- [WIP] Create a `WorldType`
- [WIP] Refractor the `World` interface: `getType()` should return a `WorldType`
- [ ] Allow object creation with a type, for example an entity should be created by calling `MyEntityType.create(some parameters to determine)`
- [ ] In `org.mcphoton.messaging.TextChatMessage.toConsoleString()`, check if the colors are supported by the console. Generally,
the colors are supported on Linux and OSX, but not on Windows.
- [ ] Talk about the protection API (AccessManager, etc.): how to make it better?
