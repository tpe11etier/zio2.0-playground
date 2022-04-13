package dev.xymox.zio.playground.zhttp

import zhttp.http.{Http, Request, UResponse}
import zhttp.service._
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object BasicServer extends ZIOAppDefault {
  val composedApp: Http[Any, Nothing, Request, UResponse] =
    HelloWorldApp.app +++ HelloWorldApp.jsonApp


  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] =
        Server.start(8080, composedApp).exitCode

}
