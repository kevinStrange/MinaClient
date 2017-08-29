# 本文档介绍:
　1. 记录项目相关的资料，方便以后阅读查看
　2. 本文档为markdown语法
# MINA框架简介:
1. Mina是什么东西？   
Apache MINA 是一个网络应用框架，有助于用户非常方便地开发高性能、高伸缩性的网络应用。它通过Java NIO提供了一个抽象的、事件驱动的、异步的位于各种传输协议（如TCP/IP和UDP/IP）之上的API，Apache MINA 通常可被称之为：
```   
  NIO 框架库；  
  客户端/服务器框架库； 
  或者一个网络socket库。
```   
2. MINA框架的特点有：
基于java NIO类库开发；采用非阻塞方式的异步传输；事件驱动；支持批量数据传输；支持TCP、UDP协议；控制反转的设计模式（支持Spring）；采用优雅的松耦合架构；可灵活的加载过滤器机制；单元测试更容易实现；可自定义线程的数量，以提高运行于多处理器上的性能；采用回调的方式完成调用，线程的使用更容易。 
3. Mina的框架   
当远程客户首次访问采用MINA编写的程序时，IoAcceptor作为线程运行，负责接受来自客户的请求。当有客户请求连接时，创建一个IoSession,该IoSession与IoProcessor、SocketChannel以及IOService联系起来。IoProcessor也作为另外一个线程运行，定时检查客户是否有数据到来，并对客户请求进行处理，依次调用在IOService注册的各个IoFilter，最后调用IoHandler进行最终的逻辑处理，再将处理后的结果Filter后返回给客户端。 
4. Mina的现有应用 
MINA框架的应用比较广泛，应用的开源项目有Apache Directory、AsyncWeb、ApacheQpid、QuickFIX/J、Openfire、SubEthaSTMP、red5等。MINA框架当前稳定版本是1.1.6，最新的2.0版本目前已经发布了M1版本。


