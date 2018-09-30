package com.dotinstall.model
// User : 抽象クラス
// Japnese : 具象クラス
// American :具象クラス

trait Common {
  def getInfo()
}

trait Printable extends Common {
  def print() = println("now printing ...")
  override def getInfo() = println("print")
}

trait Share extends Common {
  def share() = println("now print ...")
  override def getInfo() = println("share")
}

//class User(_name: String) {
  //protected val name = _name
abstract class User(_name :String) {
  val name = _name
  def sayHi()
}

class AdminUser(name: String,val age: Int) extends User(name) with Printable with Share {
    def sayHello () {
      println(s"hello! $name age : $age" )
    }
    def sayHi() {
      println(s"Admin hi! ${this.name}")
    }

//    override def getInfo {
//      super[Printable].getInfo()
//    }
}
