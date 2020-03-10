package ru.timmson.load;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

public class NettyServer {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(eventLoopGroup)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new HttpServerInitializer())
                    .channel(NioServerSocketChannel.class);

            Channel ch = bootstrap.bind(8080).sync().channel();
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }


    }

    public static class HttpServerInitializer extends ChannelInitializer<Channel> {

        @Override
        protected void initChannel(Channel ch) {
            ChannelPipeline pipeline = ch.pipeline();

            pipeline.addLast(new HttpServerCodec());
            pipeline.addLast(new HttpServerHandler());
        }

    }

    private static class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
            if (msg instanceof LastHttpContent) {
                System.out.println(Thread.currentThread().getName() + "<--");
                DoSomething doSomething = new DoSomething();
                doSomething.doSomething();
                ByteBuf content = Unpooled.copiedBuffer("ok", CharsetUtil.UTF_8);
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
                response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/plain");
                response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, content.readableBytes());
                ctx.write(response);
                System.out.println(Thread.currentThread().getName() + "-->");
            }
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }
    }
}
